package com.pdv.venda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pdv.venda.model.Cliente;
import com.pdv.venda.model.Endereco;
import com.pdv.venda.repository.EnderecoRepository;
import com.pdv.venda.service.ClienteService;

@CrossOrigin(value = "*")
@Controller
@RequestMapping(value="cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteservice;
	
	@Autowired
	EnderecoRepository enderecorepo;
	
	@PostMapping(value="/cadastrar",produces ="application/json")
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
		
		//Endereco endereco;
		Cliente clienteBD;
		//endereco =  cliente.getEndereco();
		//cliente.setEndereco(enderecorepo.save(endereco));
		clienteBD = clienteservice.Save(cliente);
		return new  ResponseEntity<Cliente> (clienteBD, HttpStatus.OK);
	}
	
	@GetMapping(value="/lista", produces ="application/json")
	public ResponseEntity<List<Cliente>> buscaclientes(){
		
		List<Cliente> clientes = new ArrayList<>();
		clientes = clienteservice.FindAll();
		return new  ResponseEntity<List<Cliente>> (new ArrayList<>(clientes), HttpStatus.OK); 
	}
	
	@GetMapping(value="/busca/{id}", produces ="application/json")
	public ResponseEntity<Optional<Cliente>> buscacliente(@PathVariable("id") Integer id){
		
		Optional<Cliente> clientes;
		
		clientes = clienteservice.FindId(id);
		return new  ResponseEntity<Optional<Cliente>> ((clientes), HttpStatus.OK); 
				
	}
	
	@PostMapping(value="editar")
	public ResponseEntity<Cliente> Editar(Cliente cliente){
		
		Cliente clienteBD;
		clienteBD = clienteservice.Update(cliente);
		return new  ResponseEntity<Cliente> (clienteBD, HttpStatus.OK);
	}
	

}
