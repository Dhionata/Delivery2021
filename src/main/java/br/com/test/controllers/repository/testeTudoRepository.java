
package br.com.test.controllers.repository;

import br.com.model.entities.classes.Avaliacao;
import br.com.model.entities.classes.Cliente;
import br.com.model.entities.classes.FormaPagamento;
import br.com.model.entities.classes.Fornecedor;
import br.com.model.entities.classes.ItemPedido;
import br.com.repository.PedidoRepository;
import br.com.model.entities.classes.Pedido;
import br.com.model.entities.classes.Produto;
import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.classes.Endereco.EnderecoCliente;
import br.com.model.entities.classes.Endereco.EnderecoFornecedor;
import br.com.model.entities.classes.Telefone.TelefoneCliente;
import br.com.model.entities.classes.Telefone.TelefoneFornecedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteTudoRepository {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(value = "/testeTudo")
    public Iterable<Pedido> post() {

        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");
        new EnderecoCliente(cliente, "logradouro", "cidade", "bairro", "complemento", "cep", "numero", 0f, 0f);
        new TelefoneCliente(cliente, "(xx)yrrrr-rrrr");
        new TelefoneCliente(cliente, "(xx)ydddd-dddd");

        Fornecedor fornecedor = new Fornecedor("FornecedorTeste", "Empresa de testes de testes", "000.000.000-08");
        new EnderecoFornecedor(fornecedor, "Anhanguera", "Goiânia", "Cerrado", "Q.0, L.0", "0000000-00", "S/N",
                0.000000F, 0.000000F);
        new TelefoneFornecedor(fornecedor, "(ii)thhhh-hhhh");
        new TelefoneFornecedor(fornecedor, "(yy)qaaaa-zzzz");

        Produto produto = new Produto("Abacate");
        Produto produto2 = new Produto("Laranja");

        new ProdutoFornecedor(produto, fornecedor, 0.15f, 3);
        new ProdutoFornecedor(produto2, fornecedor, 8.76f, 7);

        Pedido pedido = new Pedido(cliente, FormaPagamento.DEBITO, 7.00f);

        ItemPedido itemPedido = new ItemPedido(pedido, produto, 1);
        ItemPedido itemPedido2 = new ItemPedido(pedido, produto2, 2);

        new Avaliacao(5, itemPedido, "muito bom");
        new Avaliacao(2, itemPedido2, "Até que vai...");

        // Salva todos os dados em cascata (cascade = CascadeType.ALL) em todas às
        // referências em árvore de Pedido.

        return pedidoRepository.findAll();
    }
}