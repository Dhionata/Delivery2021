package br.com.repository;

import br.com.entities.classes.Telefone.TelefoneFornecedor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneFornecedorRepository extends CrudRepository<TelefoneFornecedor, Integer> {

}
