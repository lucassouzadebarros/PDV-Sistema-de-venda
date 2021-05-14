package com.pdv.venda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdv.venda.model.Produto;
import com.pdv.venda.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtorepository;
	
	public Produto findid(Long id) {
		
		return produtorepository.findProduto(id);
	}
	
	public Produto ProdutoSave (Produto produto) {
		
		return produtorepository.save(produto);
	}
	
	public void Delete (Integer id) {
		
		produtorepository.deleteById(id);
	}
	
	public Produto Update(Produto produto) {
		
		Produto ProdutoBd = new Produto();
		ProdutoBd = findid(produto.getCodigo());
		ProdutoBd.setCategoria(produto.getCategoria());
		ProdutoBd.setCdgbarras(produto.getCdgbarras());
		ProdutoBd.setCor(produto.getCor());
		ProdutoBd.setDescricao(produto.getDescricao());
		ProdutoBd.setDimensao(produto.getDimensao());
		ProdutoBd.setEstoque(produto.getEstoque());
		ProdutoBd.setFabricacao(produto.getFabricacao());
		ProdutoBd.setMarca(produto.getMarca());
		return ProdutoBd;
		
	}
	
	

}
