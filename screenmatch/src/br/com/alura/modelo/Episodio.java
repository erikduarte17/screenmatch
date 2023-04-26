package br.com.alura.modelo;

import br.com.alura.utilitario.Classificavel;

public class Episodio implements Classificavel {

	private Serie serie;
	private String nome;
	private int numero;
	private int totalVisualizacoes;

	public Episodio(Serie serie, String nome, int numero) {
		this.serie = serie;
		this.nome = nome;
		this.numero = numero;
	}

	public Serie getSerie() {
		return serie;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getTotalVisualizacoes() {
		return totalVisualizacoes;
	}
	
	public void setTotalVisualizacoes(int totalVisualizacoes) {
		this.totalVisualizacoes = totalVisualizacoes;
	}
	
	@Override
	public double getClassificacao() {
		switch (this.totalVisualizacoes / 100) {
		case 0:
			return 0;
		case 1:
			return 3;
		case 2:
			return 3.25;
		case 3:
			return 3.5;
		case 4:
			return 4;
		case 5:
			return 4.5;
		default:
			return 5;
		}
	}

}
