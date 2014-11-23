package br.com.matheuscs.votenolivro.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheuscs.votenolivro.dao.LivroDAO;
import br.com.matheuscs.votenolivro.entity.Livro;

@Service("computaVotos")
public class ComputaVotos implements ComputaVotosInterface {

	private static final int VOTOS_GANHADOR = 3;
	
	private List<String> titulos = new ArrayList<String>();
	private Map<String, Integer> participacao = new HashMap<String, Integer>();
	private Map<String, Integer> resultado = new HashMap<String, Integer>();
	private int maxVotos;
	private int minParticipacao;
	
	@Autowired
	public ComputaVotos(LivroDAO livroDao) {
		super();
		titulos = Arrays.asList("ads", "sassds", "DF", "4", "5");
		/*
		for(Livro l: livroDao.getTodosLivros()) {
			titulos.add(l.getTitulo());
		}*/
		for(String s: titulos) {
			participacao.put(s, 0);
		}
		resultado.putAll(participacao);
	}

	/*
	 * Retorna todos os livros disponiveis para sorteio
	 */
	@Override
	public List<String> todosOsLivros() {
		return titulos;
	}

	/*
	 * Sorteia um livro, desde que ele atenda os criterios:
	 *  - Ja nao esteja sorteado para a comparacao atual
	 *  - Possua a menor quantidade de visualizacoes dentre todos
	 *  
	 *  Isso garante que todos os livros serao exibidos ao menos uma vez, e
	 *  nunca um livro tera sido exibido mais que duas vezes do que o menos
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
		System.out.println("Soma voto:" + titulo);
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
	 * Verifica se ja deu a quantidade maxima de votos que deveria
	 * 
	 */
	@Override
	public boolean finalizado() {
		System.out.println("Maxvotos:" + maxVotos);
		if(maxVotos >= VOTOS_GANHADOR) {
			return true;
		}
		else {
			return false;
		}
	}
}
