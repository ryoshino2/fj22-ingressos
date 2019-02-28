package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaEstudantes implements Desconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal precoOriginal) {
		return precoOriginal.divide(new BigDecimal(2));
	}

	@Override
	public String getDescricao() {
		return "Desconto Estudante";
	}

}
