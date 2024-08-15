package br.com.consulting_delivery.data_manager.domain;

import br.com.consulting_delivery.data_manager.dto.DadosAtualizacaoCliente;
import br.com.consulting_delivery.data_manager.dto.DadosCadastroCliente;
import jakarta.persistence.*;
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
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private Long telefone;
    @Column(name = "correntista")
    private Boolean correntista;
    @Column(name = "saldo_cc")
    private Float saldoCc;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "cpf")
    private String cpf;

    public Cliente(DadosCadastroCliente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.correntista = dados.correntista();
        this.saldoCc = dados.saldoCc();
        this.cpf = dados.cpf();
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

        if (dados.saldoCc() != null) {
            this.saldoCc = dados.saldoCc();
        }

    }

    public void excluir(Long id) {
        this.ativo = false;
    }
}
