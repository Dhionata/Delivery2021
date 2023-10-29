package br.com.repository.usuario

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import br.com.model.usuario.Usuario
import jakarta.transaction.Transactional

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Int> {
    @Transactional
    fun findByEmail(email: String): Usuario
    @Transactional
    fun findByCnpjCpf(cnpjCpf: String): Usuario
}
