package com.pdv.venda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Caixa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5003299987520179066L;

	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String descr;

//	  //@Fetch(FetchMode.JOIN)
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixa")
	    private List<Lancamento> lancamentos;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDescr() {
			return descr;
		}

		public void setDescr(String descr) {
			this.descr = descr;
		}

//		public List<Lancamento> getLancamentos() {
//			return lancamentos;
//		}
//
//		public void setLancamentos(List<Lancamento> lancamentos) {
//			this.lancamentos = lancamentos;
//		}

		
	    
	    
}
