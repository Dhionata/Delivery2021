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
public class testeTudoRepository {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(value = "/testeTudo")
    public Iterable<Pedido> post() {

        FormaPagamento formaPagamento = new FormaPagamento("Débito");

        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");
        EnderecoCliente enderecoCliente = new EnderecoCliente(cliente, "logradouro", "cidade", "bairro", "complemento",
                "cep", "numero", 0f, 0f);
        TelefoneCliente telefoneDoCliente = new TelefoneCliente(cliente, "(xx)yrrrr-rrrr");
        TelefoneCliente telefoneDoCliente2 = new TelefoneCliente(cliente, "(xx)ydddd-dddd");

        Fornecedor fornecedor = new Fornecedor("FornecedorTeste", "Empresa de testes de testes", "000.000.000-08");
        EnderecoFornecedor enderecoFornecedor = new EnderecoFornecedor(fornecedor, "Anhanguera", "Goiânia", "Cerrado",
                "Q.0, L.0", "0000000-00", "S/N", 0.000000F, 0.000000F);
        TelefoneFornecedor telefoneFornecedor = new TelefoneFornecedor(fornecedor, "(ii)thhhh-hhhh");
        TelefoneFornecedor telefoneDoFornecedor = new TelefoneFornecedor(fornecedor, "(yy)qaaaa-zzzz");

        Produto produto = new Produto("Abacate");
        Produto produto2 = new Produto("Laranja");

        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(produto, fornecedor, 0.15f, 3);
        ProdutoFornecedor produtoFornecedor2 = new ProdutoFornecedor(produto2, fornecedor, 8.76f, 7);

        Pedido pedido = new Pedido(cliente, formaPagamento, 7.00f, false, false);

        ItemPedido itemPedido = new ItemPedido(pedido, produto, 1);
        ItemPedido itemPedido2 = new ItemPedido(pedido, produto2, 2);

        Avaliacao avaliacao = new Avaliacao(5, itemPedido, "muito bom");
        Avaliacao avaliacao2 = new Avaliacao(2, itemPedido2, "Até que vai...");

        // Salva todos os dados em cascata (cascade = CascadeType.ALL) em todas às
        // referências em árvore de Pedido.
        pedidoRepository.save(pedido);

        return pedidoRepository.findAll();
    }
}