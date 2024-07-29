package br.com.consulting_delivery.data_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull(message = "Telefone é obrigatório")
        Long telefone,

        @NotNull(message = "Informe se o cliente é correntista [true/false]")
        Boolean correntista,

        @NotNull(message = "Insira um saldo inicial")
        Float saldo_cc) {



}
