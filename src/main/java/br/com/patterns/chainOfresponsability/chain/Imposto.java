package br.com.patterns.chainOfresponsability.chain;

import br.com.patterns.chainOfresponsability.model.Produto;

public interface Imposto {
	
	Produto aplicarImposto(final Produto produto);
	
	void setNext(Imposto imposto);
}
