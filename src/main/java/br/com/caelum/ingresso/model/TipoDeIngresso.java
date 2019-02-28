package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.descontos.Desconto;
import br.com.caelum.ingresso.model.descontos.DescontoParaBancos;
import br.com.caelum.ingresso.model.descontos.DescontoParaEstudantes;
import br.com.caelum.ingresso.model.descontos.SemDesconto;

public enum TipoDeIngresso {
	
	ESTUDANTE(new DescontoParaEstudantes()),
	NORMAL (new SemDesconto()),
	BANCO(new DescontoParaBancos());
	
	private Desconto desconto;
	
	TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}
	
	public BigDecimal aplicarDesconto(BigDecimal valor) {
		return desconto.aplicarDesconto(valor);
	}
	
	public String getDescricao() {
		return desconto.getDescricao();
	}

}
