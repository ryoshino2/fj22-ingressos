package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.form.SessaoForm;

@Repository
public class SessaoDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar (SessaoForm sessao) {
		entityManager.persist(sessao);
	}
	
	public List<Sessao> buscar(Sala sala){
		return entityManager.createQuery("select s from Sessao where s.sala =: sala", Sessao.class).setParameter("sala", sala).getResultList();
	}
}
