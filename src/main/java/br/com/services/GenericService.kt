package br.com.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
abstract class GenericService<T, R>(@Autowired private val repository: CrudRepository<T, R>) {

    fun findAll(): Iterable<T> {
        return repository.findAll()
    }

    fun findById(id: R & Any): T {
        return repository.findById(id).get()
    }

    @Throws(Exception::class)
    abstract fun validate(entity: T)

    @Throws(Exception::class)
    fun save(entity: T & Any): T {
        validate(entity)
        return repository.save(entity)
    }

    fun remove(entity: T & Any) {
        try {
            validate(entity)
            repository.delete(entity)
            if (repository.findAll() == entity) {
                throw Exception("A entidade $entity não foi excluída!")
            } else {
                println("Remoção feita com sucesso!")
            }
        } catch (e: Exception) {
            println("Erro na remoção:${e.message}")
        }
    }
}
