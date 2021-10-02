package br.com.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericService<T, R> {
    private CrudRepository<T, Integer> repository;
    private String mensagem;

    public GenericService(CrudRepository<T, Integer> repository) {
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
            return sendErrorMessage("Erro na busca:\n" + e.getMessage());
        }
    }

    public T findById(Integer id) {
        try {
            return getRepository().findById(id).get();
        } catch (Exception e) {
            sendErrorMessage("Erro na busca por código:\n" + e.getMessage());
            return null;
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
            return sendErrorMessage("Erro na persistência:\n" + e.getMessage());
        }
    }

    public Object update(T entity) {
        try {
            validate(entity);

            T created = getRepository().save(entity);

            setMensagem("Atualização feita com sucesso!");

            List<Object> objects = new ArrayList<>();
            objects.add(created);
            objects.add(getMensagem());
            return objects;
        } catch (Exception e) {
            return sendErrorMessage("Erro na atualização:\n" + e.getMessage());
        }
    }

    public Object remove(Integer id) {
        try {
            getRepository().deleteById(id);
            setMensagem("Remoção feita com sucesso!");
            return getMensagem();
        } catch (Exception e) {
            return sendErrorMessage("Erro na remoção:\n" + e.getMessage());
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

    private String getMensagem() {
        return mensagem;
    }

    private void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
