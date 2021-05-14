package com.pdv.venda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
public class Vendedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	    @Id
	    @GeneratedValue
	    private Integer codigo;
	    private BigDecimal salario;
	    private String nome;
	    private String telefone;
	    private String email;
	    private String status;
	    private String cpf;
	    private String sexo;
	    private String usuario;
	    private String senha;
	    private double comissao;
	    
		public Integer getCodigo() {
			return codigo;
		}
		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}
		public BigDecimal getSalario() {
			return salario;
		}
		public void setSalario(BigDecimal salario) {
			this.salario = salario;
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
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public double getComissao() {
			return comissao;
		}
		public void setComissao(double comissao) {
			this.comissao = comissao;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
