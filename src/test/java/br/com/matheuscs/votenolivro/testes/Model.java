package br.com.matheuscs.votenolivro.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.matheuscs.votenolivro.model.ComputaVotos;

public class Model {

	/*
	 * Verifica se a quantidade de livros participantes da aplica��o � aquele
	 * exigido no enunciado: 5
	 */
	@Test
	public void testeQtd() {
		Assert.assertEquals(5, new ComputaVotos().todosOsLivros().size());
	}
}
