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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.pdv.venda.enuns.StatusPedido;

@Entity
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7601534689976040273L;
	
	
	    @Id
	    @GenericGenerator(name = "auto", strategy = "increment")
	    @GeneratedValue(generator = "auto")
	    private Integer codigo;

	    private LocalDate dataPedido;
	    private BigDecimal total;
	    private BigDecimal vlFrete;
	    private BigDecimal vlDesconto;
	    private String obs;
	    private String formaPgto;

	    @Enumerated(EnumType.STRING)
	    private StatusPedido statusPedido;

	    @ManyToOne
	    @JoinColumn(name = "vendedor_id")
	    private Vendedor vendedor;

	    @ManyToOne
	    @JoinColumn(name = "cliente_id")
	    private Cliente cliente;
	    
	    //TODO Verificar se fica ruim @Fetch(FetchMode.JOIN)
	    @OneToMany(mappedBy = "pedido", orphanRemoval = true, cascade = CascadeType.ALL)
	    private List<Item> itens = new ArrayList<Item>();

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public LocalDate getDataPedido() {
			return dataPedido;
		}

		public void setDataPedido(LocalDate dataPedido) {
			this.dataPedido = dataPedido;
		}

		public BigDecimal getTotal() {
			return total;
		}

		public void setTotal(BigDecimal total) {
			this.total = total;
		}

		public BigDecimal getVlFrete() {
			return vlFrete;
		}

		public void setVlFrete(BigDecimal vlFrete) {
			this.vlFrete = vlFrete;
		}

		public BigDecimal getVlDesconto() {
			return vlDesconto;
		}

		public void setVlDesconto(BigDecimal vlDesconto) {
			this.vlDesconto = vlDesconto;
		}

		public String getObs() {
			return obs;
		}

		public void setObs(String obs) {
			this.obs = obs;
		}

		public String getFormaPgto() {
			return formaPgto;
		}

		public void setFormaPgto(String formaPgto) {
			this.formaPgto = formaPgto;
		}

		public StatusPedido getStatusPedido() {
			return statusPedido;
		}

		public void setStatusPedido(StatusPedido statusPedido) {
			this.statusPedido = statusPedido;
		}

		public Vendedor getVendedor() {
			return vendedor;
		}

		public void setVendedor(Vendedor vendedor) {
			this.vendedor = vendedor;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public List<Item> getItens() {
			return itens;
		}

		public void setItens(List<Item> itens) {
			this.itens = itens;
		}
	    
	    

}
