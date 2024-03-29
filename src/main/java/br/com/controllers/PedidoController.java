package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.services.GenericService;
import br.com.model.entities.classes.Pedido;

@RestController
@CrossOrigin(origins = "*")
public class PedidoController extends GenericService<Pedido, Integer> {

    private final String URL = "/pedido";

    @Autowired
    private PedidoController(CrudRepository<Pedido, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Pedido> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL)
    private Pedido salvar(@RequestBody Pedido pedido) throws Exception {
        return super.save(pedido);
    }

    @DeleteMapping(URL)
    private void remover(@RequestBody Pedido pedido) {
        super.remove(pedido);
    }

    @PatchMapping(URL)
    private Pedido atualizar(@RequestBody Pedido pedido) throws Exception {
        return super.save(pedido);
    }

    @GetMapping(URL + "/{id}")
    private Pedido procurarPorID(@PathVariable Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private Pedido find(@RequestBody Pedido pedido) {
        return super.findById(pedido.getId());
    }

    @Override
    public void validate(Pedido entity) throws Exception {
        if (entity.getItensPedido().isEmpty()) {
            throw new Exception("Pedido não pode ser salvo sem itens");
        }
        if (entity.getCliente() == null) {
            throw new Exception("Pedido não pode ser salvo sem cliente");
        }
        if (entity.getFormaPagamento() == null) {
            throw new Exception("Pedido não pode ser salvo sem forma de pagamento");
        }

    }

    @GetMapping(URL + "/ValorTotal/{id}")
    private float valorTotal(@PathVariable Integer id) {
        return super.findById(id).calculaValorTotal();
    }
}
