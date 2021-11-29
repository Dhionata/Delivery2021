package br.com.newObjects.model.entities.classes;

import br.com.model.entities.classes.Avaliacao;
import br.com.model.entities.classes.ItemPedido;

public class NovaAvaliacao {

    public static Avaliacao novaAvaliacao(ItemPedido itemPedido) {
        return new Avaliacao(5, itemPedido, "teste de comentário");
    }
}
