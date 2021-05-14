package com.pdv.venda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdv.venda.model.Cliente;
import com.pdv.venda.model.Pedido;
import com.pdv.venda.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidorepo;
	
	public Pedido save(Pedido pedido) {
		
		return pedidorepo.save(pedido);
	}
	
	public Pedido FindId(Integer id) {
		
		return pedidorepo.findPedidoid(id);
		
	}
	
	public List<Pedido> FindAll(){
		
		return pedidorepo.findAll();
	}
	
	public Pedido Update(Pedido pedido) {
		
		Pedido pedidoBD = new Pedido();
		pedidoBD = FindId(pedido.getCodigo());
		pedidoBD.setCliente(pedido.getCliente());
		pedidoBD.setDataPedido(pedido.getDataPedido());
		pedidoBD.setFormaPgto(pedido.getFormaPgto());
		pedidoBD.setItens(pedido.getItens());
		pedidoBD.setObs(pedido.getObs());
		pedidoBD.setStatusPedido(pedido.getStatusPedido());
		pedidoBD.setTotal(pedido.getTotal());
		pedidoBD.setVendedor(pedido.getVendedor());
		pedidoBD.setVlDesconto(pedido.getVlDesconto());
		pedidoBD.setVlFrete(pedido.getVlFrete());
		return pedidorepo.save(pedidoBD);
	}
	

}
