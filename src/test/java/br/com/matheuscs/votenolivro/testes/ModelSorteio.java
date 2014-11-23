package br.com.matheuscs.votenolivro.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.matheuscs.votenolivro.model.ComputaVotos;
import br.com.matheuscs.votenolivro.model.ComputaVotosInterface;

public class ModelSorteio {

	/*
	 * Verifica se em nenhuma hiposteses esta sorteando livro null ou
	 * se esta sorteando livros repetidos
	 */
	@Test
	public void sorteiaInumeros() {
		/*ComputaVotosInterface model = new ComputaVotos();
		for(int i=0; i<1000; i++) {
			String titulo1 = model.sorteiaLivro(null);
			Assert.assertNotNull(titulo1);
			String titulo2 = model.sorteiaLivro(titulo1);
			Assert.assertNotSame(titulo1, titulo2);
		}*/
	}

	/*
	 * Sorteia um adversario para um mesmo livo.
	 * O livro escolhido (nao-sorteado) sera votado por 3 vezes consecutivas,
	 * e consequentemente deve ser eleito o vencedor
	 */
	@Test
	public void sorteiaAteFinalizar() {
		/*ComputaVotosInterface model = new ComputaVotos();
		String titulo1 = model.todosOsLivros().get(0);
		Assert.assertNotNull(titulo1);
		int i;
		for(i=0; !model.finalizado(); i++) {
			String titulo2 = model.sorteiaLivro(titulo1);
			Assert.assertNotSame(titulo1, titulo2);
			model.somaVoto(titulo1);
		}
		Assert.assertEquals(3, i);*/
	}
}
