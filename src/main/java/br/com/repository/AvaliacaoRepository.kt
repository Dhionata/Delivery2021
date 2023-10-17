package br.com.repository

import br.com.model.entities.classes.Avaliacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AvaliacaoRepository : JpaRepository<Avaliacao, Int>
