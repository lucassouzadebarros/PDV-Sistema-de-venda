package com.pdv.venda.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdv.venda.model.Cliente;
import com.pdv.venda.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
	
	@Query("SELECT SUM(ve.total) FROM Venda ve")
	BigDecimal totalvenda ();

	@Query(value ="SELECT ve FROM Venda ve where id=(:id)")
	List<Venda> findvendall (@Param("id") Integer id);
	
	@Query(value ="SELECT ve FROM Venda ve where id=(:id)")
	List<Venda> findvendaid (@Param("id") Integer id);
	
	@Query(value ="SELECT p.categoria, p.descricao, vd.qtde, vd.subtotal, v.total, c.nome as Cliente FROM aulaweb.item_venda vd\r\n" + 
			"Inner join venda v on v.id = vd.venda_id\r\n" + 
			"Inner join Cliente c on v.cliente_id = c.codigo\r\n" + 
			"Inner join  produto p on vd.produto_id = p.codigo\r\n" + 
			"" , nativeQuery = true)
	List<Object>BuscaVendas();
	
	@Query(value="SELECT vd.id as teste, v.data_venda, v.total, v.desconto FROM aulaweb.item_venda vd\r\n" + 
			"Inner join venda v on v.id = vd.venda_id\r\n" + 
			"Inner join Cliente c on v.cliente_id = c.codigo\r\n" + 
			"Inner join  produto p on vd.produto_id = p.codigo\r\n" + 
			"", nativeQuery = true)
	List<Object>testebusca();
	
	
}
