package br.com.model.usuario

import br.com.model.*
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import java.util.*

@Entity
data class Fornecedor(
    override var nome: String,
    override var cnpjCpf: String,
    override var senha: String,
    override var email: String,
    override var data: Date = Date(),
    override var tipo: TipoUsuario = TipoUsuario.FORNECEDOR,
    override var enderecos: MutableList<Endereco> = ArrayList(),
    override var telefones: MutableList<Telefone> = ArrayList(),
    override var pedidos: MutableList<Pedido> = ArrayList(),
    var descricao: String? = "Alterar descrição!",
    @field:OneToMany(
        mappedBy = "fornecedor", cascade = [CascadeType.ALL], fetch = FetchType.EAGER
    ) @field:JsonIgnore var listaProdutoFornecedor: MutableList<ProdutoFornecedor> = ArrayList(),
) : Usuario(nome, cnpjCpf, senha, email, data, tipo, enderecos, telefones, pedidos) {

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
        pedidos.filter { pedido: Pedido -> pedido.id == idPedido }
            .forEach { pedido: Pedido -> pedido.entregue = true }
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
