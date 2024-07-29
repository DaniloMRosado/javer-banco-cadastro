package br.com.consulting_delivery.data_manager.service;

import br.com.consulting_delivery.data_manager.domain.Cliente;
import br.com.consulting_delivery.data_manager.dto.DadosAtualizacaoCliente;
import br.com.consulting_delivery.data_manager.dto.DadosCadastroCliente;
import br.com.consulting_delivery.data_manager.dto.DadosListagemCliente;
import br.com.consulting_delivery.data_manager.repository.ClienteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public ClienteService() {
    }

    @Transactional
    public DadosListagemCliente salvarCliente(DadosCadastroCliente dadosCliente) {
        Cliente cliente = new Cliente(dadosCliente);
        this.repository.save(cliente);
        return new DadosListagemCliente(cliente);
    }

    public Page<DadosListagemCliente> listar(Pageable pageable) {
        return this.repository.findAllByAtivoTrue(pageable).map(DadosListagemCliente::new);
    }

    @Transactional
    public DadosListagemCliente atualizar(DadosAtualizacaoCliente dados) {
        Optional<Cliente> cliente = this.repository.findByIdAndAtivoTrue(dados.id());
        if (cliente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            ((Cliente)cliente.get()).atualizarInformacoes(dados);
            return new DadosListagemCliente((Cliente)cliente.get());
        }
    }

    @Transactional
    public void excluir(Long id) {
        Optional<Cliente> cliente = this.repository.findByIdAndAtivoTrue(id);
        if (cliente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            ((Cliente)cliente.get()).excluir(id);
        }
    }

    @Transactional
    public DadosListagemCliente getById(Long id) {
        Optional<Cliente> cliente = this.repository.findByIdAndAtivoTrue(id);
        if (cliente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return new DadosListagemCliente((Cliente)cliente.get());
        }
    }
}
