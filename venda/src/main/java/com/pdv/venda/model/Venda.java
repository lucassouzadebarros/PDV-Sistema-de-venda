package com.pdv.venda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



import com.pdv.venda.enuns.FormaPagamento;


@Entity
public class Venda implements Serializable {

	
	private static final long serialVersionUID1 = 4209295563706566678L;

	
	
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    

    private LocalDate dataVenda;
    private BigDecimal total;
    private BigDecimal desconto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //@Fetch(FetchMode.JOIN)
    @OneToMany(targetEntity=ItemVenda.class, mappedBy = "venda", orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private List<ItemVenda> itemVendas = new ArrayList<ItemVenda>();
    
    
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    
    private String mesRef;

    
    

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemVenda> getItemVendas() {
		return itemVendas;
	}

	public void setItemVendas(List<ItemVenda> itemVendas) {
		this.itemVendas = itemVendas;
		
	}
	
	public List<ItemVenda> BuscaVenda(){
		return itemVendas;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getMesRef() {
		return mesRef;
	}

	public void setMesRef(String mesRef) {
		this.mesRef = mesRef;
	}


    
  

}
