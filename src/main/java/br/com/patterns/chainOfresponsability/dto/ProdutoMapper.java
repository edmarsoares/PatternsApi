package br.com.patterns.chainOfresponsability.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.patterns.chainOfresponsability.model.Produto;


@Mapper
public interface ProdutoMapper {
	
	ProdutoMapper instance = Mappers.getMapper(ProdutoMapper.class);

	Produto apply(final ProdutoRequestDTO produto);
}
