package br.com.repository.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.usuario.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    public Usuario findByEmail(String email);

    public Usuario findByCnpjCpf(String cnpjCpf);
}
