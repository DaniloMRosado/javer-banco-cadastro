package br.com.consulting_delivery.data_manager.domain;

import br.com.consulting_delivery.data_manager.dto.DadosAtualizacaoCliente;
import br.com.consulting_delivery.data_manager.dto.DadosCadastroCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cliente")
@Entity(name = "Cliente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long telefone;
    private Boolean correntista;
    private Float saldo_cc;
    private Boolean ativo;

    public Cliente(DadosCadastroCliente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.correntista = dados.correntista();
        this.saldo_cc = dados.saldo_cc();
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

        if (dados.correntista() != null) {
            this.correntista = dados.correntista();
        }

        if (dados.saldo_cc() != null) {
            this.saldo_cc = dados.saldo_cc();
        }

    }

    public void excluir(Long id) {
        this.ativo = false;
    }
}
