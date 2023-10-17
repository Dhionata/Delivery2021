package br.com.repository

import br.com.model.entities.classes.ItemPedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemPedidoRepository : JpaRepository<ItemPedido, Int>
