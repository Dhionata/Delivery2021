package br.com.repository.Endereco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.endereco.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

}
