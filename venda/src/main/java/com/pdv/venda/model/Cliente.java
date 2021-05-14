package com.pdv.venda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jdk.jfr.DataAmount;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7037916308692461564L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	    private String nome;
	    private String telefone;
	    private String email;
	    private String status;
	    private String cpf;
	    private BigDecimal limite;
	    
//	    @Temporal(javax.persistence.TemporalType.DATE)
//	    private Date nascimento;
	    private String sexo;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "endereco_id")
	    @Fetch(FetchMode.JOIN)
	    private Endereco endereco;
	    
	    

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public BigDecimal getLimite() {
			return limite;
		}

		public void setLimite(BigDecimal limite) {
			this.limite = limite;
		}

//		public Date getNascimento() {
//			return nascimento;
//		}
//
//		public void setNascimento(Date nascimento) {
//			this.nascimento = nascimento;
//		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
	
	    

}
