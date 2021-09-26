package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Endereco.EnderecoFornecedor;

@Repository
public interface EnderecoFornecedorRepository extends CrudRepository<EnderecoFornecedor, Integer> {

}
