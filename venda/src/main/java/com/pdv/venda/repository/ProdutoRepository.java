package com.pdv.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdv.venda.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
//	@Query(value="select e from Evento e where e.eventoStatus= 1 and eventoDataFim > NOW()")
//	List<Evento>buscaAtivos();
//	

	
	@Query(value ="SELECT ev FROM Produto ev where codigo=(:id)")
	Produto findProduto (@Param("id") Long id);
	
	@Query(value ="SELECT ev FROM Produto ev where cdgbarras=(:id)")
	Produto findCdBarra (@Param("id") String id);
	
	
	
	

}
