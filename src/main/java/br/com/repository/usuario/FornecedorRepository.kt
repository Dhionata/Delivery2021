package br.com.repository.usuario

import br.com.model.entities.classes.usuario.Fornecedor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FornecedorRepository : CrudRepository<Fornecedor, Int> {
    fun findByCnpjCpf(cnpjCpf: String): Fornecedor
    fun findByEmail(email: String): Fornecedor
}
