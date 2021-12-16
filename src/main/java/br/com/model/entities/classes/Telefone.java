package br.com.model.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.model.entities.classes.usuario.Usuario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Telefone {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String numero;

    public Telefone(Usuario usuario, String numero) {
        setNumero(numero);
        setUsuario(usuario);
        getUsuario().adicionarTelefone(this);
    }

    public Telefone(Usuario usuario, Telefone telefone) {
        setId(telefone.getId());
        setNumero(telefone.getNumero());
        setUsuario(usuario);
        getUsuario().adicionarTelefone(this);
    }

    public Telefone() {
    }

    @Override
    public String toString() {
        return "\n\n-- Telefone --\nID: " + getId() + "\nNúmero: " + getNumero() + "\n\n"; /*
                                                                                            * + "\nUsuário: "
                                                                                            * + getUsuario().getNome();
                                                                                            */
    }

    // Getters / Setters

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}