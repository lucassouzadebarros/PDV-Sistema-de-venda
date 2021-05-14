package com.pdv.venda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.pdv.venda.enuns.Status_Conta;
import com.pdv.venda.enuns.Tipo_Conta;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3854420153371752315L;

	@Id
    @GeneratedValue
    private long codigo;
    private BigDecimal valor;
    private LocalDate dataPgto;

    @Enumerated(EnumType.STRING)
    private Tipo_Conta tipoConta;

    private String descr;
    private String documento;
    private String obs;

    @Enumerated(EnumType.STRING)
    private Status_Conta status;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataPgto() {
		return dataPgto;
	}

	public void setDataPgto(LocalDate dataPgto) {
		this.dataPgto = dataPgto;
	}

	public Tipo_Conta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(Tipo_Conta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Status_Conta getStatus() {
		return status;
	}

	public void setStatus(Status_Conta status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
