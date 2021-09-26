package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}