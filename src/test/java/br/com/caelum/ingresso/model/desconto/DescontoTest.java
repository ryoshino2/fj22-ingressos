package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;
import br.com.caelum.ingresso.model.descontos.DescontoParaBancos;
import br.com.caelum.ingresso.model.descontos.DescontoParaEstudantes;

public class DescontoTest {
	private Filme rogueOne;
	private Sala sala3d;
	private Sessao sessaoDasDez;
	private Lugar lugar;

	@Before
	public void setUp() {
		this.lugar = new Lugar("A", 1);
		this.rogueOne = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.TEN);
		this.sala3d = new Sala("Sala 3D", new BigDecimal(10.00));
		this.sessaoDasDez = new Sessao(LocalTime.parse("10:00:00"), rogueOne, sala3d);
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
		Ingresso ingresso = new Ingresso(sessaoDasDez, TipoDeIngresso.NORMAL, lugar);
		BigDecimal precoEsperado = new BigDecimal("20.00");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void descontoParaEstudante() {
		Ingresso ingresso = new Ingresso(sessaoDasDez, TipoDeIngresso.ESTUDANTE, lugar);
		BigDecimal precoEsperado = new BigDecimal("10.00");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void descontoParaBanco() {
		Ingresso ingresso = new Ingresso(sessaoDasDez, TipoDeIngresso.BANCO, lugar);
		BigDecimal precoEsperado = new BigDecimal("14.00");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

}
