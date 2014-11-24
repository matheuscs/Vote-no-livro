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

public class ModelVotos {

	private ComputaVotosInterface computaVotos;
	
	@Before
	public void inicializaModel() {
		LivroDAO livroDao = new LivroDAOImplMock();
		VotosLivroDAO votosLivroDao = new VotosLivrosDAOMock();
		computaVotos = new ComputaVotos(votosLivroDao, livroDao);
	}
	
	/*
	 * Da 3 votos em um mesmo livro e verifica se o sorteio
	 * esta finalizado
	 */
	@Test
	public void verificaFinalizado() {
		computaVotos.somaVoto("Harry Potter");
		Assert.assertEquals(computaVotos.finalizado(), false);
		computaVotos.somaVoto("Harry Potter");
		Assert.assertEquals(computaVotos.finalizado(), false);
		computaVotos.somaVoto("Harry Potter");
		Assert.assertEquals(computaVotos.finalizado(), true);
	}
}
