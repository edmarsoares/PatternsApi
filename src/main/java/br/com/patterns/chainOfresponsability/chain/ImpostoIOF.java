package br.com.patterns.chainOfresponsability.chain;

import br.com.patterns.chainOfresponsability.model.Produto;
import br.com.patterns.chainOfresponsability.model.TipoImposto;

public class ImpostoIOF implements Imposto {

	private Imposto next;

	@Override
	public Produto aplicarImposto(final Produto produto) {
		if (produto.getTipoImposto().equals(TipoImposto.IOF)) {
			produto.setValor(produto.getValor() + (produto.getValor() * 0.35));

			return produto;
		}

		return next.aplicarImposto(produto);
	}

	@Override
	public void setNext(Imposto imposto) {
		this.next = imposto;
	}

}
