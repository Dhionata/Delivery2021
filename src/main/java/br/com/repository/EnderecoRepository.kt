package br.com.repository

import br.com.model.entities.classes.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EnderecoRepository : JpaRepository<Endereco, Int>
