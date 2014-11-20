package br.com.matheuscs.votenolivro.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.matheuscs.votenolivro.model.ComputaVotos;
import br.com.matheuscs.votenolivro.model.ComputaVotosInterface;

public class ModelVotos {

	/*
	 * Da 3 votos em um mesmo livro e verifica se o sorteio
	 * esta finalizado
	 */
	@Test
	public void verificaFinalizado() {
		ComputaVotosInterface model = new ComputaVotos();
		model.somaVoto("Harry Potter");
		Assert.assertEquals(model.finalizado(), false);
		model.somaVoto("Harry Potter");
		Assert.assertEquals(model.finalizado(), false);
		model.somaVoto("Harry Potter");
		Assert.assertEquals(model.finalizado(), true);
	}
}
