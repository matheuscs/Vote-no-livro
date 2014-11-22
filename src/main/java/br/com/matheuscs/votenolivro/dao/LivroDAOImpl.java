package br.com.matheuscs.votenolivro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.matheuscs.votenolivro.entity.Livro;

@Repository("livroDAO")
@Transactional
public class LivroDAOImpl implements LivroDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addLivro(Livro livro) {
		sessionFactory.getCurrentSession().saveOrUpdate(livro);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Livro> getTodosLivros() {
		return sessionFactory.getCurrentSession().createQuery("from Livro l").list();
	}

	@Override
	public void removeLivro(int idLivro) {
		Livro livro = (Livro) sessionFactory.getCurrentSession().load(Livro.class, idLivro);
		if(livro != null) {
			sessionFactory.getCurrentSession().delete(livro);
		}
	}
}
