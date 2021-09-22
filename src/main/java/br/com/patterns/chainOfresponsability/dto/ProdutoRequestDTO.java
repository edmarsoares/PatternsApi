package br.com.patterns.chainOfresponsability.dto;

import br.com.patterns.chainOfresponsability.model.TipoImposto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = "id")
@Data
public class ProdutoRequestDTO {
	
	private String descricao;
	
	private Double valor;
	
	private TipoImposto tipoImposto;
}
