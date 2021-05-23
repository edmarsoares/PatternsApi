package br.com.patterns.strategy.dto;

import br.com.patterns.strategy.model.DiaSemana;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = "id")
@Data
public class DiaPromocaoRequestDTO {
	
	private String pratoDoDia;
	
	private Double valor;
	
	private DiaSemana diaSemana;
	
}
