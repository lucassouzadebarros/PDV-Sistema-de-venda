package com.pdv.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdv.venda.model.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Integer>{

}
