package br.com.newObjects.model.entities.classes;

import java.util.ArrayList;
import java.util.List;

import br.com.model.entities.classes.Telefone;
import br.com.model.entities.classes.usuario.Usuario;

public class NovoTelefone {

    public static List<Telefone> novaListaTelefones(Usuario usuario) {
        var telefone1 = new Telefone(usuario, "(ii)thhhh-hhhh");
        var telefone2 = new Telefone(usuario, "(yy)qaaaa-zzzz");

        var lista = new ArrayList<Telefone>();
        lista.add(telefone1);
        lista.add(telefone2);
        return lista;
    }

    public static Telefone novoTelefone(Usuario usuario) {
        var telefone = new Telefone(usuario, "(xx)yyyy-yyyy");
        return telefone;
    }
}
