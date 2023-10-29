package br.com.services

import jakarta.persistence.Id
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
abstract class GenericService<T, ID>(open val repository: JpaRepository<T, ID>) {

    fun findAll(): List<T> = repository.findAll()

    open fun findById(id: ID & Any): T = repository.findById(id).orElseThrow()

    @Transactional
    open fun save(entity: T & Any): T {
        return repository.save(entity)
    }

    @Transactional
    open fun delete(entity: T & Any): Boolean {
        return try {
            repository.delete(entity)
            if (repository.existsById(getId(entity))) {
                throw Exception("A entidade $entity não foi excluída!")
            } else {
                println("Remoção feita com sucesso!")
                true
            }
        } catch (e: Exception) {
            System.err.println("Erro na remoção:${e.message}")
            false
        }
    }

    private fun getId(entity: T & Any): ID? {
        val idField = entity::class.java.declaredFields.find { it.isAnnotationPresent(Id::class.java) }
        idField?.let {
            it.isAccessible = true
            return it.get(entity) as ID
        }
        return null
    }
}
