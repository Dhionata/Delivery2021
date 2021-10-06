package br.com.test.model.classes;

import br.com.model.entities.classes.Avaliacao;

public class testeAvaliacao {
    public static void main(String[] args) {
        System.out.println(novaAvaliacao().toString());
    }

    public static Avaliacao novaAvaliacao() {
        return new Avaliacao(5, testeItemPedido.novoItemPedido(), "teste de comentário");
    }
}
