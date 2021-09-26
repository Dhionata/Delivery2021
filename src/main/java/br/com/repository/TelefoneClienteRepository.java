package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Telefone.TelefoneCliente;

@Repository
public interface TelefoneClienteRepository extends CrudRepository<TelefoneCliente, Integer> {

}
