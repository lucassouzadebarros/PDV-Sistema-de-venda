package com.pdv.venda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Lojista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5290789985896545049L;

	
	    @Id
	    @GeneratedValue
	    private Long id;
	    private String nome;
	    private String email;
	    private String fone;
	    private String cpf;
	    private String senha;
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFone() {
			return fone;
		}
		public void setFone(String fone) {
			this.fone = fone;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
	    
	    

}
