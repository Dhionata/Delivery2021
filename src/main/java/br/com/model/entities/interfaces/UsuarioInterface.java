package br.com.model.entities.interfaces;

import br.com.model.entities.classes.Telefone;
import br.com.model.entities.classes.endereco.Endereco;

public interface UsuarioInterface {
    public void cadastrarEndereco(Endereco endereco);

    public void removerEndereco(Endereco endereco);

    public void adicionarTelefone(Telefone telefone);

    public void removerTelefone(Telefone telefone);
}