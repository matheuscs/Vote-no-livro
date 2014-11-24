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

public class ModelSorteio {

	private ComputaVotosInterface computaVotos;
	
	@Before
	public void inicializaModel() {
		LivroDAO livroDao = new LivroDAOImplMock();
		VotosLivroDAO votosLivroDao = new VotosLivrosDAOMock();
		computaVotos = new ComputaVotos(votosLivroDao, livroDao);
	}
	
	/*
	 * Verifica se em nenhuma hiposteses esta sorteando livro null ou
	 * se esta sorteando livros repetidos
	 */
	@Test
	public void sorteiaInumeros() {
		for(int i=0; i<1000; i++) {
			String titulo1 = computaVotos.sorteiaLivro(null);
			Assert.assertNotNull(titulo1);
			String titulo2 = computaVotos.sorteiaLivro(titulo1);
			Assert.assertNotSame(titulo1, titulo2);
		}
	}

	/*
	 * Sorteia um adversario para um mesmo livo.
	 * O livro escolhido (nao-sorteado) sera votado por 3 vezes consecutivas,
	 * e consequentemente deve ser eleito o vencedor
	 */
	@Test
	public void sorteiaAteFinalizar() {
		String titulo1 = computaVotos.todosOsLivros().get(0);
		Assert.assertNotNull(titulo1);
		int i;
		for(i=0; !computaVotos.finalizado(); i++) {
			String titulo2 = computaVotos.sorteiaLivro(titulo1);
			Assert.assertNotSame(titulo1, titulo2);
			computaVotos.somaVoto(titulo1);
		}
		Assert.assertEquals(3, i);
	}
}
