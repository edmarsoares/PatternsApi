package br.com.patterns.strategy.promocaoStrategy;

import br.com.patterns.strategy.model.DiaPromocao;
import br.com.patterns.strategy.model.DiaSemana;

public interface Desconto{

	void obterDescontoSemana(DiaPromocao diaPromocao);
	
	default DiaSemana getDiaSemana() {
		return DiaSemana.SEGUNDA;
	};
}
