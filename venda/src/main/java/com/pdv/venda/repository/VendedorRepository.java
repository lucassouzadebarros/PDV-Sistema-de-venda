package com.pdv.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.pdv.venda.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
	
	
	@Query(value ="SELECT ve FROM Vendedor ve where id=(:id)")
	Vendedor findvendedorId (@Param("id") Integer id);

}
