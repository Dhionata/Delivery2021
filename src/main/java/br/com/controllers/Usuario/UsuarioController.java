package br.com.controllers.usuario;

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
        var todo = super.findAll();
        todo.forEach(action -> action.setSenha(null));
        return todo;
    }

    @PostMapping(value = URL + "/Adicionar/")
    private Usuario salvar(@RequestBody Usuario usuario) throws Exception {
        System.out.println("\n\n-- Usuário Requisição -- Salvar --\n\n" + usuario.toString());
        var usuarioTemp = new Usuario(usuario);
        System.out.println("\n\n-- Usuário a ser Salvo --\n\n" + usuarioTemp.toString());
        System.out.println(usuarioTemp.toString());
        super.save(usuarioTemp);
        System.out.println("\n\n-- Usuário Salvo --\n\n" + usuarioTemp.toString());
        usuarioTemp.setSenha(null);
        System.out.println("\n\n-- Usuário retornado! --\n\n" + usuarioTemp.toString());
        return usuarioTemp;
    }

    @DeleteMapping(URL + "/Remover/")
    // TODO verificar retorno, não está funcionando quando Object ou String
    private void remover(@RequestBody Usuario usuario) throws Exception {
        super.remove(usuario);
        System.out.println("Remoção feita com sucesso");
    }

    @PatchMapping(URL + "/Atualizar/")
    private Usuario atualizar(@RequestBody Usuario usuario) throws Exception {
        System.out.println("\n\n-- Usuário Requisição -- Atualizar --\n\n" + usuario.toString());
        if (usuario.getSenha() != null) {
            var usuarioTemp = new Usuario(usuario);
            System.out.println("\n\n-- Usuário a ser Atualizado --\n\n" + usuarioTemp.toString());
            super.save(usuarioTemp);
            System.out.println("\n\n-- Usuário atualizado! --\n\n");
            usuarioTemp.setSenha(null);
            System.out.println("\n\n-- Usuário retornado! --\n\n" + usuarioTemp.toString());
            return usuarioTemp;
        } else {
            System.out.println("\n\n-- Usuário a ser Atualizado --\n\n" + usuario.toString());
            super.save(usuario);
            System.out.println("\n\n-- Usuário atualizado! --\n\n");
            usuario.setSenha(null);
            System.out.println("\n\n-- Usuário retornado! --\n\n" + usuario.toString());
            return usuario;
        }
    }

    @GetMapping(URL + "/BuscarById/{id}")
    private Usuario procurarPorID(@PathVariable Integer id) {
        var usuarioSemSenha = super.findById(id);
        usuarioSemSenha.setSenha(null);
        return usuarioSemSenha;
    }

    @GetMapping(URL + "/Buscar")
    private Usuario find(@RequestBody Usuario usuario) {
        System.out.println("\n\n\n-- Usuário para Buscar --\n\n\n" + usuario.toString() + "\n\n\n");
        var a = buscar(usuario);
        return a;
    }
    
    public Usuario buscar(Usuario entity) {
        var a = super.findAll();
        for (var b : a) {
            System.out.println("\n\nUsuário a ser comparado....\n\n" + b.toString());
            if (b.getEmail().equals(entity.getEmail()) && b.getNome().equals(entity.getNome())
                    && b.getCnpjCpf().equals(entity.getCnpjCpf())) {
                System.out.println("\n\nOS USUÁRIO SÃO IGUAIS!\n\n");
                return b;
            }
        }
        return null;
    }
}
