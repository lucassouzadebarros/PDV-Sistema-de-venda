package com.pdv.venda.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.pdv.venda.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


	@Query(value ="SELECT ev FROM Produto ev where id=(:id)")
	Usuario findusuario (@Param("id") Integer id);
	
	@Query("select u from Usuario u where u.nome =?1")
	Usuario findUsuarioBynome(@Param("nome") String nome);
	
	Usuario findUserByNome(String nome);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="update usuario set token = ?1 where nome = ?2 ")
	void atualizaTokenUser(String token,String login);
}
