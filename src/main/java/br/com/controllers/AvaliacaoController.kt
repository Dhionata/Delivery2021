package br.com.controllers

import br.com.model.entities.classes.Avaliacao
import br.com.services.GenericService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class AvaliacaoController(@Autowired private val genericService: GenericService<Avaliacao, Int>) {
    companion object {
        const val URL = "/avaliacao"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    private fun todos(): Iterable<Avaliacao> {
        return genericService.findAll()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    private fun salvar(@RequestBody avaliacao: Avaliacao): Avaliacao {
        return genericService.save(avaliacao)
    }

    @DeleteMapping(URL)
    private fun remover(@RequestBody avaliacao: Avaliacao) {
        genericService.remove(avaliacao)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun atualizar(@RequestBody avaliacao: Avaliacao): Avaliacao {
        return genericService.save(avaliacao)
    }

    @GetMapping("$URL/{id}")
    private fun procurarPorID(@PathVariable id: Int): Avaliacao {
        return genericService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody avaliacao: Avaliacao): Avaliacao {
        return genericService.findById(avaliacao.id!!)
    }

    @Throws(Exception::class)
    fun validate(avaliacao: Avaliacao) {
        if (avaliacao.nota == 0 && avaliacao.pedido.id != null) {
            return
        } else {
            throw Exception("Avaliação não válida!")
        }
    }
}
