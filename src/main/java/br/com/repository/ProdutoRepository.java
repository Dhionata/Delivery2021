package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
