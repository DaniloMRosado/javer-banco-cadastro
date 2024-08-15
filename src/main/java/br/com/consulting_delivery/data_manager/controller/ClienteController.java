package br.com.consulting_delivery.data_manager.controller;

import br.com.consulting_delivery.data_manager.dto.DadosAtualizacaoCliente;
import br.com.consulting_delivery.data_manager.dto.DadosCadastroCliente;
import br.com.consulting_delivery.data_manager.dto.DadosListagemCliente;
import br.com.consulting_delivery.data_manager.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/clientes"})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    public ClienteController() {
    }

    @PostMapping
    public DadosListagemCliente cadastrar(@RequestBody DadosCadastroCliente dadosCadastroCliente) {
        return this.clienteService.salvarCliente( dadosCadastroCliente);
    }

    @GetMapping
    public Page<DadosListagemCliente> listar(Pageable paginacao) {
        return this.clienteService.listar(paginacao);
    }

    @PutMapping
    public DadosListagemCliente atualizar(@RequestBody DadosAtualizacaoCliente dados) {
        return this.clienteService.atualizar(dados);
    }

    @DeleteMapping({"/{id}"})
    public void excluir(@PathVariable Long id) {
        this.clienteService.excluir(id);
    }

    @GetMapping({"/{id}"})
    public DadosListagemCliente getById(@PathVariable Long id) {
        return this.clienteService.getById(id);
    }
}
