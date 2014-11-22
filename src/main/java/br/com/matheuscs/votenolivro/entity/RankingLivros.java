package br.com.matheuscs.votenolivro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RankingLivros {
	
	@Id
	private int idRanking;
	private String titulo;
	private int votos;
	private String nome;
	private String email;
	
	public RankingLivros() {
		super();
	}

	public int getIdRanking() {
		return idRanking;
	}

	public void setIdRanking(int idRanking) {
		this.idRanking = idRanking;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
