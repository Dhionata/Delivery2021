package br.com.controllers

import br.com.newObjects.model.entities.classes.NovoProdutoFornecedor.novoProdutoFornecedor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProdutoFornecedorControllerTest(@Autowired private val produtoFornecedorController: ProdutoFornecedorController) {
    @Test
    fun testFind() {
    }

    @Test
    @Throws(Exception::class)
    fun testFindAll() {
        for (i in 0..3) {
            produtoFornecedorController.save(novoProdutoFornecedor())
        }
        val a = produtoFornecedorController.findAll()
        a.forEach { produtoFornecedor -> println(produtoFornecedor.toString()) }
        a.forEach { produtoFornecedor -> println(produtoFornecedor.produto) }
        a.forEach { produtoFornecedor -> println(produtoFornecedor.fornecedor) }
    }

    @Test
    fun testFindById() {
    }

    @Test
    fun testRemove() {
    }

    @Test
    fun testSave() {
    }

    @Test
    fun testUpdate() {
    }
}
