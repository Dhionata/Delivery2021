package br.com.services.classes.usuario;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.encrypt.Criptografia;
import br.com.model.entities.classes.usuario.Cliente;
import br.com.repository.usuario.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    protected ResponseEntity<Cliente> salvar(@RequestParam Cliente Cliente) throws Exception {
        var a = clienteRepository.save(Cliente);
        return ResponseEntity.ok(a);
    }

    protected ResponseEntity<Iterable<Cliente>> procurarTodos() {
        var todo = clienteRepository.findAll();
        for (Cliente c : todo) {
            c.setSenha(null);
        }
        return ResponseEntity.ok(todo);
    }

    protected ResponseEntity<String> remover(@RequestParam Cliente Cliente) throws Exception {
        try {
            validate(Cliente);
            clienteRepository.delete(Cliente);
            if (StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
                    .anyMatch(Clientes -> Clientes.equals(Cliente))) {
                throw new Exception("A entidade " + Cliente + " não foi excluída!");
            } else {
                return ResponseEntity.ok("Remoção feita com sucesso!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro na remoção:\n" + e.getMessage());
        }
    }

    protected ResponseEntity<Cliente> atualizar(@RequestParam Cliente Cliente) throws Exception {
        if (Cliente.getId() == null) {
            throw new Exception("\n\nId não pode ser nulo\n\n");
        }
        System.out.println("\n\n-- Usuário Requisição -- Atualizar --\n\n" + Cliente.toString());
        if (Cliente.getSenha() != null) {
            System.out.println("\n\nUsuário tem senha!!!");
            var clienteTemp = new Cliente(Cliente);
            System.out.println("\n\n-- Usuário a ser Atualizado --\n\n" + clienteTemp.toString());
            clienteRepository.save(clienteTemp);
            System.out.println("\n\n-- Usuário atualizado! --\n\n");
            clienteTemp.setSenha(null);
            System.out.println("\n\n-- Usuário retornado! --\n\n" + clienteTemp.toString());
            return ResponseEntity.ok(Cliente);
        } else {
            System.out.println("\n\nUsuário não tem senha!!!");
            System.out.println("\n\n-- Usuário a ser Atualizado --\n\n" + Cliente.toString());
            clienteRepository.save(Cliente);
            System.out.println("\n\n-- Usuário atualizado! --\n\n");
            Cliente.setSenha(null);
            System.out.println("\n\n-- Usuário retornado! --\n\n" + Cliente.toString());
            return ResponseEntity.ok(Cliente);
        }
    }

    protected ResponseEntity<Cliente> procurarPorID(@RequestParam Integer id) {
        System.out.println("\n\n-- ProcurarPorID --");
        var ClienteSemSenha = clienteRepository.findById(id).get();
        ClienteSemSenha.setSenha(null);
        return ResponseEntity.ok(ClienteSemSenha);
    }

    protected ResponseEntity<Cliente> buscarPorCnpjCpf(@RequestParam String cnpjCpf) {
        System.out.println("\n\n\n-- Usuário para Buscar --\n\n\n" + cnpjCpf + "\n\n\n");
        var a = clienteRepository.findByCnpjCpf(cnpjCpf);
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

    protected Cliente autenticaCliente(@RequestParam Cliente Cliente) {
        try {
            System.out.println("\n\n\n-- Usuário para Autenticar --\n\n\n" + Cliente.toString() + "\n\n\n");
            var a = clienteRepository.findByEmail(Cliente.getEmail());
            System.out.println("\n\nExiste um usuário com esse email!\n\n" + a.toString());
            System.out.println("\n\nSenha do usuário: " + a.getSenha() + "\n\n");
            if (Criptografia.verificar(a, Cliente.getSenha())) {
                System.out.println("\n\nAs senhas batem!");
                a.setSenha(null);
                System.out.println("\n\nRetirada a senha para não ser transmitida pela rede!" + a.toString());
                return a;
            } else {
                System.out.println("\n\nAs senhas não batem!\n\n");
                return new Cliente();
            }
        } catch (Exception ex) {
            System.out.println("\n\nDeu ruim..." + ex.getMessage());
            return new Cliente();
        }
    }

    public void validate(Cliente Cliente) throws Exception {
        if (Cliente.getNome().isBlank()) {
            throw new Exception("\n\nNome não pode ser vazio!");
        }
        if (Cliente.getEmail().isBlank()) {
            throw new Exception("\n\nEmail não pode ser vazio!");
        }

        if (Cliente.getCnpjCpf().isBlank()) {
            throw new Exception("\n\nCNPJ/CPF não pode ser vazio!");
        }
    }

}
