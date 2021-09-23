package br.com.repository;

import br.com.entities.classes.Endereco.EnderecoCliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoClienteRepository extends CrudRepository<EnderecoCliente, Integer> {

}
