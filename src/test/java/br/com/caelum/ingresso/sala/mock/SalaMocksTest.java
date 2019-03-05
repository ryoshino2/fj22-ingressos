package br.com.caelum.ingresso.sala.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Sala;

@RunWith(MockitoJUnitRunner.class)
public class SalaMocksTest {

	@Mock
	private SalaDao salaDao;
	
	private Sala sala, salaX;
	@Before
	public void setUp() {
		sala = new Sala("Sala 2D", new BigDecimal(10.00));
		salaX = new Sala("Sala XD", new BigDecimal(20.00));
	}
	@Test
	public void buscarSalaPorIdTest() {
		Mockito.when(salaDao.findOne(1)).thenReturn(sala);
		assertEquals(salaDao.findOne(1), sala);
	} 
	
	@Test
	public void buscarTodasAsSalasTest() {
		Mockito.when(salaDao.findAll()).thenReturn(Arrays.asList(sala, salaX));
		assertEquals(salaDao.findAll(), Arrays.asList(sala, salaX));
	}

	
	@Test
	public void salaDeveExistirNaLista() {
		when(salaDao.findAll()).thenReturn(Arrays.asList(sala, salaX));
		assertTrue(salaDao.findAll().contains(salaX));
	}

	@Test
	public void salaNaoDeveExistirNaLista() {
		when(salaDao.findAll()).thenReturn(Arrays.asList(sala));
		assertFalse(salaDao.findAll().contains(salaX));
	}
}
