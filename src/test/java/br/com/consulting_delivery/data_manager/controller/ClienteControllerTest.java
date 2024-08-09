package br.com.consulting_delivery.data_manager.controller;

import br.com.consulting_delivery.data_manager.dto.DadosAtualizacaoCliente;
import br.com.consulting_delivery.data_manager.dto.DadosCadastroCliente;
import br.com.consulting_delivery.data_manager.dto.DadosListagemCliente;
import br.com.consulting_delivery.data_manager.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = {ClienteController.class})
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith({MockitoExtension.class})
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    public ClienteControllerTest() {
    }

    @Test
    public void ClienteController_CadastrarCliente_RetornaListagemCliente() throws Exception {
        DadosCadastroCliente dadosCadastro = new DadosCadastroCliente("João", 123456789L, true, 1000.0F);
        DadosListagemCliente dadosListagemCliente = new DadosListagemCliente(1L, "João", 123456789L, true, 1000.0F);

        Mockito.when(this.clienteService.salvarCliente(ArgumentMatchers.any())).thenReturn(dadosListagemCliente);

        String respostaRequisicao =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(dadosCadastro)))
                        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(respostaRequisicao).isEqualTo(this.objectMapper.writeValueAsString(dadosListagemCliente));
    }

    @Test
    public void ClienteController_ListarClientes_RetornaPageDeListagemCliente() throws Exception {
        List<DadosListagemCliente> clientes = new ArrayList<>();

        clientes.add(new DadosListagemCliente(1L, "João", 123456789L, true, 1000.0F));
        clientes.add(new DadosListagemCliente(2L, "Maria", 98989898923L, true, 8000.0F));

        Page<DadosListagemCliente> page = new PageImpl<>(clientes);
        Mockito.when(this.clienteService.listar(ArgumentMatchers.any())).thenReturn(page);

        String respostaRequisicao =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/clientes").contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(page)))
                        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(respostaRequisicao).isEqualTo(this.objectMapper.writeValueAsString(page));
    }

    @Test
    public void ClienteController_AtualizarCliente_RetornaListagemCliente() throws Exception {

        DadosAtualizacaoCliente dadosAtualizacao = new DadosAtualizacaoCliente(1L, (String)null, (Long)null, (Boolean)null, 5500.0F);
        DadosListagemCliente dadosListagemCliente = new DadosListagemCliente(1L, "João", 123456789L, true, 1000.0F);

        Mockito.when(this.clienteService.atualizar(ArgumentMatchers.any())).thenReturn(dadosListagemCliente);

        String respostaRequisicao =
                this.mockMvc.perform(MockMvcRequestBuilders.put("/clientes").contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(dadosAtualizacao)))
                        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(respostaRequisicao).isEqualTo(this.objectMapper.writeValueAsString(dadosListagemCliente));
    }

    @Test
    public void ClienteController_ExcluirCliente_RetornaVoid() throws Exception {
        Long id = 10L;
        Mockito.doNothing().when(this.clienteService).excluir(id);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/clientes/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(id)))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
    }

    @Test
    public void ClienteController_getByIdCliente_RetornaListagemCliente() throws Exception {
        Long id = 1L;

        DadosListagemCliente dadosListagemCliente = new DadosListagemCliente(1L, "João", 123456789L, true, 1000.0F);

        Mockito.when(this.clienteService.getById(ArgumentMatchers.any())).thenReturn(dadosListagemCliente);

        String respostaRequisicao =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/clientes/" + id)
                        .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(id)))
                        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(respostaRequisicao).isEqualTo(this.objectMapper.writeValueAsString(dadosListagemCliente));
    }
}
