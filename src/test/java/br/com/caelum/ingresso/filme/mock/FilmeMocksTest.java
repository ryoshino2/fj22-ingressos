package br.com.caelum.ingresso.filme.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.model.Filme;

@RunWith(MockitoJUnitRunner.class)
public class FilmeMocksTest {

	@Mock
	private FilmeDao filmeDAO;

	private Filme filme, filmeNovo, filmeNovoA;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		filme = new Filme("Dragon Ball", Duration.ofMinutes(120), "Desenho", new BigDecimal(10.0));
		filmeNovo = new Filme("filme a", Duration.ofMinutes(120), "Desenho", new BigDecimal(10.0));
		filmeNovoA = new Filme("filme b", Duration.ofMinutes(120), "Desenho", new BigDecimal(10.0));
	}

	@Test
	public void listarTodosFilmesTest() {
		when(filmeDAO.findAll()).thenReturn(Arrays.asList(filme, filmeNovo, filmeNovoA));
		assertEquals(filmeDAO.findAll().size(), 3);
	}

	@Test
	public void listarFilmeQueExistePorIdTest() {
		when(filmeDAO.findOne(1)).thenReturn(filme);
		assertEquals(filmeDAO.findOne(1), filme);
	}

	@Test
	public void filmeDeveExistirNaListaTest() {
		when(filmeDAO.findAll()).thenReturn(Arrays.asList(filme, filmeNovo, filmeNovoA));
		assertTrue(filmeDAO.findAll().contains(filme));
	}

	@Test
	public void filmeNaoDeveExistirNaListaTest() {
		when(filmeDAO.findAll()).thenReturn(Arrays.asList(filme, filmeNovo));
		assertFalse(filmeDAO.findAll().contains(filmeNovoA));
	}
}