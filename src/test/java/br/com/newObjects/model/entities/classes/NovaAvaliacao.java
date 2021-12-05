package br.com.newObjects.model.entities.classes;

import br.com.model.entities.classes.Avaliacao;
import br.com.model.entities.classes.Pedido;

public class NovaAvaliacao {

    public static Avaliacao novaAvaliacao(Pedido pedido) {
        return new Avaliacao(5, pedido, "teste de comentário");
    }
}
