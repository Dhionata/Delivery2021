package br.com.repository.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.usuario.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer> {
    Fornecedor findByCnpjCpf(String cnpjCpf);

    Fornecedor findByEmail(String email);
}
