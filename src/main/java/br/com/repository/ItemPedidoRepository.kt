package br.com.repository

import br.com.model.ItemPedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemPedidoRepository : JpaRepository<ItemPedido, Int>
