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
import br.com.model.entities.classes.ItemPedido;
import br.com.repository.ItemPedidoRepository;

@RestController
@CrossOrigin(origins = "*")
public class ItemPedidoController extends GenericService<ItemPedido, ItemPedidoRepository> {

    private final String URL = "/itemPedido";

    @Autowired
    private ItemPedidoController(CrudRepository<ItemPedido, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<ItemPedido> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    private ItemPedido salvar(@RequestBody ItemPedido itemPedido) throws Exception {
        return super.save(itemPedido);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody ItemPedido itemPedido) {
        return super.remove(itemPedido);
    }

    @PatchMapping(URL + "/Atualizar/")
    private ItemPedido atualizar(@RequestBody ItemPedido itemPedido) throws Exception {
        return super.save(itemPedido);
    }

    @GetMapping(URL + "/BuscarById/{id}")
    private ItemPedido procurarPorID(@PathVariable Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private ItemPedido find(@RequestBody ItemPedido itemPedido) {
        return super.findById(itemPedido.getId());
    }
}
