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
import br.com.repository.PedidoRepository;

@RestController
@CrossOrigin(origins = "*")
public class PedidoController extends GenericService<Pedido, PedidoRepository> {

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

    @PostMapping(value = URL + "/Adicionar/")
    private Pedido salvar(@RequestBody Pedido pedido) throws Exception {
        return super.save(pedido);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody Pedido pedido) {
        return super.remove(pedido);
    }

    @PatchMapping(URL + "/Atualizar/")
    private Pedido atualizar(@RequestBody Pedido pedido) throws Exception {
        return super.save(pedido);
    }

    @GetMapping(URL + "/BuscarById/{id}")
    private Pedido procurarPorID(@PathVariable Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private Pedido find(@RequestBody Pedido pedido) {
        return super.findById(pedido.getId());
    }
}
