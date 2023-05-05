package br.com.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.newObjects.model.entities.classes.NovoProdutoFornecedor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProdutoFornecedorControllerTest {

    @Autowired
    private ProdutoFornecedorController produtoFornecedorController;
    
    @Test
    void testFind() {

    }

    @Test
    void testFindAll() throws Exception {
        for(int i = 0;i<4;i++){
            produtoFornecedorController.save(NovoProdutoFornecedor.novoProdutoFornecedor());
        }

        var a = produtoFornecedorController.findAll();
        a.forEach(produtoFornecedor -> System.out.println(produtoFornecedor.toString()));
        a.forEach(produtoFornecedor -> System.out.println(produtoFornecedor.getProduto()));
        a.forEach(produtoFornecedor -> System.out.println(produtoFornecedor.getFornecedor()));
    }

    @Test
    void testFindById() {

    }

    @Test
    void testRemove() {

    }

    @Test
    void testSave() {

    }

    @Test
    void testUpdate() {

    }
}
