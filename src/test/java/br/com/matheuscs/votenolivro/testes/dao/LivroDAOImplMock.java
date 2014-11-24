package br.com.matheuscs.votenolivro.testes.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.matheuscs.votenolivro.dao.LivroDAO;
import br.com.matheuscs.votenolivro.entity.Livro;

public class LivroDAOImplMock implements LivroDAO {

	private List<Livro> livros = new ArrayList<Livro>();
	private static final List<String> titulos = Arrays.asList(
			"Harry Potter", 
			"Senhor dos Aneis",
			"Guia do Mochileiro das Galaxias",
			"Doctor Who",
			"Viagem ao Centro da Terra");
	
	public LivroDAOImplMock() {
		int i=0;
		for(String s: titulos) {
			Livro l = new Livro();
			l.setId(i++);
			l.setArquivo(s.substring(0, s.indexOf(' ')).toLowerCase());
			l.setTitulo(s);
			livros.add(l);
		}
	}
	
	@Override
	public void addLivro(Livro livro) {
		livros.add(livro);
	}

	@Override
	public Livro getLivro(int id) {
		Livro livro = null;
		for(Livro l: livros) {
			if(l.getId() == id) {
				livro = l;
				break;
			}
		}
		return livro;
	}

	@Override
	public Livro getLivro(String arquivo) {
		Livro livro = null;
		for(Livro l: livros) {
			if(l.getArquivo().equals(arquivo)) {
				livro = l;
				break;
			}
		}
		return livro;
	}

	@Override
	public List<Livro> getTodosLivros() {
		return new ArrayList<Livro>(livros);
	}

	@Override
	public void removeLivro(int idLivro) {
		livros.remove(getLivro(idLivro));
	}

}
