package br.com.controllers

import br.com.model.Endereco
import br.com.services.EnderecoService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class EnderecoController(private val enderecoService: EnderecoService) {
    companion object {
        private const val URL = "/endereco"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    private fun procurarTodos(): Iterable<Endereco> {
        return enderecoService.findAll()
    }

    @PostMapping(value = [URL])
    private fun salvar(@RequestBody endereco: Endereco): Endereco {
        return enderecoService.save(endereco)
    }

    @DeleteMapping(URL)
    private fun remover(@RequestBody endereco: Endereco) {
        try {
            println(endereco.toString())
        } catch (e: Exception) {
            println(e.message)
        }
        println("\n\nRequisição de remoção de endereço recebida!\n\n")
        enderecoService.delete(endereco)
        println("\n\nEndereço removido com sucesso!\n\n")
    }

    @PatchMapping(URL)
    private fun atualizar(@RequestBody endereco: Endereco): Endereco {
        return enderecoService.save(endereco)
    }

    @GetMapping("$URL/{id}")
    private fun procurarPorID(@PathVariable id: Int): Endereco {
        return enderecoService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody endereco: Endereco): Endereco {
        return enderecoService.findById(endereco.id!!)
    }

    fun validate(entity: Endereco) {
        if (entity.cidade.isEmpty()) {
            throw Exception("Cidade não pode ser vazia!")
        }
        if (entity.bairro.isEmpty()) {
            throw Exception("Bairro não pode ser vazio!")
        }
        if (entity.logradouro.isEmpty()) {
            throw Exception("Logradouro não pode ser vazio!")
        }
    }
}
