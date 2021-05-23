package br.com.patterns.strategy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patterns.strategy.dto.DiaPromocaoMapper;
import br.com.patterns.strategy.dto.DiaPromocaoRequestDTO;
import br.com.patterns.strategy.model.DiaPromocao;
import br.com.patterns.strategy.service.PromocaoService;

import static org.mapstruct.factory.Mappers.getMapper;


@RestController
@RequestMapping("promocao")
public class PromocaoController {
	
	@Autowired
	private PromocaoService service;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody DiaPromocaoRequestDTO diaPromocaoRequest) throws Exception{
		
		DiaPromocao diaPromocao = getMapper(DiaPromocaoMapper.class).apply(diaPromocaoRequest);
		this.service.salvarComStrategy(diaPromocao);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/sem-strategy")
	public ResponseEntity<?> salvarSemStrategy(@RequestBody DiaPromocaoRequestDTO diaPromocaoRequest) throws Exception{
		
		DiaPromocao diaPromocao = getMapper(DiaPromocaoMapper.class).apply(diaPromocaoRequest);
		this.service.salvarSemStrategy(diaPromocao);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/com-strategy-enum")
	public ResponseEntity<?> salvarComStrategyEnum(@RequestBody DiaPromocaoRequestDTO diaPromocaoRequest) throws Exception{
		
		DiaPromocao diaPromocao = getMapper(DiaPromocaoMapper.class).apply(diaPromocaoRequest);
		this.service.salvarComStrategyEnum(diaPromocao);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<DiaPromocao>> listar(){
		List<DiaPromocao> promocoes = this.service.buscarTodos();
		
		return ResponseEntity.ok(promocoes);
	}
}
