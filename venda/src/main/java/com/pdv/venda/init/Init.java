package com.pdv.venda.init;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pdv.venda.model.Estoque;
import com.pdv.venda.model.ItemVenda;
import com.pdv.venda.model.Produto;
import com.pdv.venda.model.Usuario;
import com.pdv.venda.enuns.FormaPagamento;
import com.pdv.venda.model.Caixa;
import com.pdv.venda.model.Cliente;
import com.pdv.venda.model.Endereco;
import com.pdv.venda.model.Venda;
import com.pdv.venda.repository.CaixaRepository;
import com.pdv.venda.repository.ClienteRepository;
import com.pdv.venda.repository.EnderecoRepository;
import com.pdv.venda.repository.EstoqueRepository;
import com.pdv.venda.repository.ProdutoRepository;
import com.pdv.venda.repository.UsuarioRepository;
import com.pdv.venda.service.ProdutoService;
import com.pdv.venda.service.VendaService;



@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
		
	@Autowired 
	ProdutoRepository prodrepo;
	@Autowired
	ProdutoService prodserv;	
	@Autowired
	EstoqueRepository estoqrepo;
	@Autowired
	private VendaService vedserv;
	
	@Autowired
	private ClienteRepository clir;
	@Autowired
	private EnderecoRepository endre;
	@Autowired
	CaixaRepository caixarepo;
//	@Autowired 
//	ItemV itemvendarepo;
	
	@Autowired
	UsuarioRepository userrepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
//		Usuario user = new Usuario();
//		user = userrepo.findUserByNome("lucas");
//		System.out.println(user.getNome());
////		 
//		BigDecimal totalveda = new BigDecimal("0.0");
//		BigDecimal Acumulado = new BigDecimal("0.0");
//		BigDecimal totalvenda2 = new BigDecimal("0.0");
////
//		List<ItemVenda> ivs = new ArrayList();
//		ItemVenda iv = new ItemVenda(); 
//		ItemVenda iv2 = new ItemVenda();
////		
//		 Produto produto = new Produto();
//		 Produto produto2 = new Produto();
//		 produto.setCategoria("Croppdy");
//		 produto.setCdgbarras("1234");
//		 produto.setCor("Vermelho");
//		 produto.setDescricao("Croppdy de Bengalini");
//		 produto.setDimensao("M");
//		 produto.setFabricacao(null);
////		 
//		 BigDecimal big1 = new BigDecimal("22.0");
//		 produto.setPrecoCompra(big1);
//		 produto.setPrecoVenda(big1);
//		 
//		 Estoque estoque = new Estoque();
//		 estoque.setQtde(50);
//		 estoque.setQtde_minima(2);
//		 produto.setEstoque(estoque);
//		 long idd = 1;
//		 produto2 = prodserv.findid(idd);
//		 System.out.println(produto.getDescricao());
////		 
//		 System.out.println(vedserv.totalVendas());
//		 
//		 Caixa caixa = new Caixa();
//		 caixa.setDescr("Caixa 02");
//		 caixarepo.save(caixa);
//		 
//		 iv.setProduto(produto);
//		 iv.setValorUnt(produto.getPrecoVenda());
//		 iv.setQtde(2);
//		 iv.setSubtotal(iv.getValorUnt().multiply(new BigDecimal(iv.getQtde())));
////		 
//		 Acumulado.add(iv.getValorUnt().multiply(new BigDecimal(iv.getQtde())));
//		 prodrepo.save(produto);
////		 
////		 
//		 iv2.setProduto(produto);
//		 iv2.setValorUnt(produto.getPrecoVenda());
//		 iv2.setQtde(2);
//		 iv2.setSubtotal(iv2.getValorUnt().multiply(new BigDecimal(iv.getQtde())));
//		 
//		 Acumulado.add(iv2.getValorUnt().multiply(new BigDecimal(iv.getQtde())));
//		 
//		 prodrepo.save(produto);
//		 
//		 Endereco en = new Endereco();
//		 Endereco ent = new Endereco();
//		 
//		 en.setBairro("Iraja");
//		 en.setCep("21520630");
//		 en.setCidade("Rio de janeiros");
//		 en.setLogradouro("Casa");
//		 en.setNumero(7233);
//		 en.setUf("RJ");
//		 //ent = endre.save(en);
//		 System.out.println(en.getBairro());
//		 System.out.println(en.getId());
//		 //ent = endre.findById(1);
//		 System.out.println(ent.getId());
//		 //endre.save(en);
//		 Cliente cl = new Cliente();
//		 cl.setCpf("16605681703");
//		 cl.setEmail("lucassouzadebarros@gmail.com");
//		 cl.setEndereco(en);
//		 cl.setNome("Lucas Souza de Barro");
//		 cl.setSexo("M");
//		 cl.setTelefone("995920024");
//		 cl.setStatus("Ativo");
//		 clir.save(cl);
//		 
//		 FormaPagamento fm = null;
		 
//		Cliente clit = new Cliente();	
//		clit = clir.findCd(1);
//		
//		 Venda vd = new Venda();
//		 iv.setVenda(vd);
//		 ivs.add(iv);
//		 iv2.setVenda(vd);
//		 ivs.add(iv2);
//		 vd.setCliente(clit);
//		 vd.setFormaPagamento(fm.CARTAO_CREDITO);
//		 vd.setItemVendas(ivs);
//		 vd.getItemVendas();
//		 vd.setTotal(Acumulado);		 
//		 vedserv.FinalizaVenda(vd);

	}
	
	
	 
		
		 
		 
		 
		 
//		 iv.setProduto(produto);
//		 iv.setQtde(2);
//		 iv.setValorUnt(iv.getProduto().getPrecoVenda());
//		
//		 iv.setSubtotal(iv.getValorUnt()
//                 .multiply(new BigDecimal(iv.getQtde())));
//	
//		 totalveda =  iv.getSubtotal();
//		 Acumulado = iv.getSubtotal();
	 

	 
	 
	// public void Cliente () {
			
		
		 
	//	System.out.println(ent.get().getBairro());
		 
//		 cl.setCpf("16605681703");
//		 cl.setEmail("lucassouzadebarros@gmail.com");
//		 cl.setEndereco(en);
//		 cl.setNome("Lucas Souza de Barro");
//		 cl.setSexo("M");
//		 cl.setTelefone("995920024");
//		 cl.setStatus("Ativo");
		 //clir.save(cl);
		 
	// }
	 
//	 public void Venda() {
//		 FormaPagamento fm = null;
//		 
//		 Venda vd = new Venda();
//		 ivs.add(iv);
//		 vd.setCliente(cl);
//		 vd.setFormaPagamento(fm.DINHEIRO);
//		 vd.setItemVendas(ivs);	
//		 vd.setTotal(Acumulado);
//		 vedserv.FinalizaVenda(vd);
//	 }
	
	
	
}

