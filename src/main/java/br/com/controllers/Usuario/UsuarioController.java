package br.com.controllers.usuario;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.entities.classes.usuario.Usuario;
import br.com.services.classes.usuario.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController extends UsuarioService {

    private final String URL = "/usuario";

    @GetMapping(URL + "/all")
    protected ResponseEntity<Iterable<Usuario>> procurarTodos() {
        return super.procurarTodos();
    }

    @PostMapping(URL)
    protected ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) throws Exception {
        return super.salvar(usuario);
    }

    @DeleteMapping(URL)
    protected ResponseEntity<String> remover(@RequestBody Usuario usuario) throws Exception {
        return super.remover(usuario);
    }

    @PatchMapping(URL)
    protected ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) throws Exception {
        return super.atualizar(usuario);
    }

    @GetMapping(URL + "/{id}")
    protected ResponseEntity<Usuario> procurarPorID(@PathVariable Integer id) {
        return super.procurarPorID(id);
    }

    @GetMapping(URL + "/buscar")
    private ResponseEntity<Usuario> buscar(@RequestBody Map<String, String> cnpjCpf) {
        return super.buscar(cnpjCpf.get("cnpjCpf"));
    }

    @PostMapping(URL + "/AutenticarUsuario/")
    protected Usuario autenticaUsuario(@RequestBody Usuario usuario) {
        return super.autenticaUsuario(usuario);
    }

}
