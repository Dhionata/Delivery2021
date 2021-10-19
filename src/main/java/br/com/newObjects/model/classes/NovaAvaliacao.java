package br.com.newObjects.model.classes;

import br.com.model.entities.classes.Avaliacao;

public class NovaAvaliacao {

    public static Avaliacao novaAvaliacao() {
        return new Avaliacao(5, NovoItemPedido.novoItemPedido(), "teste de comentário");
    }
}
