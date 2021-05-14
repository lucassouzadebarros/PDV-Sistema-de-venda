package com.pdv.venda.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class ItemVenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7575155247155763765L;
	
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;

	    private BigDecimal valorUnt;
	    private BigDecimal subtotal;
	    private int qtde;

	    @ManyToOne
	    @JoinColumn(name = "produto_id", nullable = false)
	    private Produto produto;

	    @JsonIgnore
	    @ForeignKey(name="id")
	    @ManyToOne
	    //@JoinColumn(name = "venda_id")
	    private Venda venda;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public BigDecimal getValorUnt() {
			return valorUnt;
		}

		public void setValorUnt(BigDecimal valorUnt) {
			this.valorUnt = valorUnt;
		}

		public BigDecimal getSubtotal() {
			return subtotal;
		}

		public void setSubtotal(BigDecimal subtotal) {
			this.subtotal = subtotal;
		}

		public int getQtde() {
			return qtde;
		}

		public void setQtde(int qtde) {
			this.qtde = qtde;
		}

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

		public Venda getVenda() {
			return venda;
		}

		public void setVenda(Venda venda) {
			this.venda = venda;
		}

		
		public String toString() {
			return "ItemVenda [id=" + id + ",]";
		}
	    
	    


}
