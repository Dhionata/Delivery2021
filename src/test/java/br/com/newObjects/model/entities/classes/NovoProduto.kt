package br.com.newObjects.model.entities.classes

import br.com.model.entities.classes.Produto

object NovoProduto {
    @JvmStatic
    fun novoProduto(): Produto {
        return Produto("Abacate")
    }

    fun novoProduto2(): Produto {
        return Produto("Chocolate")
    }
}
