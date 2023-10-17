package br.com.controllers

import br.com.model.entities.classes.Endereco
import br.com.services.GenericService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class EnderecoController(@Autowired private val genericService: GenericService<Endereco, Int>) {
    companion object {
        private const val URL = "/endereco"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    private fun procurarTodos(): Iterable<Endereco> {
        return genericService.findAll()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    private fun salvar(@RequestBody endereco: Endereco): Endereco {
        return genericService.save(endereco)
    }

    @DeleteMapping(URL)
    private fun remover(@RequestBody endereco: Endereco) {
        try {
            println(endereco.toString())
        } catch (e: Exception) {
            println(e.message)
        }
        println("\n\nRequisição de remoção de endereço recebida!\n\n")
        genericService.remove(endereco)
        println("\n\nEndereço removido com sucesso!\n\n")
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun atualizar(@RequestBody endereco: Endereco): Endereco {
        return genericService.save(endereco)
    }

    @GetMapping("$URL/{id}")
    private fun procurarPorID(@PathVariable id: Int): Endereco {
        return genericService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody endereco: Endereco): Endereco {
        return genericService.findById(endereco.id!!)
    }

    @Throws(Exception::class)
    fun validate(entity: Endereco) {
        if (entity.cidade == null || entity.cidade!!.isEmpty()) {
            throw Exception("Cidade não pode ser vazia!")
        }
        if (entity.bairro == null || entity.bairro!!.isEmpty()) {
            throw Exception("Bairro não pode ser vazio!")
        }
        if (entity.logradouro == null || entity.logradouro!!.isEmpty()) {
            throw Exception("Logradouro não pode ser vazio!")
        }
    }
}
