package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.ItemPedido;
import br.com.repository.ItemPedidoRepository;

@RestController
public class ItemPedidoController extends GenericService<ItemPedido, ItemPedidoRepository> {

    private final String URL = "/itemPedido";

    @Autowired
    public ItemPedidoController(CrudRepository<ItemPedido, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Object findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new ItemPedido());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(ItemPedido itemPedido) {
        return super.update(itemPedido);
    }

    @GetMapping(URL + "/Buscar/")
    public ItemPedido findById(Integer id) {
        return super.findById(id);
    }
}
