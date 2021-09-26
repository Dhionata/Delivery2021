package br.com.model.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.model.entities.interfaces.FormaPagamentoInterface;
import lombok.Data;

@Entity
@Data
public class FormaPagamento implements FormaPagamentoInterface {
    @Id
    @GeneratedValue
    private Integer id;

    private String nomeForma;

    public FormaPagamento(String nomeForma) {
        setNomeForma(nomeForma);
    }

    public FormaPagamento() {
    }

    @Override
    public String toString() {
        return "\n-- FormaPagamento --\nID: " + getId() + "\nNome da forma de pagamento: " + getNomeForma();
    }

    @Override
    public String formaDePagamento() {
        // TODO Auto-generated method stub
        return null;
    }
}