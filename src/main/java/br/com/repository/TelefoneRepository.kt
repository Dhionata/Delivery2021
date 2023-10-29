package br.com.repository

import br.com.model.Telefone
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TelefoneRepository : JpaRepository<Telefone, Int>
