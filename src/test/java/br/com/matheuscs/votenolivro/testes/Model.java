package br.com.matheuscs.votenolivro.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.matheuscs.votenolivro.dao.LivroDAO;
import br.com.matheuscs.votenolivro.dao.VotosLivroDAO;
import br.com.matheuscs.votenolivro.model.ComputaVotos;
import br.com.matheuscs.votenolivro.model.ComputaVotosInterface;
import br.com.matheuscs.votenolivro.testes.dao.LivroDAOImplMock;
import br.com.matheuscs.votenolivro.testes.dao.VotosLivrosDAOMock;

public class Model {

	private ComputaVotosInterface computaVotos;
	
	@Before
	public void inicializaModel() {
		LivroDAO livroDao = new LivroDAOImplMock();
		VotosLivroDAO votosLivroDao = new VotosLivrosDAOMock();
		computaVotos = new ComputaVotos(votosLivroDao, livroDao);
	}
	
	/*
	 * Verifica se a quantidade de livros participantes da aplicacao eh aquele
	 * exigido no enunciado: 5
	 */
	@Test
	public void testeQtd() {
		Assert.assertEquals(5, computaVotos.todosOsLivros().size());
	}
}
