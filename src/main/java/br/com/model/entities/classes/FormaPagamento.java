package br.com.model.entities.classes;

public enum FormaPagamento {
    DEBITO, CREDITO, PARCELADO, VISTA, BOLETO;

    public static FormaPagamento novaFormaPagamento(Integer i) {
        if (i == 1) {
            return FormaPagamento.DEBITO;
        } else if (i == 2) {
            return FormaPagamento.CREDITO;
        } else if (i == 3) {
            return FormaPagamento.PARCELADO;
        } else if (i == 4) {
            return FormaPagamento.VISTA;
        } else if (i == 5) {
            return FormaPagamento.BOLETO;
        } else {
            return null;
        }
    }
}
// import javax.persistence.Entity;

/*
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.Id;
 * 
 * import br.com.model.entities.interfaces.FormaPagamentoInterface;
 * 
 * @Entity public class FormaPagamento implements FormaPagamentoInterface {
 * 
 * @Id
 * 
 * @GeneratedValue private Integer id;
 * 
 * private String nomeForma;
 * 
 * public FormaPagamento(String nomeForma) { setNomeForma(nomeForma); }
 * 
 * public FormaPagamento() { }
 * 
 * @Override public String toString() { return "\n-- FormaPagamento --\nID: " +
 * getId() + "\nNome da forma de pagamento: " + getNomeForma(); }
 * 
 * @Override public String formaDePagamento() { // TODO Auto-generated method
 * stub return null; }
 * 
 * // Getters / Setters
 * 
 * public Integer getId() { return id; }
 * 
 * public void setId(Integer id) { this.id = id; }
 * 
 * public String getNomeForma() { return nomeForma; }
 * 
 * public void setNomeForma(String nomeForma) { this.nomeForma = nomeForma; }
 */
