package br.com.matheuscs.votenolivro.testes;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.matheuscs.votenolivro.dao.LivroDAO;
import br.com.matheuscs.votenolivro.entity.Livro;

public class Persistencia {
	
	@Autowired
	private LivroDAO livroDao;

	@Test
	@Transactional
	public void testeRead() {
		List<Livro> livros = livroDao.getTodosLivros();
		System.out.println("Livros: " + livros);
	}
}
