package br.com.alura.modelo;

import br.com.alura.utilitario.Classificavel;

public class Filme extends Titulo implements Classificavel{

	private String diretor;
	
	public Filme(String nome, int anoDeLancamento, String diretor) {
		super(nome, anoDeLancamento);
		this.diretor = diretor;
	}

	public String getDiretor() {
		return diretor;
	}
	
	@Override
	public String toString() {
		return "Filme: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
	}

	@Override
	public double getClassificacao() {
		return this.pegaMedia() / 2;
	}
	
	
}
