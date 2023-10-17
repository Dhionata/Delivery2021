package br.com.controllers

import br.com.model.entities.classes.Telefone
import br.com.services.GenericService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class TelefoneController(@Autowired private val genericService: GenericService<Telefone, Int>) {
    companion object {
        private const val URL = "/telefone"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    private fun procurarTodos(): Iterable<Telefone> {
        return genericService.findAll()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    private fun salvar(@RequestBody telefone: Telefone): Telefone {
        println("\n\nTelefone a ser salvo: $telefone")
        return genericService.save(telefone)
    }

    @DeleteMapping(URL)
    private fun remover(@RequestBody telefone: Telefone) {
        println("\n\nRemovendo telefone: $telefone")
        genericService.remove(telefone)
        println("Telefone removido com sucesso!")
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun atualizar(@RequestBody telefone: Telefone): Telefone {
        println("\n\nAtualizando telefone$telefone")
        return genericService.save(telefone)
    }

    @GetMapping("$URL/{id}")
    private fun procurarPorID(@PathVariable id: Int): Telefone {
        println("\n\nProcurando telefone por ID: $id")
        val a = genericService.findById(id)
        println("\n\nTelefone encontrado: $a")
        return a
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody telefone: Telefone): Telefone {
        return genericService.findById(telefone.id!!)
    }

    @Throws(Exception::class)
    fun validate(telefone: Telefone) {
        if (telefone.numero.isEmpty()) {
            throw Exception("Número não pode ser nulo")
        }
    }
}
