package br.com.model.entities.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.classes.usuario.Cliente;
import br.com.model.entities.interfaces.PedidoInterface;

@Entity
public class Pedido implements PedidoInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ItemPedido> itensPedido;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Cliente cliente;

    @Enumerated(EnumType.ORDINAL)
    private FormaPagamento formaPagamento;

    private Float desconto;
    private Boolean pago = false;
    private Boolean entregue = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_avaliacao")
    private Avaliacao avaliacao;
    private Date data;

    public Pedido(Cliente cliente, FormaPagamento formaPagamento, Float desconto, Boolean pago, Boolean entregue,
            Avaliacao avaliacao) {
        setCliente(cliente);
        setFormaPagamento(formaPagamento);
        setDesconto(desconto);
        setPago(pago);
        setEntregue(entregue);
        setItensPedido(new ArrayList<>());
        setData(new Date());
        setAvaliacao(avaliacao);
    }

    public Pedido(Cliente cliente, FormaPagamento formaPagamento, Float desconto) {
        setCliente(cliente);
        setFormaPagamento(formaPagamento);
        setDesconto(desconto);
        setItensPedido(new ArrayList<>());
        setData(new Date());
    }

    public Pedido(Cliente cliente, FormaPagamento formaPagamento, Float desconto, List<ItemPedido> listaItemPedido) {
        setCliente(cliente);
        setFormaPagamento(formaPagamento);
        setDesconto(desconto);
        setItensPedido(listaItemPedido);
        setData(new Date());
    }

    public Pedido() {
    }

    @Override
    public String toString() {
        return "\n\n-- Pedido -- \nID: " + getId() + "\nData: " + getData() + "\nDesconto: " + getDesconto()
                + "\nEntregue: " + getEntregue() + getItensPedido() + "\n\n-- FormaPagamento --\n" + getFormaPagamento()
                + "\nPago: " + getPago() + getCliente() + "\nValor Total: " + calculaValorTotal(this);
    }

    public Float calculaValorTotal(Pedido pedido) {
        Float total = 0F;

        for (ItemPedido item : pedido.getItensPedido()) {
            for (ProdutoFornecedor produtoFornecedor : item.getProduto().getListaFornecedores()) {
                if (produtoFornecedor.getProduto().equals(item.getProduto())) {
                    total += item.getQuantidade() * produtoFornecedor.getPreco();
                }
            }
        }
        return total;
    }

    public void addItemPedido(ItemPedido itemPedido) {
        getItensPedido().add(itemPedido);
    }

    public void removerItemPedido(ItemPedido itemPedido) {
        getItensPedido().remove(itemPedido);
    }

    // Getters / Setters

    public Integer getId() {
        return id;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}