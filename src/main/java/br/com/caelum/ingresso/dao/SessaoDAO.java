package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Sessao sessao) {
		entityManager.persist(sessao);
	}

	public List<Sessao> buscar(Sala sala) {
		return entityManager.createQuery("select s from Sessao s where s.sala = :sala", Sessao.class)
				.setParameter("sala", sala).getResultList();
	}
}
