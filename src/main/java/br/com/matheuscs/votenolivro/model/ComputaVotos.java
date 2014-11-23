package br.com.matheuscs.votenolivro.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.matheuscs.votenolivro.dao.LivroDAO;
import br.com.matheuscs.votenolivro.dao.VotosLivroDAO;
import br.com.matheuscs.votenolivro.entity.Livro;
import br.com.matheuscs.votenolivro.entity.VotosLivro;

public class ComputaVotos implements ComputaVotosInterface {

	private static final int VOTOS_GANHADOR = 3;

	private List<String> arquivos = new ArrayList<String>();
	private Map<String, Integer> participacao = new HashMap<String, Integer>();
	private Map<String, Integer> resultado = new HashMap<String, Integer>();
	private int maxVotos;
	private int minParticipacao;

	VotosLivroDAO votosLivroDao;
	LivroDAO livroDao;
	
	public ComputaVotos(VotosLivroDAO votosLivroDao, LivroDAO livroDao) {
		this.votosLivroDao = votosLivroDao;
		this.livroDao = livroDao;
		for(Livro l: livroDao.getTodosLivros()) {
			arquivos.add(l.getArquivo());
		}
		for(String s: arquivos) {
			participacao.put(s, 0);
		}
		resultado.putAll(participacao);		
	}
	/*
	 * Retorna todos os livros disponiveis para sorteio
	 */
	@Override
	public List<String> todosOsLivros() {
		return arquivos;
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
	public String sorteiaLivro(String arquivo) {
		Collections.shuffle(arquivos);
		for(int i=0; i<arquivos.size(); i++) {
			String sorteado = arquivos.get(i);
			if(sorteado.equals(arquivo)) {
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
				return arquivos.get(i);
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
		Map<String, Integer> votos = new HashMap<String, Integer>();
		for(Map.Entry<String, Integer> map: resultado.entrySet()) {
			String titulo = livroDao.getLivro(map.getKey()).getTitulo();
			votos.put(titulo, map.getValue());
		}
		return votos;
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

	/*
	 * Adiciona o resultado da votacao da sessao atual na
	 * tabela de votos
	 * 
	 */
	@Override
	public void consolidaVotosNoRanking() {
		List<VotosLivro> votos = new ArrayList<VotosLivro>();
		for(Map.Entry<String, Integer> map: resultado.entrySet()) {
			VotosLivro v = new VotosLivro();
			Livro l = livroDao.getLivro(map.getKey());
			v.setId(l.getId());
			v.addVotos(map.getValue());
			votos.add(v);
		}
		votosLivroDao.atualizaVotos(votos);		
	}

	/*
	 * retorna todos os votos do raking, incluindo os votos
	 * de outros participantes
	 */
	@Override
	public Map<String, Integer> pegaTodosOsResultados() {
		Map<String, Integer> todosVotos = new HashMap<String, Integer>();
		for(VotosLivro v: votosLivroDao.getTodosOsVotos()) {
			String titulo = livroDao.getLivro(v.getId()).getTitulo();
			todosVotos.put(titulo, v.getVotos());
		}
		return todosVotos;
	}		
	
}
