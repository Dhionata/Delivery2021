package br.com.newObjects.model.entities.classes

import br.com.model.entities.classes.ProdutoFornecedor
import br.com.newObjects.model.entities.classes.usuario.NovoFornecedor
import java.util.*

object NovoProdutoFornecedor {
    fun novaListaProdutosFornecedor(): List<ProdutoFornecedor> {
        val fornecedor = NovoFornecedor.novoFornecedor()
        val produtoFornecedor = ProdutoFornecedor(
            NovoProduto.novoProduto(),
            fornecedor,
            Random().nextInt(),
            Random().nextInt(1000).toFloat()
        )
        val produtoFornecedor2 = ProdutoFornecedor(
            NovoProduto.novoProduto2(), fornecedor, Random().nextInt(), Random().nextInt(1000).toFloat()
        )
        val listaProdutoFornecedor: MutableList<ProdutoFornecedor> = ArrayList()
        listaProdutoFornecedor.add(produtoFornecedor)
        listaProdutoFornecedor.add(produtoFornecedor2)
        return listaProdutoFornecedor
    }

    @JvmStatic
    fun novoProdutoFornecedor(): ProdutoFornecedor {
        val fornecedor = NovoFornecedor.novoFornecedor()
        return ProdutoFornecedor(
            NovoProduto.novoProduto(), fornecedor, Random().nextInt(), Random().nextInt(1000).toFloat()
        )
    }
}
