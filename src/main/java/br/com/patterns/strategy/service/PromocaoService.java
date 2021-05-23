package br.com.patterns.strategy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.patterns.strategy.model.DiaPromocao;
import br.com.patterns.strategy.model.DiaSemana;
import br.com.patterns.strategy.promocaoStrategy.PromocaoContext;
import br.com.patterns.strategy.repository.PromocaoRepository;

@Service
public class PromocaoService {

	@Autowired
	private PromocaoRepository repository;

	/**
	 * MÉTODO COM PADRÃO STRATEGY
	 * 
	 * @param diaPromocao
	 * @throws Exception
	 */
	public void salvarComStrategy(DiaPromocao diaPromocao) throws Exception {

		gerarPromocao(diaPromocao);
		Optional<DiaPromocao> diaPromocaoExistente = this.buscarDiaPromocao(diaPromocao.getDiaSemana());

		// Se existir algum prato promocional, deleta e cria o novo para o dia da semana
		// informado no request
		if (diaPromocaoExistente.isPresent()) {
			repository.delete(diaPromocaoExistente.get());
		}

		this.repository.save(diaPromocao);
	}

	private void gerarPromocao(DiaPromocao diaPromocao) {
		PromocaoContext context = new PromocaoContext(diaPromocao.getDiaSemana());
		context.obterDesconto(diaPromocao);
	}

	public Optional<DiaPromocao> buscarDiaPromocao(DiaSemana diaSemana) throws Exception {
		return this.repository.buscarPorDiaPromocional(diaSemana);
	}

	public List<DiaPromocao> buscarTodos() {
		return this.repository.findAll();
	}

	/**
	 * MÉTODO TRADICIONAL SEM STRATEGY
	 * 
	 * @param diaPromocao
	 * @throws Exception
	 */
	public void salvarSemStrategy(DiaPromocao diaPromocao) throws Exception {

		if (diaPromocao.getDiaSemana().equals(DiaSemana.DOMINGO)) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.15));

		} else if (diaPromocao.getDiaSemana().equals(DiaSemana.SEGUNDA)) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.1));
		} else if (diaPromocao.getDiaSemana().equals(DiaSemana.TERCA)) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.3));
		} else if (diaPromocao.getDiaSemana().equals(DiaSemana.QUARTA)) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.2));
		} else if (diaPromocao.getDiaSemana().equals(DiaSemana.QUINTA)) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.25));
		} else if (diaPromocao.getDiaSemana().equals(DiaSemana.SEXTA)) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.05));
		} else if (diaPromocao.getDiaSemana().equals(DiaSemana.SABADO)) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.01));
		}

		Optional<DiaPromocao> diaPromocaoExistente = this.buscarDiaPromocao(diaPromocao.getDiaSemana());

		// Se existir algum prato promocional, deleta e cria o novo para o dia da semana
		// informado no request
		if (diaPromocaoExistente.isPresent()) {
			repository.delete(diaPromocaoExistente.get());
		}

		this.repository.save(diaPromocao);
	}

	/**
	 * MÉTODO COM STRATEGY ENUM
	 * @param diaPromocao
	 * @throws Exception
	 */
	public void salvarComStrategyEnum(DiaPromocao diaPromocao) throws Exception {

		diaPromocao.getDiaSemana().obterDescontoSemana(diaPromocao);
		Optional<DiaPromocao> diaPromocaoExistente = this.buscarDiaPromocao(diaPromocao.getDiaSemana());

		// Se existir algum prato promocional, deleta e cria o novo para o dia da semana
		// informado no request
		if (diaPromocaoExistente.isPresent()) {
			repository.delete(diaPromocaoExistente.get());
		}

		this.repository.save(diaPromocao);
	}

}
