package br.com.services

import br.com.model.Telefone
import br.com.repository.TelefoneRepository
import org.springframework.stereotype.Service

@Service
class TelefoneService(override val repository: TelefoneRepository) : GenericService<Telefone, Int>(repository) {

    fun validate(entity: Telefone) {
        if (entity.equals(null)) {
            throw Exception("Não existe avaliação sem pedido!")
        }
    }
}
