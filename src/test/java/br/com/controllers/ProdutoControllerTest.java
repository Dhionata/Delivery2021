package br.com.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.model.entities.classes.Produto;
import br.com.newObjects.model.entities.classes.NovoProduto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProdutoControllerTest {

    @Autowired
    private ProdutoController produtoController;

    @Test
    void testFind() throws Exception {
        var a = new Produto();
        for (int i = 0; i < 5; i++) {
            var b = produtoController.save(NovoProduto.novoProduto());
            if(i==3){
                a = b;
            }
        }
        System.out.println(produtoController.find(a));
    }

    @Test
    void testFindAll() throws Exception {
        for (int i = 0; i < 5; i++) {
            produtoController.save(NovoProduto.novoProduto());
        }
        System.out.println(produtoController.findAll());
    }

    @Test
    void testFindById() {

    }

    @Test
    void testRemove() {
        produtoController.remove(NovoProduto.novoProduto());
    }

    @Test
    void testSave() throws Exception {
        produtoController.save(NovoProduto.novoProduto());
    }

    @Test
    void testUpdate() {

    }
}
