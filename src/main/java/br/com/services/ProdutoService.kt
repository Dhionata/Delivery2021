package br.com.services

import br.com.model.Produto
import br.com.repository.ProdutoRepository
import org.springframework.stereotype.Service

@Service
class ProdutoService(override val repository: ProdutoRepository) :
    GenericService<Produto, Int>(repository) {

    fun validate(entity: Produto) {
        if (entity.equals(null)) {
            throw Exception("Não existe avaliação sem pedido!")
        }
    }
}
