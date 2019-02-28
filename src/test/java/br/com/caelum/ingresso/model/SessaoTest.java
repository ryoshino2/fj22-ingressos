package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;


public class SessaoTest {
//	@Test
//	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisPrecoDoFilme() {
//		Sala sala = new Sala ("Sala 3d", new BigDecimal(15.01));
//		Filme filme = new Filme ("Dragon Ball", Duration.ofMinutes(120),"Desenho", new BigDecimal(10.00));
//		BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
//		Sessao sessao = new Sessao (LocalTime.parse ("10:00:00"), filme, sala);
//		Assert.assertEquals(somaDosPrecosDaSalaEFilme, 25.01);
//	}
//	
	@Test
	public void garanteQueOLugarA1EstaOcupadoEOsLugaresA2A3Disponiveis() {
		Lugar a1 = new Lugar("a",1);
		Lugar a2 = new Lugar("a",2);
		Lugar a3 = new Lugar("a",3);
		Filme filme = new Filme ("Dragon Ball", Duration.ofMinutes(120),"Desenho", new BigDecimal(10.0));
		Sala sala = new Sala ("Sala 3d", new BigDecimal(10.0));
		Sessao sessao = new Sessao (LocalTime.parse ("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.NORMAL, a1);
		
		Set<Ingresso> ingressos =Stream.of(ingresso).collect(Collectors.toSet());
		sessao.setIngressos(ingressos);
		
		Assert.assertFalse(sessao.isDisponivel(a1));
		Assert.assertTrue(sessao.isDisponivel(a2));
		Assert.assertTrue(sessao.isDisponivel(a3));
		
	}
}
