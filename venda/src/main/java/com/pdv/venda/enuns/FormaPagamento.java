package com.pdv.venda.enuns;



public enum FormaPagamento {

	 DINHEIRO("Dinheiro"), CARTAO_DEBITO("Débito"), CARTAO_CREDITO("Crédito"), CREDIÁRIO("Crediário");

	private String label;
	
    private FormaPagamento(String label) {
        this.label = label;
    }

    
}
