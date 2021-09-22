package br.com.patterns.chainOfresponsability.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.patterns.chainOfresponsability.chain.Imposto;
import br.com.patterns.chainOfresponsability.chain.ImpostoIOF;
import br.com.patterns.chainOfresponsability.chain.ImpostoIPVA;
import br.com.patterns.chainOfresponsability.chain.ImpostoIRPF;
import br.com.patterns.chainOfresponsability.chain.ImpostoIRPJ;
import br.com.patterns.chainOfresponsability.model.Produto;
import br.com.patterns.chainOfresponsability.model.TipoImposto;
import br.com.patterns.chainOfresponsability.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public void salvar(final Produto produto) {
		Optional<Produto> produtoComImposto = aplicarImpostoChain(produto);
		
		if (produtoComImposto.isPresent()) {
			repository.save(produto);
		}
	}
	
	public List<Produto> listarTodos(){
		return repository.findAll();
	}
	
	private Optional<Produto> aplicarImpostoChain(final Produto produto) {
		Imposto iof = new ImpostoIOF();
		Imposto ipva = new ImpostoIPVA();
		Imposto irpf = new ImpostoIRPF();
		Imposto irpj = new ImpostoIRPJ();
		
		iof.setNext(ipva);
		ipva.setNext(irpf);
		irpf.setNext(irpj);
		
		return Optional.ofNullable(iof.aplicarImposto(produto));
	}

}
