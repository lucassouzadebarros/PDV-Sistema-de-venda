package com.pdv.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdv.venda.model.ItemVenda;
import com.pdv.venda.model.Venda;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
	
	@Query(value ="SELECT ve FROM ItemVenda ve where id=(:id)")
	List<ItemVenda> findvendaid (@Param("id") Integer id);

}
