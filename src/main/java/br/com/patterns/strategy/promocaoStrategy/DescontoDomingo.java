package br.com.patterns.strategy.promocaoStrategy;

import org.springframework.stereotype.Component;

import br.com.patterns.strategy.model.DiaPromocao;
import br.com.patterns.strategy.model.DiaSemana;

@Component
public class DescontoDomingo implements Desconto{
	
	private DiaSemana diaSemana = DiaSemana.DOMINGO;

	@Override
	public void obterDescontoSemana(DiaPromocao diaPromocao) {
		Double valor = diaPromocao.getValor();
		diaPromocao.setValor(valor - (valor * 0.15));
	}
	
	@Override
	public DiaSemana getDiaSemana() {
		return diaSemana;
	}
}
