package com.pdv.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pdv.venda.model.Cliente;
import com.pdv.venda.model.Vendedor;
import com.pdv.venda.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	VendedorRepository vendedorrepo;
	
	
	public Vendedor Save(Vendedor vendedor) {
		
		return vendedorrepo.save(vendedor);
	}
	
    public List<Vendedor> FindAll(){
		
		return vendedorrepo.findAll();
	}
	
    public Vendedor FindId(Integer id) {
		
		return vendedorrepo.findvendedorId(id);
	}
	
    public Vendedor Update(Vendedor vendedor) {
		
		Vendedor vendedorBD;
		vendedorBD = FindId(vendedor.getCodigo());
		vendedorBD.setComissao(vendedor.getComissao());
		vendedorBD.setCpf(vendedor.getCpf());
		vendedorBD.setEmail(vendedor.getEmail());
		vendedorBD.setNome(vendedor.getNome());
		vendedorBD.setSalario(vendedor.getSalario());
		vendedorBD.setSenha(vendedor.getSenha());
		vendedorBD.setSexo(vendedor.getSexo());
		vendedorBD.setStatus(vendedor.getStatus());
		vendedorBD.setTelefone(vendedor.getTelefone());
		vendedorBD.setUsuario(vendedor.getUsuario());
		
		return Save(vendedorBD);
	}

	

}
