package br.com.model.entities.classes.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.classes.Produto;
import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.interfaces.FornecedorInterface;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Fornecedor extends Usuario implements FornecedorInterface {
    private String descricao;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProdutoFornecedor> listaProdutos;

    public Fornecedor(String nome, String descricao, String cnpjCpf,
            String senha, String email) {
        super(cnpjCpf, nome, senha, email, TipoUsuario.FORNECEDOR);
        setDescricao(descricao);
        setListaProdutoFornecedor(new ArrayList<ProdutoFornecedor>());
    }

    public Fornecedor(Usuario usuario, String descricao,
            List<ProdutoFornecedor> listaProdutoFornecedor) {
        super(usuario);
        setTipo(TipoUsuario.FORNECEDOR);
        setDescricao(descricao);
        setListaProdutoFornecedor(listaProdutoFornecedor);
    }

    public Fornecedor() {
        super();
    }

    @Override
    public String toString() {
        return "\n\n--Fornecedor--\nNome: " + super.getNome() + "\nID: " + super.getId() + "\nCNPJ/CPF: "
                + super.getCnpjCpf() + "\nData: " + super.getData() + "\nDescriçao: " + getDescricao()
                + super.getEnderecos() + super.getTelefones() + "\nEmail: " + super.getEmail() + "\nSenha: "
                + super.getSenha() + "\nLista de Produtos: " + getListaProdutoFornecedor() + "\nTipo de Usuário: "
                + super.getTipo();
    }

    @Override
    public void adicionarProduto(ProdutoFornecedor produtoFornecedor) {
        produtoFornecedor.setFornecedor(this);
        getListaProdutoFornecedor().add(produtoFornecedor);
    }

    @Override
    public boolean confirmarPedido(int idPedido) {
        // TODO blz
        // getPedidos().stream().filter(p -> p.getId() == idPedido).forEach(p ->
        // p.getPago("Confirmado"));
        return false;
    }

    @Override
    public void removeProduto(ProdutoFornecedor produto) {
        getListaProdutoFornecedor().remove(produto);
    }

    @Override
    public void confirmarEntrega(int idPedido) {
        getPedidos().stream().filter(pedido -> pedido.getId() == idPedido).forEach(pedido -> pedido.setEntregue(true));
    }

    @Override
    public void atualizarStatusPedido(int idPedido) {
        // TODO Auto-generated method stub

    }

    @Override
    public Fornecedor buscarFornecedor(String nome) {
        // Verificar a possibilidade de uma lista de fornecedores.
        // 2.0 verificar a possibilidade de retornar uma lista de fornecedores através
        // do repository.
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean confirmarEstoque(int quantidadePedida, Produto produto) {
        var quantidadeTemporaria = 0;
        for (ProdutoFornecedor produtoFornecedor : getListaProdutoFornecedor()) {
            if ((produtoFornecedor.getQuantidadeEmEstoque() - quantidadePedida) > 0
                    && produtoFornecedor.getProduto().equals(produto)) {
                quantidadeTemporaria = produtoFornecedor.getQuantidadeEmEstoque();
            }
        }
        if (quantidadeTemporaria != 0) {
            return true;
        } else {
            return false;
        }
    }

    // Getters / Setters

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ProdutoFornecedor> getListaProdutoFornecedor() {
        return listaProdutos;
    }

    public void setListaProdutoFornecedor(List<ProdutoFornecedor> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}