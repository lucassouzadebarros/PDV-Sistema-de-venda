package com.pdv.venda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdv.venda.model.Usuario;
import com.pdv.venda.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository UserRepo;
	
	
public  Optional<Usuario> FindId(Integer id) {
		
		return UserRepo.findById(id);
	}
	
	public List<Usuario> FindAll(){
		
		return UserRepo.findAll();
		
	}
	
	public Usuario Save(Usuario usuario) {
		
		return UserRepo.save(usuario);
	}
	
	public Usuario Update(Usuario usuario) {
				
		return UserRepo.save(usuario);
	}


}
