package com.pdv.venda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5900793046911147387L;
	
	
	  @Id
	    private long codigo;
	    private String razao;
	    private String fantasia;
	   
	    @OneToOne(cascade = CascadeType.ALL)
	    private Endereco endereco;
	    
	    private String cnpj;
	    private String ie;
	    private String email;
	    private String fone;
		public long getCodigo() {
			return codigo;
		}
		public void setCodigo(long codigo) {
			this.codigo = codigo;
		}
		public String getRazao() {
			return razao;
		}
		public void setRazao(String razao) {
			this.razao = razao;
		}
		public String getFantasia() {
			return fantasia;
		}
		public void setFantasia(String fantasia) {
			this.fantasia = fantasia;
		}
		public Endereco getEndereco() {
			return endereco;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		public String getCnpj() {
			return cnpj;
		}
		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}
		public String getIe() {
			return ie;
		}
		public void setIe(String ie) {
			this.ie = ie;
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
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
	    

}
