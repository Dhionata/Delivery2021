package br.com.services

import br.com.model.Avaliacao
import br.com.repository.AvaliacaoRepository
import org.springframework.stereotype.Service


@Service
class AvaliacaoService(override val repository: AvaliacaoRepository) :
    GenericService<Avaliacao, Int>
        (repository) {

    fun validate(entity: Avaliacao) {
        if (entity.pedido.equals(null)) {
            throw Exception("Não existe avaliação sem pedido!")
        }
    }

}
