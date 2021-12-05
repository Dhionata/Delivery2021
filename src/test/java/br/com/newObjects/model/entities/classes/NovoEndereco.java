package br.com.newObjects.model.entities.classes;

import java.util.ArrayList;
import java.util.List;

import br.com.model.entities.classes.Endereco;
import br.com.model.entities.classes.usuario.Usuario;

public class NovoEndereco {

    public static List<Endereco> novaListaEndereco(Usuario usuario) {
        Endereco endereco1 = new Endereco(usuario , "logradouro", "cidade", "bairro", "complemento",
                "cep", "numero", 0f, 0f);
        Endereco endereco2 = new Endereco(usuario , "logradouro2", "cidade2", "bairro2",
                "complemento2", "cep2", "numero2", 0f, 0f);

        List<Endereco> novaListaEndereco = new ArrayList<>();
        novaListaEndereco.add(endereco1);
        novaListaEndereco.add(endereco2);

        return novaListaEndereco;
    }
}
