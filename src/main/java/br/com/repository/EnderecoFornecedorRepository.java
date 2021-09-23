package br.com.repository;

import br.com.entities.classes.Endereco.EnderecoFornecedor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoFornecedorRepository extends CrudRepository<EnderecoFornecedor, Integer> {

}
