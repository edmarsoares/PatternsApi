package br.com.patterns.chainOfresponsability.chain;

import br.com.patterns.chainOfresponsability.model.Produto;
import br.com.patterns.chainOfresponsability.model.TipoImposto;

public class ImpostoIRPJ implements Imposto {

	private Imposto next;

	@Override
	public Produto aplicarImposto(final Produto produto) {
		if (produto.getTipoImposto().equals(TipoImposto.IRPJ)) {
			produto.setValor(produto.getValor() + (produto.getValor() * 0.1));

			return produto;
		}

		return null;
	}

	@Override
	public void setNext(Imposto imposto) {
		this.next = imposto;
	}

}
