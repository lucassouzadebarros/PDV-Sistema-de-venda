package com.pdv.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdv.venda.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {

}
