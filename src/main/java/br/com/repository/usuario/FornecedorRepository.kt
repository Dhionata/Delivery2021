package br.com.repository.usuario

import br.com.model.usuario.Fornecedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FornecedorRepository : JpaRepository<Fornecedor, Int> {
    fun findByCnpjCpf(cnpjCpf: String): Fornecedor
    fun findByEmail(email: String): Fornecedor
}
