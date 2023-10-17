package br.com.repository.usuario

import br.com.model.entities.classes.usuario.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Int> {
    fun findByEmail(email: String): Usuario
    fun findByCnpjCpf(cnpjCpf: String): Usuario
}
