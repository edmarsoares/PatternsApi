package br.com.patterns.strategy.promocaoStrategy;

import org.springframework.stereotype.Component;

import br.com.patterns.strategy.model.DiaPromocao;
import br.com.patterns.strategy.model.DiaSemana;

@Component
public interface Desconto{

	void obterDescontoSemana(DiaPromocao diaPromocao);
	
	default DiaSemana getDiaSemana() {
		return DiaSemana.SEGUNDA;
	};
}
