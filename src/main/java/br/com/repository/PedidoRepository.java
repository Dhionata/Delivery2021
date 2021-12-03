package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {}
