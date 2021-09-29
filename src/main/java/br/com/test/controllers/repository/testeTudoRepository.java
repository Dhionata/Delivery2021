package br.com.test.controllers.repository;

import br.com.model.entities.classes.Avaliacao;
import br.com.model.entities.classes.Cliente;
import br.com.model.entities.classes.FormaPagamento;
import br.com.model.entities.classes.Fornecedor;
import br.com.model.entities.classes.ItemPedido;
import br.com.repository.AvaliacaoRepository;
import br.com.repository.ClienteRepository;
import br.com.repository.FormaPagamentoRepository;
import br.com.repository.FornecedorRepository;
import br.com.repository.ItemPedidoRepository;
import br.com.repository.PedidoRepository;
import br.com.repository.ProdutoFornecedorRepository;
import br.com.repository.ProdutoRepository;
import br.com.model.entities.classes.Pedido;
import br.com.model.entities.classes.Produto;
import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.classes.Endereco.EnderecoCliente;
import br.com.model.entities.classes.Endereco.EnderecoFornecedor;
import br.com.model.entities.classes.Telefone.TelefoneCliente;
import br.com.model.entities.classes.Telefone.TelefoneFornecedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testeTudoRepository {

    @Autowired
    private PedidoRepository pedidoRepository;
    /* @Autowired
    private AvaliacaoRepository repository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private ProdutoFornecedorRepository produtoFornecedorRepository; */

    @RequestMapping(value = "/testeTudo", method = RequestMethod.GET)
    public Iterable<Pedido> post() {

        FormaPagamento formaPagamento = new FormaPagamento("Débito");
        // formaPagamentoRepository.save(formaPagamento);

        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");
        EnderecoCliente enderecoCliente = new EnderecoCliente(cliente, "logradouro", "cidade", "bairro", "complemento",
                "cep", "numero", 0f, 0f);
        TelefoneCliente telefoneDoCliente = new TelefoneCliente(cliente, "(xx)yrrrr-rrrr");
        TelefoneCliente telefoneDoCliente2 = new TelefoneCliente(cliente, "(xx)ydddd-dddd");
        // clienteRepository.save(cliente);

        Fornecedor fornecedor = new Fornecedor("FornecedorTeste", "Empresa de testes de testes", "000.000.000-08");
        EnderecoFornecedor enderecoFornecedor = new EnderecoFornecedor(fornecedor, "Anhanguera", "Goiânia", "Cerrado",
                "Q.0, L.0", "0000000-00", "S/N", 0.000000F, 0.000000F);
        TelefoneFornecedor telefoneFornecedor = new TelefoneFornecedor(fornecedor, "(ii)thhhh-hhhh");
        TelefoneFornecedor telefoneDoFornecedor = new TelefoneFornecedor(fornecedor, "(yy)qaaaa-zzzz");
        // fornecedorRepository.save(fornecedor);

        Produto produto = new Produto("Abacate");
        Produto produto2 = new Produto("Laranja");
        // produtoRepository.save(produto);
        // produtoRepository.save(produto2);

        // ligação entre Fornecedor e Produto é FornecedorProduto
        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(produto, fornecedor, 0.15f, 3);
        ProdutoFornecedor produtoFornecedor2 = new ProdutoFornecedor(produto2, fornecedor, 8.76f, 7);
        // produtoFornecedorRepository.save(produtoFornecedor);
        // produtoFornecedorRepository.save(produtoFornecedor2);

        Pedido pedido = new Pedido(cliente, formaPagamento, 7.00f, false, false);

        ItemPedido itemPedido = new ItemPedido(pedido, produto, 1);
        ItemPedido itemPedido2 = new ItemPedido(pedido, produto2, 2);
        // itemPedidoRepository.save(itemPedido);
        // itemPedidoRepository.save(itemPedido2);

        Avaliacao avaliacao = new Avaliacao(5, itemPedido, "muito bom");
        Avaliacao avaliacao2 = new Avaliacao(2, itemPedido2, "Até que vai...");
        // repository.save(avaliacao);
        // Salva todos os dados em cascata (cascade = CascadeType.ALL) em todas às
        // referências em árvore de Pedido.
        pedidoRepository.save(pedido);

        return pedidoRepository.findAll();
    }
}