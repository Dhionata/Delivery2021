package br.com.services.classes.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.encrypt.Criptografia;
import br.com.model.entities.classes.usuario.Fornecedor;

@Service
public class FornecedorService {

    @Autowired
    private br.com.repository.usuario.FornecedorRepository fornecedorRepository;

    protected ResponseEntity<Fornecedor> salvar(@RequestParam Fornecedor fornecedor) throws Exception {
        System.out.println("\n\n-- Usuário Requisição -- Salvar --\n\n" + fornecedor.toString());
        var fornecedorTemp = new Fornecedor(fornecedor);
        System.out.println("\n\n-- Usuário a ser Salvo --\n\n" + fornecedorTemp.toString());

        fornecedorRepository.save(fornecedorTemp);
        fornecedorTemp.setSenha(null);
        return ResponseEntity.ok(fornecedorTemp);
    }

    protected ResponseEntity<Iterable<Fornecedor>> procurarTodos() {
        var todos = fornecedorRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    protected ResponseEntity<String> remover(@RequestParam Fornecedor Fornecedor) throws Exception {
        try {
            validate(Fornecedor);
            fornecedorRepository.delete(Fornecedor);
            if (fornecedorRepository.existsById(Fornecedor.getId())) {
                throw new Exception("A entidade " + Fornecedor + " não foi excluída!");
            } else {
                return ResponseEntity.ok("Remoção feita com sucesso!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro na remoção:\n" + e.getMessage());
        }
    }

    protected ResponseEntity<Fornecedor> atualizar(@RequestParam Fornecedor Fornecedor) throws Exception {
        if (Fornecedor.getId() == null) {
            throw new Exception("\n\nId não pode ser nulo\n\n");
        }
        System.out.println("\n\n-- Usuário Requisição -- Atualizar --\n\n" + Fornecedor.toString());

        Fornecedor FornecedorTemp = Fornecedor.getSenha() != null ? new Fornecedor(Fornecedor) : Fornecedor;
        System.out.println("\n\n-- Usuário a ser Atualizado --\n\n" + FornecedorTemp.toString());

        fornecedorRepository.save(FornecedorTemp);
        System.out.println("\n\n-- Usuário atualizado! --\n\n");

        FornecedorTemp.setSenha(null);
        System.out.println("\n\n-- Usuário retornado! --\n\n" + FornecedorTemp.toString());

        return ResponseEntity.ok(FornecedorTemp);
    }

    protected ResponseEntity<Fornecedor> procurarPorID(@RequestParam Integer id) {
        System.out.println("\n\n-- ProcurarPorID --");
        var fornecedor = fornecedorRepository.findById(id).get();
        fornecedor.setSenha(null);
        return ResponseEntity.ok(fornecedor);
    }

    protected ResponseEntity<Fornecedor> buscar(@RequestParam String cnpjCpf) {
        System.out.println("\n\n\n-- Usuário para Buscar --\n\n\n" + cnpjCpf + "\n\n\n");
        var fornecedorTemp = fornecedorRepository.findByCnpjCpf(cnpjCpf);
        if (fornecedorTemp != null) {
            System.out.println("\n\nAchou algo no banco de dados!");
            if (fornecedorTemp.getCnpjCpf().equals(cnpjCpf)) {
                System.out.println("\n\nEra igual!");
                fornecedorTemp.setSenha(null);
                return ResponseEntity.ok(fornecedorTemp);
            } else {
                System.out.println("\n\nNÃO Era igual!");
                return ResponseEntity.notFound().build();
            }
        } else {
            System.out.println("NÃO achou nada no banco!");
            return ResponseEntity.notFound().build();
        }
    }

    protected Fornecedor autenticaFornecedor(@RequestParam Fornecedor fornecedor) {
        try {
            System.out.println("\n\n\n-- Usuário para Autenticar --\n\n\n" + fornecedor.toString() + "\n\n\n");
            Fornecedor fornecedorTemp = fornecedorRepository.findByEmail(fornecedor.getEmail());
            System.out.println("\n\nExiste um usuário com esse email!\n\n" + fornecedorTemp.toString());
            System.out.println("\n\nSenha do usuário: " + fornecedorTemp.getSenha() + "\n\n");
            if (Criptografia.verificar(fornecedorTemp, fornecedor.getSenha())) {
                System.out.println("\n\nAs senhas batem!");
                fornecedorTemp.setSenha(null);
                System.out.println(
                        "\n\nRetirada a senha para não ser transmitida pela rede!" + fornecedorTemp.toString());
                return fornecedorTemp;
            } else {
                System.out.println("\n\nAs senhas não batem!\n\n");
                return new Fornecedor();
            }
        } catch (Exception ex) {
            System.out.println("\n\nDeu ruim..." + ex.getMessage());
            return new Fornecedor();
        }
    }

    public void validate(Fornecedor Fornecedor) throws Exception {
        if (Fornecedor.getNome().isBlank()) {
            throw new Exception("\n\nNome não pode ser vazio!");
        }
        if (Fornecedor.getEmail().isBlank()) {
            throw new Exception("\n\nEmail não pode ser vazio!");
        }

        if (Fornecedor.getCnpjCpf().isBlank()) {
            throw new Exception("\n\nCNPJ/CPF não pode ser vazio!");
        }
    }
}
