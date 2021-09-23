package br.com.repository;

import br.com.entities.classes.Telefone.TelefoneCliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneClienteRepository extends CrudRepository<TelefoneCliente, Integer> {

}
