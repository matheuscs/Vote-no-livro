package br.com.matheuscs.votenolivro.dao;

import java.util.List;

import br.com.matheuscs.votenolivro.entity.Livro;

public interface LivroDAO {
	public void addLivro(Livro livro);
	public Livro getLivro(int id);
	public Livro getLivro(String arquivo);
	public List<Livro> getTodosLivros();
	public void removeLivro(int idLivro);
}
