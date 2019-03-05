package br.com.caelum.ingresso.lugar.mock;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

@RunWith(MockitoJUnitRunner.class)
public class LugarMockTest {
	@Mock
	private LugarDao lugarDao;

	private Ingresso ingresso;
	private Sessao sessao;
	private Lugar lugarA,lugarB;
	private Filme filme;
	private Sala sala;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		sala = new Sala ("teste", new BigDecimal(10.00));
		lugarA = new Lugar("a",1);
		lugarB = new Lugar("b",1);
		filme = new Filme("Dragon Ball", Duration.ofMinutes(120), "Desenho", new BigDecimal(10.0));
		sessao = new Sessao (LocalTime.parse ("10:00:00"), filme, sala);
		ingresso = new Ingresso(sessao, TipoDeIngresso.ESTUDANTE, lugarA);
	}
	
	@Test
	public void buscarLugarPorId() {
		Mockito.when(lugarDao.findOne(1)).thenReturn(lugarA);
		assertEquals(lugarDao.findOne(1), lugarB);
	}
	
}
