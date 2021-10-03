package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Cliente;
import br.com.model.entities.classes.FormaPagamento;
import br.com.model.entities.classes.Pedido;
import br.com.repository.PedidoRepository;

@RestController
public class PedidoController extends GenericService<Pedido, PedidoRepository> {

    private final String URL = "/pedido";

    @Autowired
    public PedidoController(CrudRepository<Pedido, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Iterable<Pedido> findAll() {
        return super.findAll();
    }

    // public Pedido(Cliente cliente, FormaPagamento formaPagamento, Float desconto,
    // Boolean pago, Boolean entregue
    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save(Cliente cliente, FormaPagamento formaPagamento, Float desconto, Boolean pago, Boolean entregue) {
        return super.save(new Pedido(cliente, formaPagamento, desconto, pago, entregue));
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(Pedido pedido) {
        return super.update(pedido);
    }

    @GetMapping(URL + "/Buscar/")
    public Pedido findById(Integer id) {
        return super.findById(id);
    }
}
