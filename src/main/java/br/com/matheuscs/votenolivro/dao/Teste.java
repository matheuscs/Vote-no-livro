package br.com.matheuscs.votenolivro.dao;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import br.com.matheuscs.votenolivro.entity.Livro;

public class Teste {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:root-context.xml");
		ctx.refresh();
		LivroDAO livroDao = ctx.getBean("livroDAO", LivroDAO.class);
		List<Livro> livros = livroDao.getTodosLivros();
		System.out.println(livros);
		ctx.close();
	}
}
