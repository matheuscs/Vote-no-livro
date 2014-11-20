package br.com.matheuscs.votenolivro.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ComputaVotos implements ComputaVotosInterface {

	private static final List<String> titulos = Arrays.asList(
			"Harry Potter", 
			"Senhor dos Aneis",
			"Guia do Mochileiro das Galaxias",
			"Doctor Who",
			"Viagem ao Centro da Terra");
	
	private static final int VOTOS_GANHADOR = 3;
	
	private static Map<String, Integer> participacao;
	private static Map<String, Integer> resultado;
	private int maxVotos;
	private int minParticipacao;
	
	public ComputaVotos() {
		super();
		participacao = new HashMap<String, Integer>();
		for(String s: titulos) {
			participacao.put(s, 0);
		}
		resultado = new TreeMap<String, Integer>();
		resultado.putAll(participacao);
	}

	/*
	 * Retorna todos os livros disponíveis para sorteio
	 */
	@Override
	public List<String> todosOsLivros() {
		return titulos;
	}

	/*
	 * Sorteia um livro, desde que ele atenda os criterios:
	 *  - Já não esteja sorteado para a comparação atual
	 *  - Possua a menor quantidade de visualizações dentre todos
	 *  
	 *  Isso garante que todos os livros serão exibidos ao menos uma vez, e
	 *  nunca um livro terá sido exibido mais que duas vezes do que o menos
	 *  exibido
	 */
	@Override
	public String sorteiaLivro(String titulo) {
		Collections.shuffle(titulos);
		for(int i=0; i<titulos.size(); i++) {
			String sorteado = titulos.get(i);
			if(sorteado.equals(titulo)) {
				continue;
			}
			if(participacao.get(sorteado) == minParticipacao) {
				participacao.put(sorteado, minParticipacao+1);
				
				minParticipacao = Integer.MAX_VALUE;
				for(Map.Entry<String, Integer> map: participacao.entrySet()) {
					if(map.getValue() < minParticipacao) {
						minParticipacao = map.getValue() ;
					}
				}
				return titulos.get(i);
			}
		}
		return null;
	}

	/*
	 * Cria ou atualiza um registro no BD computando o voto
	 */
	@Override
	public void somaVoto(String titulo) {
		if(resultado.containsKey(titulo)) {
			int i = resultado.get(titulo);
			System.out.println(i);
			i++;
			if(i > maxVotos) {
				maxVotos = i;
			}
			resultado.put(titulo, i);
		}
	}
	
	/*
	 * Retorna todos os registros do BD
	 */	
	@Override
	public Map<String, Integer> pegaResultado() {
		return resultado;
	}

	/*
	 * Verifica se já deu a quantidade máxima de votos que deveria
	 * 
	 */
	@Override
	public boolean finalizado() {
		if(maxVotos >= VOTOS_GANHADOR) {
			return true;
		}
		else {
			return false;
		}
	}
}
