package br.com.newObjects.model.entities.classes;

import br.com.model.entities.classes.Telefone;
import br.com.model.entities.classes.usuario.Usuario;

public class NovoTelefone {

    public static void novaListaTelefones(Usuario usuario) {
        new Telefone(usuario, "(ii)thhhh-hhhh");
        new Telefone(usuario, "(yy)qaaaa-zzzz");
    }

    public static void novoTelefone(Usuario usuario) {
        new Telefone(usuario, "(xx)yyyy-yyyy");

    }
}
