package br.com.repository;

import br.com.entities.classes.Fornecedor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer> {

}
