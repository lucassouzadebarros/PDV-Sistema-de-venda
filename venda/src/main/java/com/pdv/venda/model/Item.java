package com.pdv.venda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5324969394372444368L;
	
	    @Id
	    @GeneratedValue
	    private Long id;
	    private BigDecimal valorUnt;
	    private BigDecimal subtotal;
	    private int qtde;

	    @ManyToOne
	    @JoinColumn(name = "produto_id", nullable = false)
	    private Produto produto;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	    @ManyToOne
	    @JoinColumn(name = "pedido_id")
	    private Pedido pedido;
	    
	    

}
