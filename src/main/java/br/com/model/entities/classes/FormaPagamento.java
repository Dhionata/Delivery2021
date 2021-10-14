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