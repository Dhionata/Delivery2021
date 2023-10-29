package br.com.model

import jakarta.persistence.*

@Entity
data class Produto(
    var nome: String,

    @field:OneToMany(
        mappedBy = "produto",
        cascade = [CascadeType.ALL],
        fetch = FetchType.EAGER
    ) var listaFornecedores: MutableList<ProdutoFornecedor> = ArrayList(),
    var isDisponivel: Boolean = true
) {
    @field:Id
    @field:GeneratedValue
    var id: Int? = null

    override fun toString(): String {
        return "--Produto--\nID: ${id}\nNome: ${nome}\nLista de Fornecedores: ${listaFornecedores}\nDisponibilidade: $isDisponivel"
    }

    fun adicionarFornecedor(produtoFornecedor: ProdutoFornecedor) {
        produtoFornecedor.produto = this
        listaFornecedores.add(produtoFornecedor)
    }
}
