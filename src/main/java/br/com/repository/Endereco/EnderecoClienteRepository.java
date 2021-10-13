package br.com.repository.Endereco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Endereco.EnderecoCliente;

@Repository
public interface EnderecoClienteRepository extends CrudRepository<EnderecoCliente, Integer> {

}
