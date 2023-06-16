package br.com.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericService<T, R> {

    private CrudRepository<T, R> repository;

    public GenericService(CrudRepository<T, R> repository) {
        this.repository = repository;
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public T findById(R id) {
        return repository.findById(id).get();
    }

    public abstract void validate(T entity) throws Exception;

    public T save(T entity) throws Exception {
        validate(entity);
        return repository.save(entity);
    }

    public void remove(T entity) {
        try {
            validate(entity);
            repository.delete(entity);
            if (repository.findAll().equals(entity)) {
                throw new Exception("A entidade " + entity + " não foi excluída!");
            } else {
                System.out.println("Remoção feita com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro na remoção:\n" + e.getMessage());
        }
    }

    public CrudRepository<T, R> getRepository() {
        return repository;
    }

}
