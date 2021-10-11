package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Pedido;
import br.com.repository.PedidoRepository;

@RestController
@CrossOrigin(origins = "*")
public class PedidoController extends GenericService<Pedido, PedidoRepository> {

    private final String URL = "/pedido";

    @Autowired
    public PedidoController(CrudRepository<Pedido, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<Pedido> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public Object save(@RequestBody Pedido pedido) {
        return super.save(pedido);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody Pedido pedido) {
        return super.remove(pedido);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody Pedido pedido) {
        return super.update(pedido);
    }

    @GetMapping(URL + "/BuscarById/")
    public Pedido findById(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    public Pedido find(@RequestBody Pedido pedido) {
        return super.findById(pedido.getId());
    }
}
