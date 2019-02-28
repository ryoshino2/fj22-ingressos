package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaBancos implements Desconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal precoOriginal) {
		return precoOriginal.multiply(new BigDecimal(0.7));
	}

	@Override
	public String getDescricao() {
		return "Desconto banco";
	}
}
