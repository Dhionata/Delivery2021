package br.com.services

import br.com.model.Pedido
import br.com.repository.PedidoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class PedidoService(@field:Autowired override val repository: PedidoRepository) : GenericService<Pedido, Int>
    (repository) {
    fun validate(entity: Pedido) {
        if (entity.equals(null)) {
            throw Exception("Não existe avaliação sem pedido!")
        }
    }
}
