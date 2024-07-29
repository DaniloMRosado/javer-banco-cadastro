package br.com.consulting_delivery.data_manager.dto;

import br.com.consulting_delivery.data_manager.domain.Cliente;

public record DadosListagemCliente(
        Long id, String nome,
        Long telefone,
        Boolean correntista,
        Float saldo_cc) {


    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getCorrentista(), cliente.getSaldo_cc());
    }
}
