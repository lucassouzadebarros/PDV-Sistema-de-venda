package com.pdv.venda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pdv.venda.model.Cliente;
import com.pdv.venda.model.Usuario;
import com.pdv.venda.repository.UsuarioRepository;

@CrossOrigin(value="*")
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuariorepository;
	
	
	@PostMapping(value="/",produces ="application/json")
	public ResponseEntity<Usuario> Cadastrar(@RequestBody Usuario usuario){
		
		String passcript;
		passcript = new BCryptPasswordEncoder().encode(usuario.getPassword());
		usuario.setSenha(passcript);
		
		Usuario usuarioBD;
				usuarioBD = usuariorepository.save(usuario);
		return new  ResponseEntity<Usuario> (usuarioBD, HttpStatus.OK);
	}
	
	@GetMapping(value="/", produces ="application/json")
	public ResponseEntity<List<Usuario>> BuscaUsuarios(){
		
		List<Usuario> usuarios = new ArrayList<>();
		              usuarios = usuariorepository.findAll();
		return new  ResponseEntity<List<Usuario>> (new ArrayList<>(usuarios), HttpStatus.OK); 
	}
	
	
	

}
