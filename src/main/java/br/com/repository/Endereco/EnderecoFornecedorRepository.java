package br.com.repository.Endereco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.endereco.EnderecoFornecedor;

@Repository
public interface EnderecoFornecedorRepository extends CrudRepository<EnderecoFornecedor, Integer> {

}
