package br.com.model.entities.classes.usuario;

import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;

import br.com.model.entities.interfaces.ClienteInterface;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Cliente extends Usuario implements ClienteInterface {

    public Cliente(Usuario usuario) {
        super(usuario);
        setTipo(TipoUsuario.CLIENTE);
    }

    public Cliente(String nome, String cnpjCpf, String senha, String email) {
        super(nome, cnpjCpf, senha, email);
        setTipo(TipoUsuario.CLIENTE);
    }

    public Cliente() {
        super();
        setTipo(TipoUsuario.CLIENTE);
    }

    @Override
    public String toString() {
        return "\n\n--Cliente--\nID: " + super.getId() + "\nNome: " + super.getNome() + "\nCNPJ/CPF: "
                + super.getCnpjCpf() + "\nData: " + super.getData() + "\nEmail: " + super.getEmail() + "\nSenha: "
                + super.getSenha() + "\n-- Lista de telefones --" + super.getTelefones() + "\n-- Lista de Endereços --"
                + super.getEnderecos() + "\nTipo de Usuário: " + super.getTipo();
    }

    @Override
    public boolean realizarPagamento(Float valor) {
        // TODO Auto-generated method stub
        return false;
    }
    // Getters and Setters
}