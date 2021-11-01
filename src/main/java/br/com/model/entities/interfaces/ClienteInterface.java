package br.com.model.entities.interfaces;

import br.com.model.entities.classes.endereco.EnderecoCliente;
import br.com.model.entities.classes.telefone.TelefoneCliente;

public interface ClienteInterface {
    public void cadastrarEndereco(EnderecoCliente endereco);

    public void removeEndereco(EnderecoCliente endereco);

    public void adicionarTelefone(TelefoneCliente telefone);

    public void removerTelefone(TelefoneCliente telefone);

    public boolean realizarPagamento(Float valor);
}