package com.pdv.venda.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdv.venda.model.ItemVenda;
import com.pdv.venda.model.Produto;
import com.pdv.venda.model.Venda;
import com.pdv.venda.repository.ItemVendaRepository;
import com.pdv.venda.repository.ProdutoRepository;
import com.pdv.venda.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	VendaRepository vendarepo;
	
	@Autowired
	ProdutoRepository prodrepo;
	
	@Autowired
	ItemVendaRepository itemvenda;
	
	public Optional<Produto> buscaprodutoid (Integer id) {

		return prodrepo.findById(id);
	}
	
	public Venda FinalizaVenda (Venda v) {
		
		Venda     venda2 = new Venda();
                  venda2 = vendarepo.save(v);
        List<ItemVenda>   List   = new ArrayList<ItemVenda>();
                          List   = v.getItemVendas();

           for (ItemVenda item : List) {

                ItemVenda   item2 = new ItemVenda();
		                    item2.setVenda(venda2);
                            item2.setProduto(item.getProduto());
                            item2.setQtde(item.getQtde());
                            item2.setSubtotal(item.getSubtotal());
                            item2.setValorUnt(item.getValorUnt());
                            
                            
                            itemvenda.save(item2);
           }
           
           return venda2;
	}
	
	 public BigDecimal totalVendas() {
		 
		 return vendarepo.totalvenda();
	 }
	 
	 public List<ItemVenda> FindItemVenda(Integer id){
		 
			List<ItemVenda> vendas = new ArrayList<>();
			List<ItemVenda> vendas2 = new ArrayList<>();
			vendas = itemvenda.findvendaid(id);
			
			for (ItemVenda itemVenda : vendas) {
				ItemVenda teste = new ItemVenda();
				          teste.setId(itemVenda.getId());
				          teste.setProduto(itemVenda.getProduto());
				          teste.setQtde(itemVenda.getQtde());
				          teste.setSubtotal(itemVenda.getSubtotal());
				          teste.setValorUnt(itemVenda.getValorUnt());
				vendas2.add(teste);
			}	
			
			return vendas2;
	 }
	 
	 public List<ItemVenda> FindAllItemVenda(){
		 
			List<ItemVenda> vendas = new ArrayList<>();
			List<ItemVenda> vendas2 = new ArrayList<>();
			vendas = itemvenda.findAll();
			
			for (ItemVenda itemVenda : vendas) {
				ItemVenda teste = new ItemVenda();
				          teste.setId(itemVenda.getId());
				          teste.setProduto(itemVenda.getProduto());
				          teste.setQtde(itemVenda.getQtde());
				          teste.setSubtotal(itemVenda.getSubtotal());
				          teste.setValorUnt(itemVenda.getValorUnt());
				vendas2.add(teste);
			}
			
			return vendas2;
	 }
	 
	 public List<Venda> FindAllVenda(){
		 
			List<Venda> vendas = new ArrayList<>();
						vendas = (List<Venda>) vendarepo.findAll();
			return vendas;
	 }
	 
	 public List<Venda> FindByID(Integer id){
		 
			List<Venda> vendas = new ArrayList<>();
						vendas = (List<Venda>) vendarepo.findvendaid(id);
			 return vendas;
	 }

}
