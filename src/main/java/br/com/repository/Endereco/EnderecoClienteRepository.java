package br.com.repository.endereco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.endereco.EnderecoCliente;

@Repository
public interface EnderecoClienteRepository extends CrudRepository<EnderecoCliente, Integer> {

}
