package com.pdv.venda.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lancamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3941125418860604943L;
	
	    @GeneratedValue
	    @Id
	    private long id;
	    private LocalDate dta;
	    private String descr;
	    private BigDecimal valor;
	    
	    @ManyToOne
	    private Caixa caixa;
	    
	    
	    private String tipo;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public LocalDate getDta() {
			return dta;
		}

		public void setDta(LocalDate dta) {
			this.dta = dta;
		}

		public String getDescr() {
			return descr;
		}

		public void setDescr(String descr) {
			this.descr = descr;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		public Caixa getCaixa() {
			return caixa;
		}

		public void setCaixa(Caixa caixa) {
			this.caixa = caixa;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
	    
	    

}
