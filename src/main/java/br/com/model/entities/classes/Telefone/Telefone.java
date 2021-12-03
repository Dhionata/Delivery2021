package br.com.model.entities.classes.telefone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Telefone {
    @Id
    @GeneratedValue
    private Integer id;

    private String numero;

    public Telefone(String numero) {
        setNumero(numero);
    }

    public Telefone(Telefone telefone) {
        setId(telefone.getId());
        setNumero(telefone.getNumero());
    }

    public Telefone() {
    }

    @Override
    public String toString() {
        return "\n\n-- Telefone --\nID: " + getId() + "\nNúmero: " + getNumero();
    }

    // Getters / Setters

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