package com.pdv.venda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Estoque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue
	    private Long id;
	    private int qtde;
	    private int qtde_minima;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getQtde() {
			return qtde;
		}
		public void setQtde(int qtde) {
			this.qtde = qtde;
		}
		public int getQtde_minima() {
			return qtde_minima;
		}
		public void setQtde_minima(int qtde_minima) {
			this.qtde_minima = qtde_minima;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    

}
