package com.pdv.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdv.venda.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query(value ="SELECT ev FROM Cliente ev where codigo=(:id)")
	Cliente findCd (@Param("id") Integer id);
}
