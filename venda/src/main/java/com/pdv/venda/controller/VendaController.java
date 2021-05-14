package com.pdv.venda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pdv.venda.ModelMapperConfig;
import com.pdv.venda.model.Cliente;
import com.pdv.venda.model.ItemVenda;
import com.pdv.venda.model.Produto;
import com.pdv.venda.model.Venda;
import com.pdv.venda.model.VendaDTO;
import com.pdv.venda.repository.ItemVendaRepository;
import com.pdv.venda.repository.VendaRepository;
import com.pdv.venda.service.VendaService;


@CrossOrigin(value = "*")
@Controller
@RequestMapping(value="venda")
public class VendaController {
		
	
	@Autowired
	VendaRepository VendaRepo;
	@Autowired
	private ModelMapperConfig modelmapper;
	@Autowired
	ItemVendaRepository itemrepo;
	@Autowired
	VendaService vendaserv;

// Finalizando uma Venda	
	@PostMapping(value="/")
	public ResponseEntity<Venda> cadastrar(@RequestBody Venda venda){
		
		Venda vendaM = new Venda();
		      vendaM = vendaserv.FinalizaVenda(venda);
		return new ResponseEntity<Venda> (vendaM, HttpStatus.OK);
	}
	
// Adicionando Um Item ao PDV	
	@GetMapping(value="addpdv")
	public ResponseEntity<List<ItemVenda>> AddItemPdv(ItemVenda itemvenda){
		
		List<ItemVenda> itemvendas = new ArrayList<>();
		                itemvendas.add(itemvenda);
		return new  ResponseEntity<List<ItemVenda>> (new ArrayList<>(itemvendas), HttpStatus.OK); 
	}
	
// Lista Item especifico pelo ID do ItemVenda
	@GetMapping(value="/listaitem/{id}", produces ="application/json")
	public ResponseEntity<List<ItemVenda>> Itemvenda(@PathVariable("id") Integer id){
		
		List<ItemVenda> itemvenda = new ArrayList<>();
	         		    itemvenda = vendaserv.FindItemVenda(id);
		return new ResponseEntity<List<ItemVenda>> (new ArrayList<>(itemvenda),HttpStatus.OK);
	}
	

// Lista Todos Itens das Vendas 
		@GetMapping(value="/listaitem", produces ="application/json")
		public ResponseEntity<List<ItemVenda>> ItemvendaAll(@PathVariable("id") Integer id){
			
			List<ItemVenda> itemvenda = new ArrayList<>();
 		                    itemvenda = vendaserv.FindItemVenda(id);
			return new ResponseEntity<List<ItemVenda>> (new ArrayList<>(itemvenda),HttpStatus.OK);
		}
		
	
// Listando todas as  Vendas 
		@GetMapping(value="/", produces ="application/json")
		public ResponseEntity<List<Venda>> listavenda(){
			
			List<Venda> venda = new ArrayList<>();
                        venda = vendaserv.FindAllVenda();
			return new ResponseEntity<List<Venda>> (new ArrayList<>(venda),HttpStatus.OK);
		}	
		
// Listando Vendas Pelo ID
		@GetMapping(value="/{id}", produces ="application/json")
		public ResponseEntity<List<Venda>> listavendaid(@PathVariable("id") Integer id){
			
			List<Venda> venda = new ArrayList<>();
                        venda = vendaserv.FindByID(id);
			return new ResponseEntity<List<Venda>> (new ArrayList<>(venda),HttpStatus.OK);
		}	
	
//		
//// Transformando em um DTO		
//	    @GetMapping
//	    public Stream<VendaDTO> listardto(){
//				
//		   return   VendaRepo.findAll().stream().map(this::ConvertDto);
//		
//	   }
//	
//// Mostrando Uma Lista de Objetos
//	    
//	@GetMapping(value="/listacl", produces ="application/json")
//	public ResponseEntity<List<Object>> vendascl(){
//		
//		List<Object> vendas = new ArrayList<>();
//		             vendas = VendaRepo.testebusca();
//		System.out.println(vendas.get(0));
//	
//		
//		return new  ResponseEntity<List<Object>> (new ArrayList<>(vendas), HttpStatus.OK); 
//	}
	
//	@GetMapping(value="/{id}", produces ="application/json")
//	public ResponseEntity<Venda> buscacvenda(@PathVariable("id") Integer id){
//		
//		Venda vendas;
//		
//		vendas = VendaRepo.findvendaid(id);
//		
//		return new  ResponseEntity<Venda> ((vendas), HttpStatus.OK); 
//				
//	}
//	
//	public VendaDTO ConvertDto(Venda venda) {
//		
//		return modelmapper.modelMapper().map(venda, VendaDTO.class);
//		
//	}
	

}
