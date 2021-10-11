package br.com.Services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericService<T, R> {
    private CrudRepository<T, Integer> repository;
    private final String NOT_NULL = "A entidade não pode ser nulla!";

    public GenericService(CrudRepository<T, Integer> repository) {
        setRepository(repository);
    }

    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

    public T findById(Integer id) {
        return getRepository().findById(id).get();
    }

    public void validate(T entity) throws Exception {
        if (entity == null) {
            throw new Exception(NOT_NULL);
        }
    }

    public Object save(T entity) {
        try {
            validate(entity);

            getRepository().save(entity);

            return "Persistência feita com sucesso!" + entity;
        } catch (Exception e) {
            return "Erro na persistência:\n" + e.getMessage();
        }
    }

    public Object update(T entity) {
        try {
            validate(entity);

            getRepository().save(entity);

            return "Atualização feita com sucesso!" + entity;

        } catch (Exception e) {
            return "Erro na atualização:\n" + e.getMessage();
        }
    }

    public Object remove(T entity) {
        try {
            validate(entity);
            getRepository().delete(entity);
            return "Remoção feita com sucesso!";
        } catch (Exception e) {
            return "Erro na remoção:\n" + e.getMessage();
        }
    }

    public boolean isTrue(Boolean value) {
        return Optional.ofNullable(value).orElse(false);
    }

    // Getters / Setters

    private CrudRepository<T, Integer> getRepository() {
        return repository;
    }

    private void setRepository(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }
}
