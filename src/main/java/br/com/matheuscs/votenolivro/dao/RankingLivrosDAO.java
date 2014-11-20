package br.com.matheuscs.votenolivro.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.matheuscs.votenolivro.model.RankingLivros;

public class RankingLivrosDAO {

	private EntityManager entityManager;
	private static RankingLivrosDAO local;
	
	private RankingLivrosDAO() {
	}
	
	public static RankingLivrosDAO getInstance() {
		if (local == null) {
			local = new RankingLivrosDAO();
			local.entityManager = HibernateUtil.getEntityManager();
		}
		return local;
	}
	
	public void insere(RankingLivros ranking) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(ranking);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void insere(List<RankingLivros> ranking) {
		for(RankingLivros r: ranking) {
			insere(r);
		}
	}
	
	public List<RankingLivros> leTodos() {
		try {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<RankingLivros> caminhoes = entityManager.createQuery("from RankingLivros").getResultList();
			entityManager.getTransaction().commit();
			return caminhoes;
		} catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}
	
	public void deletaTodos() {
		try {
			entityManager.getTransaction().begin();
			entityManager.createQuery("DELETE FROM RankingLivros").executeUpdate();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
}
