package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorSessao {
	private List<Sessao> sessoesDaSala;

	public GerenciadorSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

	private boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova) {
		LocalDate hoje = LocalDate.now();

		LocalDateTime horarioSessaoExistente = sessaoExistente.getHorario().atDate(hoje);
		LocalDateTime terminoSessaoExistente = sessaoExistente.getHorarioTermino().atDate(hoje);
		LocalDateTime horarioNova = sessaoNova.getHorario().atDate(hoje);
		LocalDateTime terminoNova = sessaoNova.getHorarioTermino().atDate(hoje);
		boolean terminaAntes = terminoNova.isBefore(horarioSessaoExistente);
		boolean comecaDepois = terminoSessaoExistente.isBefore(horarioNova);

		if (terminaAntes || comecaDepois) {
			return false;
		}
		return true;

	}
	
	public boolean cabe (Sessao sessaoNova) {
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaoNova));
		
	}
}
