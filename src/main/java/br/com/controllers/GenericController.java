package br.com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public abstract class GenericController<T, R> {
    private CrudRepository<T, R> repository;
    private String mensagem;

    public GenericController(CrudRepository<T, R> repository) {
        setRepository(repository);
    }

    public List<T> sendObjects(List<T> list) {
        return list;
    }

    public Object sendErrorMessage(String mensagem) {
        setMensagem(mensagem);
        System.out.println(getMensagem());
        return getMensagem();
    }

    public Object findAll() {
        try {
            return getRepository().findAll();
        } catch (Exception e) {
            return sendErrorMessage("Erro na busca: " + e.getMessage());
        }
    }

    public Object findById(R id) {
        try {
            return getRepository().findById(id);
        } catch (Exception e) {
            return sendErrorMessage("Erro na busca por código: " + e.getMessage());
        }
    }

    // Caso tenha regra de negócio ao salvar ou atualizar: sobrescrever este método
    public void validate(T entity) throws Exception {
    }

    public Object save(T entity) {
        try {
            validate(entity);
            T created = getRepository().save(entity);
            setMensagem("Persistência feita com sucesso!");
            List<Object> objects = new ArrayList<>();
            objects.add(created);
            objects.add(getMensagem());
            return objects;
        } catch (Exception e) {
            return sendErrorMessage("Erro na persistência: " + e.getMessage());
        }
    }

    public Object update(T entity) {
        try {
            validate(entity);
            List<Object> objects = new ArrayList<>();
            T created = getRepository().save(entity);
            setMensagem("Atualização feita com sucesso!");
            objects.add(created);
            objects.add(getMensagem());
            return objects;
        } catch (Exception e) {
            return sendErrorMessage("Erro na atualização: " + e.getMessage());
        }
    }

    public Object remove(R id) {
        try {
            getRepository().deleteById(id);
            setMensagem("Remoção feita com sucesso!");
            return getMensagem();
        } catch (Exception e) {
            return sendErrorMessage("Erro na remoção: " + e.getMessage());
        }
    }

    public boolean isTrue(Boolean value) {
        return Optional.ofNullable(value).orElse(false);
    }

    // Getters / Setters

    private CrudRepository<T, R> getRepository() {
        return repository;
    }

    private void setRepository(CrudRepository<T, R> repository) {
        this.repository = repository;
    }

    private String getMensagem() {
        return mensagem;
    }

    private void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
