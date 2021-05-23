package br.com.patterns.strategy.promocaoStrategy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import br.com.patterns.strategy.model.DiaSemana;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PromocaoContext {

	private Map<DiaSemana, Desconto> mapStrategies;

	private List<Desconto> strategies;


	@PostConstruct
	public void init() {
		createStrategies();
	}
	
	public void createStrategies() {
        this.mapStrategies = this.strategies.stream().collect(Collectors.toMap(Desconto::getDiaSemana, Function.identity()));
    }
	
	public Desconto getStrategy(DiaSemana diaSemana) {
        return this.mapStrategies.get(diaSemana);
    }

}
