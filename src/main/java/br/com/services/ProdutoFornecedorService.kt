package br.com.services

import br.com.model.ProdutoFornecedor
import br.com.repository.ProdutoFornecedorRepository
import org.springframework.stereotype.Service

@Service
class ProdutoFornecedorService(override val repository: ProdutoFornecedorRepository) :
    GenericService<ProdutoFornecedor, Int>(repository) {

    fun validate(entity: ProdutoFornecedor) {
        if (entity.equals(null)) {
            throw Exception("Não existe avaliação sem pedido!")
        }
    }
}
