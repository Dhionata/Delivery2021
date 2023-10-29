package br.com.controllers

import br.com.model.Telefone
import br.com.services.TelefoneService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class TelefoneController(private val telefoneService: TelefoneService) {
    companion object {
        private const val URL = "/telefone"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    private fun procurarTodos(): Iterable<Telefone> {
        return telefoneService.findAll()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    private fun salvar(@RequestBody telefone: Telefone): Telefone {
        println("\n\nTelefone a ser salvo: $telefone")
        return telefoneService.save(telefone)
    }

    @DeleteMapping(URL)
    private fun remover(@RequestBody telefone: Telefone) {
        println("\n\nRemovendo telefone: $telefone")
        telefoneService.delete(telefone)
        println("Telefone removido com sucesso!")
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun atualizar(@RequestBody telefone: Telefone): Telefone {
        println("\n\nAtualizando telefone$telefone")
        return telefoneService.save(telefone)
    }

    @GetMapping("$URL/{id}")
    private fun procurarPorID(@PathVariable id: Int): Telefone {
        println("\n\nProcurando telefone por ID: $id")
        val a = telefoneService.findById(id)
        println("\n\nTelefone encontrado: $a")
        return a
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody telefone: Telefone): Telefone {
        return telefoneService.findById(telefone.id!!)
    }

    @Throws(Exception::class)
    fun validate(telefone: Telefone) {
        if (telefone.numero.isEmpty()) {
            throw Exception("Número não pode ser nulo")
        }
    }
}
