package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Telefone.TelefoneFornecedor;

@Repository
public interface TelefoneFornecedorRepository extends CrudRepository<TelefoneFornecedor, Integer> {

}
