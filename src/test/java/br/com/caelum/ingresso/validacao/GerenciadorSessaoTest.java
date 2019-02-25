package br.com.caelum.ingresso.validacao;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorSessaoTest {
	
	private Filme rogueOne;
	private Sala sala3d;
	private Sessao sessaoDasDez;
	private Sessao sessaoDasTreze;
	private Sessao sessaoDasDezoito;
	
	@Before
	public void preparaSessoes() {
		this.rogueOne = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI");
		this.sala3d = new Sala ("Sala 3D");
		
		this.sessaoDasDez = new Sessao (LocalTime.parse("10:00:00"), rogueOne, sala3d);
		this.sessaoDasTreze = new Sessao(LocalTime.parse("13:00:00"), rogueOne, sala3d);
		this.sessaoDasDezoito = new Sessao (LocalTime.parse("18:00:00"), rogueOne, sala3d);
		
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		GerenciadorSessao gerenciador = new GerenciadorSessao(sessoes);
		Assert.assertFalse(gerenciador.cabe(sessaoDasDez));
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesTerminandoDentroDoHorarioDeUmaSessaoExistente() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		Sessao sessao = new Sessao(sessaoDasDez.getHorario().minusHours(1),rogueOne, sala3d);
		GerenciadorSessao gerenciador = new GerenciadorSessao(sessoes);
		Assert.assertFalse(gerenciador.cabe(sessao));
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesIniciandoDentroDoHorarioDeUmaSessaoJaExistente() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		GerenciadorSessao gerenciadorSessao = new GerenciadorSessao(sessoes);
		Sessao sessao = new Sessao(sessaoDasDez.getHorario().plusHours(1), rogueOne, sala3d);
		Assert.assertFalse(gerenciadorSessao.cabe(sessao));
	}
}
