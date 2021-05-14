package com.pdv.venda.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
public class Usuario implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private Integer id;

	
	@Column(unique = true)
    private String nome;
    private String senha;
    private String nivel;
    
        
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_role",uniqueConstraints = @UniqueConstraint(
    		columnNames = {"usuario_id","role_id"}, name = "unique_role_user"),
    joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", unique = false,
    foreignKey = @javax.persistence.ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
    
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName =  "id", table = "role", unique =false,updatable = false,
    foreignKey = @javax.persistence.ForeignKey (name="role_fk", value = ConstraintMode.CONSTRAINT )))
    private List<Role> roles;
    
    private String token ="";
    
    
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/*São os acessos do usuario ROLE_ADMIN ou ROLE_VISITANTE*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles;
	}
	@Override
	public String getPassword() {
		
		return this.senha;
	}
	@Override
	public String getUsername() {
	
		return this.nome;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
