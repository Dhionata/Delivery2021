package br.com.model.entities.classes.usuario;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.NovoProduto;
import br.com.newObjects.model.entities.classes.NovoProdutoFornecedor;
import br.com.newObjects.model.entities.classes.NovoTelefone;
import br.com.newObjects.model.entities.classes.usuario.NovoFornecedor;

public class FornecedorTest {
    @Test
    void testAdicionarProduto() {
        var a = NovoFornecedor.novoFornecedor();
        a.adicionarProduto(NovoProdutoFornecedor.novoProdutoFornecedor());
        System.out.println(a.toString());
    }

    @Test
    void testAdicionarTelefone() {
        var a = NovoFornecedor.novoFornecedor();
        a.adicionarTelefone(NovoTelefone.novoTelefone(a));
        System.out.println(a.toString());
    }

    @Test
    void testAtualizarStatusPedido() {
        // TODO
        // NovoFornecedor.novoFornecedor().atualizarStatusPedido();
    }

    @Test
    void testBuscarFornecedor() {
        // TODO
    }

    @Test
    void testConfirmarEntrega() {
        // TODO
        // só dá pra fazer isso se o fornecedor tiver um pedido.
        // NovoFornecedor.novoFornecedor().confirmarEntrega();
    }

    @Test
    void testConfirmarEstoque() {
        var a = NovoFornecedor.novoFornecedor();
        a.confirmarEstoque(100, NovoProduto.novoProduto());
        System.out.println(a.toString());
    }

    @Test
    void testConfirmarPedido() {
        // TODO
        // Só dá pra fazer isso se o fornecedor tiver um pedido.
        // NovoFornecedor.novoFornecedor().confirmarPedido();
    }
}
