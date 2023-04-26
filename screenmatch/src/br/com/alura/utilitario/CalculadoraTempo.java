package br.com.alura.utilitario;

import br.com.alura.modelo.Titulo;

public class CalculadoraTempo {

	private int tempoTotal;
	
	public int getTempoTotal() {
		return tempoTotal;
	}
	
	public void incluir(Titulo titulo) {
		System.out.println("Incluindo na lista de desejos: " + titulo);
		this.tempoTotal += titulo.getDuracaoEmMinutos();
	}
	
}
