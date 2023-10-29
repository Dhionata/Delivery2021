package br.com.repository.usuario

import br.com.model.usuario.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : JpaRepository<Cliente, Int> {

    fun findByEmail(email: String): Cliente
    fun findByCnpjCpf(cnpjCpf: String): Cliente
}
