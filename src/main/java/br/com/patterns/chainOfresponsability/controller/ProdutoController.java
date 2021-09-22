package br.com.patterns.chainOfresponsability.controller;

import static org.mapstruct.factory.Mappers.getMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patterns.chainOfresponsability.dto.ProdutoMapper;
import br.com.patterns.chainOfresponsability.dto.ProdutoRequestDTO;
import br.com.patterns.chainOfresponsability.model.Produto;
import br.com.patterns.chainOfresponsability.service.ProdutoService;


@RestController
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody ProdutoRequestDTO produtoRequestDto) throws Exception{
		Produto produto = getMapper(ProdutoMapper.class).apply(produtoRequestDto);
		
		this.service.salvar(produto);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		List<Produto> promocoes = this.service.listarTodos();
		
		return ResponseEntity.ok(promocoes);
	}
}
