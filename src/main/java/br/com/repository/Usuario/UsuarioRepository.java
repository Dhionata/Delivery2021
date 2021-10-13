package br.com.repository.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Usuario.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
