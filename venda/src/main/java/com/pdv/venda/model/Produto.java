package com.pdv.venda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue
	    private long codigo;
	    private String descricao;
	    private String marca;
	    private String referencia;
	    private String cdgbarras;
	    private BigDecimal precoCompra;
	    private BigDecimal precoVenda;  
	    private LocalDate validade;
	    private LocalDate fabricacao;
	    private String unidade;
	    private String cor;
	    private int ncm;
	    private String categoria;
	    private String dimensao;
	    private String imagem;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "estoque_id")
	    @Fetch(FetchMode.JOIN)
	    private Estoque estoque;

		public long getCodigo() {
			return codigo;
		}

		public void setCodigo(long codigo) {
			this.codigo = codigo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getReferencia() {
			return referencia;
		}

		public void setReferencia(String referencia) {
			this.referencia = referencia;
		}

		public String getCdgbarras() {
			return cdgbarras;
		}

		public void setCdgbarras(String cdgbarras) {
			this.cdgbarras = cdgbarras;
		}

		public BigDecimal getPrecoCompra() {
			return precoCompra;
		}

		public void setPrecoCompra(BigDecimal precoCompra) {
			this.precoCompra = precoCompra;
		}

		public BigDecimal getPrecoVenda() {
			return precoVenda;
		}

		public void setPrecoVenda(BigDecimal precoVenda) {
			this.precoVenda = precoVenda;
		}

		public LocalDate getValidade() {
			return validade;
		}

		public void setValidade(LocalDate validade) {
			this.validade = validade;
		}

		public LocalDate getFabricacao() {
			return fabricacao;
		}

		public void setFabricacao(LocalDate fabricacao) {
			this.fabricacao = fabricacao;
		}

		public String getUnidade() {
			return unidade;
		}

		public void setUnidade(String unidade) {
			this.unidade = unidade;
		}

		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}

		public int getNcm() {
			return ncm;
		}

		public void setNcm(int ncm) {
			this.ncm = ncm;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public String getDimensao() {
			return dimensao;
		}

		public void setDimensao(String dimensao) {
			this.dimensao = dimensao;
		}

		public String getImagem() {
			return imagem;
		}

		public void setImagem(String imagem) {
			this.imagem = imagem;
		}

		public Estoque getEstoque() {
			return estoque;
		}

		public void setEstoque(Estoque estoque) {
			this.estoque = estoque;
		}

		
	    

}
