package br.com.matheuscs.votenolivro.testes;

import org.junit.Assert;
import org.junit.Test;

import br.com.matheuscs.votenolivro.dao.RankingLivrosDAO;

public class BD {
	
	@Test
	public void testaConexao() {
		System.out.println(RankingLivrosDAO.getInstance().leTodos());
		Assert.assertEquals(1, 1);
	}
}
