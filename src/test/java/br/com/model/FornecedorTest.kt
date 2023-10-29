package br.com.model

import br.com.newObjects.model.NovoProduto
import br.com.newObjects.model.NovoProdutoFornecedor
import br.com.newObjects.model.NovoTelefone.novoTelefone
import br.com.newObjects.model.usuario.NovoFornecedor
import org.junit.jupiter.api.Test

class FornecedorTest {
    @Test
    fun testAdicionarProduto() {
        val a = NovoFornecedor.novoFornecedor()
        a.adicionarProduto(NovoProdutoFornecedor.novoProdutoFornecedor())
        println(a.toString())
    }

    @Test
    fun testAdicionarTelefone() {
        val a = NovoFornecedor.novoFornecedor()
        novoTelefone(a)
        println(a.toString())
    }

    @Test
    fun testAtualizarStatusPedido() {
        // TODO
        // NovoFornecedor.novoFornecedor().atualizarStatusPedido();
    }

    @Test
    fun testBuscarFornecedor() {
        // TODO
    }

    @Test
    fun testConfirmarEntrega() {
        // TODO
        // só dá pra fazer isso se o fornecedor tiver um pedido.
        // NovoFornecedor.novoFornecedor().confirmarEntrega();
    }

    @Test
    fun testConfirmarEstoque() {
        val a = NovoFornecedor.novoFornecedor()
        a.confirmarEstoque(100, NovoProduto.novoProduto())
        println(a.toString())
    }

    @Test
    fun testConfirmarPedido() {
        // TODO
        // Só dá pra fazer isso se o fornecedor tiver um pedido.
        // NovoFornecedor.novoFornecedor().confirmarPedido();
    }
}
