package br.com.matheuscs.votenolivro.testes;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import br.com.matheuscs.votenolivro.dao.LivroDAO;
import br.com.matheuscs.votenolivro.entity.Livro;

public class Teste {
	
	public void testeAdd() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:root-context.xml");
		ctx.refresh();
		
		LivroDAO livroDao = ctx.getBean("livroDAO", LivroDAO.class);
		Livro l = new Livro();
		l.setId(1);
		l.setTitulo("Harry");
		System.out.println(l);
		livroDao.addLivro(l);
		ctx.close();
	}

	@Test
	public void testeRead() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:root-context.xml");
		ctx.refresh();
		
		LivroDAO livroDao = ctx.getBean("livroDAO", LivroDAO.class);
		List<Livro> livros = livroDao.getTodosLivros();
		System.out.println("Livros: " + livros);
		ctx.close();
	}
}
