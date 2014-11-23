package br.com.matheuscs.votenolivro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.matheuscs.votenolivro.entity.VotosLivro;

@Repository("votosLivroDao")
@Transactional
public class VotosLivroDAOImpl implements VotosLivroDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void atualizaVotos(List<VotosLivro> votos) {
		for(VotosLivro vl: votos) {
			System.out.println(vl);
		}
		for(VotosLivro vl: votos) {
			int votosAtual = getVotosLivro(vl.getId());
			vl.addVotos(votosAtual);
			sessionFactory.getCurrentSession().merge(vl);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VotosLivro> getTodosOsVotos() {
		return sessionFactory.getCurrentSession().createQuery("from VotosLivro v").list();
	}

	@Override
	public int getVotosLivro(int idLivro) {
		VotosLivro votosLivro = (VotosLivro) sessionFactory.getCurrentSession()
				.createQuery("from VotosLivro v where v.id=:idLivro")
				.setParameter("idLivro", idLivro).list().get(0);
		System.out.println("votos: " +  votosLivro);
		return votosLivro.getVotos();
	}

}
