package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Cliente;
import br.com.repository.ClienteRepository;

@RestController
public class ClienteController extends GenericService<Cliente, ClienteRepository> {

    private final String URL = "/cliente";

    @Autowired
    public ClienteController(CrudRepository<Cliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Iterable<Cliente> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save(String nome, String cnpjCpf, String email, String senha) {
        return super.save(new Cliente(nome, cnpjCpf, email, senha));
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(Cliente cliente) {
        return super.update(cliente);
    }

    @PatchMapping(URL + "/AtualizarById/teste")
    public Object updateById(Integer id, String nome, String cnpjCpf, String email, String senha) {
        try {
            Cliente retorno = findById(id);
            System.out.println(retorno.toString());

            if (nome != null) {
                retorno.setNome(nome);
            }
            if (cnpjCpf != null) {
                retorno.setCnpjCpf(cnpjCpf);
            }
            if (email != null) {
                retorno.setEmail(email);
            }
            if (senha != null) {
                retorno.setSenha(senha);
            }
            update(retorno);
            return findById(retorno.getId());
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @GetMapping(URL + "/Buscar/")
    public Cliente findById(Integer id) {
        return super.findById(id);
    }

}
