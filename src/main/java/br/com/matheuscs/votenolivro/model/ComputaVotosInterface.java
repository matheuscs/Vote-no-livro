package br.com.matheuscs.votenolivro.model;

import java.util.List;
import java.util.Map;

public interface ComputaVotosInterface {
	List<String> todosOsLivros();
	String sorteiaLivro(String titulo);
	void somaVoto(String titulo);
	Map<String, Integer> pegaResultado();
	boolean finalizado();
	void consolidaVotosNoRanking();
	Map<String, Integer> pegaTodosOsResultados();
}
