package br.com.patterns.chainOfresponsability.model;

public enum TipoImposto {
	
	IOF("Imposto sobre Operações Financeiras"),
	IRPF("Imposto de Renda Pessoa Físic"),
	IRPJ("Imposto de Renda Pessoa Jurídica. Incide sobre o lucro das empresas"),
	IPVA("Imposto sobre a Propriedade de Veículos Automotores.");

	String descricao;
	
	TipoImposto(String descricao) {
		this.descricao = descricao;
	}
}
