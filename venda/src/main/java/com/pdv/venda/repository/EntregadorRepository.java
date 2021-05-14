package com.pdv.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdv.venda.model.Entregador;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Integer> {

}
