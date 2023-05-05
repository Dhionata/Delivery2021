package br.com.newObjects.model.entities.classes;

import br.com.model.entities.classes.Avaliacao;
import br.com.model.entities.classes.Pedido;

public class NovaAvaliacao {

    public static void novaAvaliacao(Pedido pedido) {
        new Avaliacao(5, pedido, "teste de comentário");
    }
}