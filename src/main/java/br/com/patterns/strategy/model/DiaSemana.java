package br.com.patterns.strategy.model;

import br.com.patterns.strategy.promocaoStrategy.Desconto;

public enum DiaSemana implements Desconto {
	DOMINGO {
		@Override
		public void obterDescontoSemana(DiaPromocao diaPromocao) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.15));
		}
	},
	SEGUNDA {
		@Override
		public void obterDescontoSemana(DiaPromocao diaPromocao) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.1));
		}
	},
	TERCA {
		@Override
		public void obterDescontoSemana(DiaPromocao diaPromocao) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.3));	
		}

	},
	QUARTA {
		@Override
		public void obterDescontoSemana(DiaPromocao diaPromocao) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.2));
		}
	},
	QUINTA {
		@Override
		public void obterDescontoSemana(DiaPromocao diaPromocao) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.25));
		}
	},
	SEXTA {
		@Override
		public void obterDescontoSemana(DiaPromocao diaPromocao) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.05));
		}
	},
	SABADO {
		@Override
		public void obterDescontoSemana(DiaPromocao diaPromocao) {
			Double valor = diaPromocao.getValor();
			diaPromocao.setValor(valor - (valor * 0.01));
		}
	};

	
}
