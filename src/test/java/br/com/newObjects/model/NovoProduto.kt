package br.com.newObjects.model

import br.com.model.Produto

object NovoProduto {
    fun novoProduto(): Produto {
        return Produto("Abacate")
    }

    fun novoProduto2(): Produto {
        return Produto("Chocolate")
    }
}
