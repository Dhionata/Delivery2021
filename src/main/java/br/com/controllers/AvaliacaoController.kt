package br.com.controllers

import br.com.model.Avaliacao
import br.com.services.AvaliacaoService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class AvaliacaoController(private val avaliacaoService: AvaliacaoService) {
    companion object {
        const val URL = "/avaliacao"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    fun all() = avaliacaoService.findAll()

    @PostMapping(value = [URL])
    fun save(@RequestBody avaliacao: Avaliacao): Avaliacao {
        return avaliacaoService.save(avaliacao)
    }

    @DeleteMapping(URL)
    fun remover(@RequestBody avaliacao: Avaliacao) {
        avaliacaoService.delete(avaliacao)
    }

    @PatchMapping(URL)
    fun patch(@RequestBody avaliacao: Avaliacao): Avaliacao {
        return avaliacaoService.save(avaliacao)
    }

    @GetMapping("$URL/{id}")
    fun findById(@PathVariable id: Int): Avaliacao {
        return avaliacaoService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    fun find(@RequestBody avaliacao: Avaliacao): Avaliacao {
        return avaliacaoService.findById(avaliacao.id!!)
    }
}
