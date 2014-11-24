package br.com.matheuscs.votenolivro.testes.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import br.com.matheuscs.votenolivro.dao.VotosLivroDAO;
import br.com.matheuscs.votenolivro.entity.VotosLivro;

public class VotosLivrosDAOMock implements VotosLivroDAO {

	private List<VotosLivro> votosLivros = new ArrayList<VotosLivro>();
	
	@Before
	public void inicializa() {
		for(int i=0; i<5; i++) {
			VotosLivro v = new VotosLivro();
			v.setId(i+1);
			v.setVotos(0);
			votosLivros.add(v);
		}
	}
	
	@Override
	public void atualizaVotos(List<VotosLivro> votos) {
		for(VotosLivro vl: votos) {
			int votosAtual = getVotosLivro(vl.getId());
			vl.addVotos(votosAtual);
		}
	}

	@Override
	public List<VotosLivro> getTodosOsVotos() {
		return new ArrayList<VotosLivro>(votosLivros);
	}

	@Override
	public int getVotosLivro(int idLivro) {
		int votos = 0;
		for(VotosLivro vl: votosLivros) {
			if(vl.getId() == idLivro) {
				votos = vl.getVotos();
				break;
			}
		}
		return votos;
	}

}
