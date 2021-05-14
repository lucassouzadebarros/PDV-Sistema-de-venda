package com.pdv.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdv.venda.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

}
