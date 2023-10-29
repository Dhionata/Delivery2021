package br.com.controllers

import br.com.newObjects.model.NovoProduto.novoProduto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProdutoControllerTest(@Autowired private val produtoController: ProdutoController) {
    @Test
    fun testFind() {
        var a = novoProduto()
        for (i in 0..4) {
            val b = produtoController.save(novoProduto())
            if (i == 3) {
                a = b
            }
        }
        println(a.id?.let { produtoController.findById(it) })
    }

    @Test
    fun testFindAll() {
        for (i in 0..4) {
            produtoController.save(novoProduto())
        }
        println(produtoController.findAll())
    }

    @Test
    fun testFindById() {
    }

    @Test
    fun testRemove() {
        produtoController.remove(novoProduto())
    }

    @Test
    fun testSave() {
        produtoController.save(novoProduto())
    }

    @Test
    fun testUpdate() {
    }
}
