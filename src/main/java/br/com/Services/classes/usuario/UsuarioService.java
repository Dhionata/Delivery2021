package br.com.services.classes.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.encrypt.Criptografia;
import br.com.model.entities.classes.usuario.Usuario;
import br.com.repository.usuario.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    protected ResponseEntity<Usuario> salvar(@RequestParam Usuario usuario) throws Exception {
        System.out.println("\n\n-- Usuário Requisição -- Salvar --\n\n" + usuario.toString());
        var usuarioTemp = new Usuario(usuario);
        System.out.println("\n\n-- Usuário a ser Salvo --\n\n" + usuarioTemp.toString());

        usuarioRepository.save(usuarioTemp);
        usuarioTemp.setSenha(null);
        return ResponseEntity.ok(usuarioTemp);
    }

    protected ResponseEntity<Iterable<Usuario>> procurarTodos() {
        var todos = usuarioRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    protected ResponseEntity<String> remover(@RequestParam Usuario usuario) throws Exception {
        try {
            validate(usuario);
            usuarioRepository.delete(usuario);
            if (usuarioRepository.existsById(usuario.getId())) {
                throw new Exception("A entidade " + usuario + " não foi excluída!");
            } else {
                return ResponseEntity.ok("Remoção feita com sucesso!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro na remoção:\n" + e.getMessage());
        }
    }

    protected ResponseEntity<Usuario> atualizar(@RequestParam Usuario usuario) throws Exception {
        if (usuario.getId() == null) {
            throw new Exception("\n\nId não pode ser nulo\n\n");
        }
        System.out.println("\n\n-- Usuário Requisição -- Atualizar --\n\n" + usuario.toString());

        Usuario usuarioTemp = usuario.getSenha() != null ? new Usuario(usuario) : usuario;
        System.out.println("\n\n-- Usuário a ser Atualizado --\n\n" + usuarioTemp.toString());

        usuarioRepository.save(usuarioTemp);
        System.out.println("\n\n-- Usuário atualizado! --\n\n");

        usuarioTemp.setSenha(null);
        System.out.println("\n\n-- Usuário retornado! --\n\n" + usuarioTemp.toString());

        return ResponseEntity.ok(usuarioTemp);
    }

    protected ResponseEntity<Usuario> procurarPorID(@RequestParam Integer id) {
        System.out.println("\n\n-- ProcurarPorID --");
        var usuarioSemSenha = usuarioRepository.findById(id).get();
        usuarioSemSenha.setSenha(null);
        return ResponseEntity.ok(usuarioSemSenha);
    }

    protected ResponseEntity<Usuario> buscar(@RequestParam String cnpjCpf) {
        System.out.println("\n\n\n-- Usuário para Buscar --\n\n\n" + cnpjCpf + "\n\n\n");
        var a = usuarioRepository.findByCnpjCpf(cnpjCpf);
        if (a != null) {
            System.out.println("\n\nAchou algo no banco de dados!");
            if (a.getCnpjCpf().equals(cnpjCpf)) {
                System.out.println("\n\nEra igual!");
                a.setSenha(null);
                return ResponseEntity.ok(a);
            } else {
                System.out.println("\n\nNÃO Era igual!");
                return ResponseEntity.notFound().build();
            }
        } else {
            System.out.println("NÃO achou nada no banco!");
            return ResponseEntity.notFound().build();
        }
    }

    protected Usuario autenticaUsuario(@RequestParam Usuario usuario) {
        try {
            System.out.println("\n\n\n-- Usuário para Autenticar --\n\n\n" + usuario.toString() + "\n\n\n");
            var a = usuarioRepository.findByEmail(usuario.getEmail());
            System.out.println("\n\nExiste um usuário com esse email!\n\n" + a.toString());
            System.out.println("\n\nSenha do usuário: " + a.getSenha() + "\n\n");
            if (Criptografia.verificar(a, usuario.getSenha())) {
                System.out.println("\n\nAs senhas batem!");
                a.setSenha(null);
                System.out.println("\n\nRetirada a senha para não ser transmitida pela rede!" + a.toString());
                return a;
            } else {
                System.out.println("\n\nAs senhas não batem!\n\n");
                return new Usuario();
            }
        } catch (Exception ex) {
            System.out.println("\n\nDeu ruim..." + ex.getMessage());
            return new Usuario();
        }
    }

    public void validate(Usuario usuario) throws Exception {
        if (usuario.getNome().isBlank()) {
            throw new Exception("\n\nNome não pode ser vazio!");
        }
        if (usuario.getEmail().isBlank()) {
            throw new Exception("\n\nEmail não pode ser vazio!");
        }

        if (usuario.getCnpjCpf().isBlank()) {
            throw new Exception("\n\nCNPJ/CPF não pode ser vazio!");
        }
    }
}
