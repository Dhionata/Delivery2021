package br.com.model.entities.classes

import br.com.model.entities.classes.usuario.Cliente
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*

@Entity
data class Pedido(
    @field:OneToMany(
        mappedBy = "pedido", cascade = [CascadeType.ALL], fetch = FetchType.LAZY
    ) @field:JsonIgnore var itensPedido: MutableList<ItemPedido> = ArrayList(),

    @field:ManyToOne(cascade = [CascadeType.ALL]) @field:JoinColumn(name = "id_usuario") var cliente: Cliente,

    @field:Enumerated var formaPagamento: FormaPagamento,
    var desconto: Float = 0f,

    var pago: Boolean = false,
    var entregue: Boolean = false,

    @field:OneToOne(cascade = [CascadeType.ALL]) @field:JoinColumn(name = "id_avaliacao") var avaliacao: Avaliacao? = null,
    var data: Date = Date()
) {
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null
    override fun toString(): String {
        return "-- Pedido --\nID: ${id}\nData: ${data}\nDesconto: ${desconto}\nEntregue: ${entregue}\n${itensPedido}\n-- FormaPagamento --\n${formaPagamento}\nPago: ${pago}${cliente}\nValor Total: ${calculaValorTotal()}"
    }

    fun calculaValorTotal(): Float {
        return itensPedido.map { item ->
            item.produto.listaFornecedores.filter { it.produto == item.produto }.map { it.preco * item.quantidade }
                .sum()
        }.sum()
    }
}
