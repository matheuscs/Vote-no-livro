package br.com.matheuscs.votenolivro.dao;

import java.util.List;

import br.com.matheuscs.votenolivro.entity.VotosLivro;

public interface VotosLivroDAO {
	void atualizaVotos(List<VotosLivro> votos);
	List<VotosLivro> getTodosOsVotos();
	int getVotosLivro(int idLivro);
}
