package br.com.services

import br.com.model.Endereco
import br.com.repository.EnderecoRepository
import org.springframework.stereotype.Service

@Service
class EnderecoService(override val repository: EnderecoRepository) :
    GenericService<Endereco, Int>(repository) {

    fun validate(entity: Endereco) {
        if (entity.usuario.equals(null)) {
            throw Exception("Não existe Endereço sem usuário!")
        }
    }
}
