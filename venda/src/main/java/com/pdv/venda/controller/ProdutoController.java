package com.pdv.venda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pdv.venda.model.Produto;
import com.pdv.venda.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository prodrepo;
	
	
	@PostMapping(value="cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto){
		
		Produto produtoBD;
		produtoBD = prodrepo.save(produto);
		return new  ResponseEntity<Produto> (produtoBD, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cadastrar",produces ="application/json")
    public void cadastro(@RequestBody Produto produto) {
		
		prodrepo.save(produto);
        
    }
	
	@GetMapping(value="/lista", produces ="application/json")
	public ResponseEntity<List<Produto>> buscaprodutos(){
		
		List<Produto> produtos = new ArrayList<>();
		produtos = prodrepo.findAll();
		return new  ResponseEntity<List<Produto>> (new ArrayList<>(produtos), HttpStatus.OK); 
	}
	
	@GetMapping(value="/busca/{id}", produces ="application/json")
	public ResponseEntity<Produto> buscaproduto(@PathVariable("id") long id){
		
		Produto produtos;
		
		produtos = prodrepo.findProduto(id);
		return new  ResponseEntity<Produto> (produtos, HttpStatus.OK); 
				
	}
	
	@GetMapping(value="/buscacd/{id}", produces ="application/json")
	public ResponseEntity<Produto> buscacdbarra(@PathVariable("id") String id){
		
		Produto produtos;
		        produtos = prodrepo.findCdBarra(id);
		return new  ResponseEntity<Produto> (produtos, HttpStatus.OK); 
				
	}
	
	
	
	

}
