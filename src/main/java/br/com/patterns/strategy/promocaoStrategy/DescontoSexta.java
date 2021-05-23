package br.com.patterns.strategy.promocaoStrategy;

import br.com.patterns.strategy.model.DiaPromocao;
import br.com.patterns.strategy.model.DiaSemana;

public class DescontoSexta implements Desconto{
	
	private DiaSemana diaSemana = DiaSemana.SEXTA;

	@Override
	public void obterDescontoSemana(DiaPromocao diaPromocao) {
		Double valor = diaPromocao.getValor();
		diaPromocao.setValor(valor - (valor * 0.05));
	}
	
	@Override
	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

}
