package br.com.matheuscs.votenolivro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VotosLivros")
public class VotosLivro {
	
	private int id;
	private int votos;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getVotos() {
		return votos;
	}
	
	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	public void addVotos(int votos) {
		this.votos += votos;
	}

	@Override
	public String toString() {
		return "VotosLivro [id=" + id + ", votos=" + votos + "]";
	}

}
