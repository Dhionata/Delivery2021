package br.com.controllers.Usuario;

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
import br.com.model.entities.classes.Usuario.Usuario;
import br.com.repository.Usuario.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController extends GenericService<Usuario, UsuarioRepository> {

    private final String URL = "/usuario";

    @Autowired
    public UsuarioController(CrudRepository<Usuario, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<Usuario> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public Usuario save(@RequestBody Usuario usuario) throws Exception {
        return super.save(usuario);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody Usuario usuario) {
        return super.remove(usuario);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody Usuario usuario) throws Exception {
        return super.save(usuario);
    }

    @GetMapping(URL + "/BuscarById/")
    public Usuario findById(Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar")
    public Usuario find(@RequestBody Usuario usuario) {
        return super.findById(usuario.getId());
    }
}
