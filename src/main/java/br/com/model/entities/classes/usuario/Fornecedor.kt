package br.com.model.entities.classes.usuario

import br.com.model.entities.classes.Pedido
import br.com.model.entities.classes.Produto
import br.com.model.entities.classes.ProdutoFornecedor
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
data class Fornecedor(
    var usuario: Usuario,
    var descricao: String? = "Alterar descrição!",
    @field:OneToMany(
        mappedBy = "fornecedor", cascade = [CascadeType.ALL], fetch = FetchType.EAGER
    ) @field:JsonIgnore var listaProdutoFornecedor: MutableList<ProdutoFornecedor> = ArrayList()
) : Usuario(
    usuario
) {

    override fun toString(): String {
        return "\n--Fornecedor-- Nome: ${super.nome} ID: ${super.id} CNPJ/CPF: ${super.cnpjCpf}\nData: ${
            super.data
        }\nDescriçao: $descricao\nEndereços: ${super.enderecos}\nTelefones: ${super.telefones}\nEmail: ${
            super.email
        }\nSenha: ${super.senha}\nLista de Produtos: $listaProdutoFornecedor\nTipo de Usuário: ${super.tipo}"
    }

    fun adicionarProduto(produtoFornecedor: ProdutoFornecedor) {
        produtoFornecedor.fornecedor = this
        listaProdutoFornecedor.add(produtoFornecedor)
    }

    fun removerProduto(produto: ProdutoFornecedor) {
        listaProdutoFornecedor.remove(produto)
    }

    fun confirmarEntrega(idPedido: Int) {
        pedidos.filter { pedido: Pedido -> pedido.id == idPedido }.forEach { pedido: Pedido -> pedido.entregue = true }
    }

    fun atualizarStatusPedido(idPedido: Int) {
        // TODO Auto-generated method stub
    }

    fun confirmarEstoque(quantidadePedida: Int, produto: Produto): Boolean {
        var quantidadeTemporaria = 0
        for (produtoFornecedor in listaProdutoFornecedor) {
            if (produtoFornecedor.quantidadeEmEstoque - quantidadePedida > 0 && produtoFornecedor.produto == produto) {
                quantidadeTemporaria = produtoFornecedor.quantidadeEmEstoque
            }
        }
        return quantidadeTemporaria != 0
    }
}
