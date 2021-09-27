package br.com.controllers;

import br.com.model.entities.classes.Avaliacao;
import br.com.model.entities.classes.Cliente;
import br.com.model.entities.classes.FormaPagamento;
import br.com.model.entities.classes.ItemPedido;
import br.com.repository.AvaliacaoRepository;
import br.com.repository.ClienteRepository;
import br.com.repository.FormaPagamentoRepository;
import br.com.repository.ItemPedidoRepository;
import br.com.repository.PedidoRepository;
import br.com.repository.ProdutoRepository;
import br.com.model.entities.classes.Pedido;
import br.com.model.entities.classes.Produto;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository repository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @RequestMapping(value = "/avaliacao/teste", method = RequestMethod.GET)
    public Iterable<Avaliacao> post() {

        FormaPagamento formaPagamento = new FormaPagamento("Débito");
        formaPagamentoRepository.save(formaPagamento);

        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");

        clienteRepository.save(cliente);

        Pedido pedido = new Pedido(cliente, formaPagamento, 7.00f, false, false);

        pedidoRepository.save(pedido);

        Avaliacao avaliacao = new Avaliacao(5, pedido, "muito bom");
        repository.save(avaliacao);

        return repository.findAll();
    }
}