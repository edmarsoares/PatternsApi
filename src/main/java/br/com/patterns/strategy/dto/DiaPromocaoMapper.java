package br.com.patterns.strategy.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.patterns.strategy.model.DiaPromocao;


@Mapper
public interface DiaPromocaoMapper {
	
	DiaPromocaoMapper instance = Mappers.getMapper(DiaPromocaoMapper.class);

	DiaPromocao apply(final DiaPromocaoRequestDTO diaPromocao);
}
