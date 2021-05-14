package com.pdv.venda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pdv.venda.model.Usuario;
import com.pdv.venda.repository.UsuarioRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UsuarioRepository usuariorepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*Consulta o usuario*/
		Usuario usuario = usuariorepository.findUsuarioBynome(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("usuário não foi encontrado");
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
	}

}
