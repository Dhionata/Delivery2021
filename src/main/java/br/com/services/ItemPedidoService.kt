package br.com.services

import br.com.model.ItemPedido
import br.com.repository.ItemPedidoRepository
import org.springframework.stereotype.Service

@Service
class ItemPedidoService(override val repository: ItemPedidoRepository) : GenericService<ItemPedido, Int>(repository) {

    fun validate(entity: ItemPedido) {
        if (entity.pedido.equals(null)) {
            throw Exception("Não existe avaliação sem pedido!")
        }
    }
}
