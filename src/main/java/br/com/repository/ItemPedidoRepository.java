package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.ItemPedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer> {

}
