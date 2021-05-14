package com.pdv.venda.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaDTO {
	
	private Integer id;
    private LocalDate dataVenda;
    private BigDecimal total;
    private BigDecimal desconto;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
    
    

}
