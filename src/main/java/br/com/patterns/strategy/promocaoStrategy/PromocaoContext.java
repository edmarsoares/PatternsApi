package br.com.patterns.strategy.promocaoStrategy;

import java.util.Arrays;
import java.util.List;

import br.com.patterns.strategy.model.DiaPromocao;
import br.com.patterns.strategy.model.DiaSemana;

public class PromocaoContext {
	
	private Desconto descontoStrategy;
	
	private List<Desconto> estrategias = Arrays.asList(new DescontoDomingo(),
														new DescontoSegunda(),
														new DescontoTerca(),
														new DescontoQuarta(),
														new DescontoQuinta(),
														new DescontoSexta(),
														new DescontoSabado());
	
	public PromocaoContext(DiaSemana diaSemana) {
		this.descontoStrategy=  estrategias.stream().filter(estrategy -> 
			estrategy.getDiaSemana().equals(diaSemana))
			.findFirst().orElse(new DescontoSegunda());
	}
	
	public void obterDesconto(DiaPromocao diaPromocao) {
		 this.descontoStrategy.obterDescontoSemana(diaPromocao);
	}

}
