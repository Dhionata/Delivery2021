package br.com.repository.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.usuario.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}