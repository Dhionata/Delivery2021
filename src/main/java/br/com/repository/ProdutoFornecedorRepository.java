package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.ProdutoFornecedor;

@Repository
public interface ProdutoFornecedorRepository extends CrudRepository<ProdutoFornecedor, Integer> {

}
