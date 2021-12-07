package br.com.newObjects.model.entities.classes;

import br.com.model.entities.classes.Endereco;
import br.com.model.entities.classes.usuario.Usuario;

public class NovoEndereco {

    public static void novaListaEndereco(Usuario usuario) {
        new Endereco(usuario, "logradouro", "cidade", "bairro", "complemento",
                "cep", "numero", 0f, 0f);
        new Endereco(usuario, "logradouro2", "cidade2", "bairro2",
                "complemento2", "cep2", "numero2", 0f, 0f);

    }
}
