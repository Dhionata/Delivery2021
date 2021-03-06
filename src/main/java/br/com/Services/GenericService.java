package br.com.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericService<T, R> {

    private CrudRepository<T, Integer> repository;

    public GenericService(CrudRepository<T, Integer> repository) {
        setRepository(repository);
    }

    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

    public T findById(Integer id) {
        return getRepository().findById(id).get();
    }

    public abstract void validate(T entity) throws Exception;

    public T save(T entity) throws Exception {
        validate(entity);
        return getRepository().save(entity);
    }

    public void remove(T entity) {
        try {
            validate(entity);
            getRepository().delete(entity);
            System.out.println("Remoção feita com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro na remoção:\n" + e.getMessage());
        }
    }

    // Getters / Setters

    public CrudRepository<T, Integer> getRepository() {
        return repository;
    }

    public void setRepository(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }

}
