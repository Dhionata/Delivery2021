package br.com.repository;

import br.com.entities.classes.ProdutoFornecedor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoFornecedorRepository extends CrudRepository<ProdutoFornecedor, Integer> {

}
