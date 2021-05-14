package com.pdv.venda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdv.venda.model.Cliente;
import com.pdv.venda.repository.ClienteRepository;
import com.pdv.venda.repository.EnderecoRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienterepo;
	
	@Autowired
	EnderecoRepository enderecorepo;
	
	public  Optional<Cliente> FindId(Integer id) {
		
		return clienterepo.findById(id);
	}
	
	public List<Cliente> FindAll(){
		
		return clienterepo.findAll();
		
	}
	
	public Cliente Save(Cliente cliente) {
		
		return clienterepo.save(cliente);
	}
	
	public Cliente Update(Cliente cliente) {
		
		Cliente clienteBD;
		clienteBD = clienterepo.findCd(cliente.getCodigo());
		clienteBD.setCpf(cliente.getCpf());
		clienteBD.setEmail(cliente.getEmail());
		clienteBD.setEndereco(cliente.getEndereco());
		clienteBD.setLimite(cliente.getLimite());
		clienteBD.setNome(cliente.getNome());
		clienteBD.setSexo(cliente.getSexo());
		clienteBD.setStatus(cliente.getStatus());
		clienteBD.setTelefone(cliente.getTelefone());
		
		return clienterepo.save(cliente);
	}

}
