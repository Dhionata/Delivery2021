package br.com.controllers.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.services.GenericService;
import br.com.model.entities.classes.usuario.Usuario;
import br.com.repository.usuario.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController extends GenericService<Usuario, UsuarioRepository> {

    private final String URL = "/usuario";

    @Autowired
    private UsuarioController(CrudRepository<Usuario, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Usuario> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    private Usuario salvar(@RequestBody Usuario usuario) throws Exception {
        return super.save(usuario);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody Usuario usuario) {
        return super.remove(usuario);
    }

    @PatchMapping(URL + "/Atualizar/")
    private Object atualizar(@RequestBody Usuario usuario) throws Exception {
        return super.save(usuario);
    }

    @GetMapping(URL + "/BuscarById/")
    private Usuario procurarPorID(@RequestParam Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar")
    private Usuario find(@RequestBody Usuario usuario) {
        return super.findById(usuario.getId());
    }
}
