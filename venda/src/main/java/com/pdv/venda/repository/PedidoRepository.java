package com.pdv.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdv.venda.model.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Query(value ="SELECT ve FROM Pedido ve where codigo=(:id)")
	Pedido findPedidoid (@Param("id") Integer id);

}
