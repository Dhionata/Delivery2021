package br.com.model.entities.classes.Telefone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
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
        return "\n-- Telefone --\nID: " + getId() + "\nNúmero: " + getNumero();
    }

}