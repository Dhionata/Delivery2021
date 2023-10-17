package br.com.repository.usuario

import br.com.model.entities.classes.usuario.Cliente
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : CrudRepository<Cliente, Int> {
    fun findByEmail(email: String): Cliente
    fun findByCnpjCpf(cnpjCpf: String): Cliente
}
