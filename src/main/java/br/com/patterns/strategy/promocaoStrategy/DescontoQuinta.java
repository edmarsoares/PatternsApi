package br.com.patterns.strategy.promocaoStrategy;

import org.springframework.stereotype.Component;

import br.com.patterns.strategy.model.DiaPromocao;
import br.com.patterns.strategy.model.DiaSemana;

@Component
public class DescontoQuinta implements Desconto{
	
	private DiaSemana diaSemana = DiaSemana.QUINTA;

	@Override
	public void obterDescontoSemana(DiaPromocao diaPromocao) {
		Double valor = diaPromocao.getValor();
		diaPromocao.setValor(valor - (valor * 0.25));
	}
	
	@Override
	public DiaSemana getDiaSemana() {
		return diaSemana;
	}
}
