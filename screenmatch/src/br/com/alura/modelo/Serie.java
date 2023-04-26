package br.com.alura.modelo;

public class Serie extends Titulo {

	private int episodiosPorTemporada;
	private int temporadas;
	private int minutosPorEpisodio;
	
	public Serie(String nome, int anoDeLancamento) {
		super(nome, anoDeLancamento);
	}

	public int getEpisodiosPorTemporada() {
		return episodiosPorTemporada;
	}

	public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
		this.episodiosPorTemporada = episodiosPorTemporada;
	}
	
	public int getTemporadas() {
		return temporadas;
	}
	
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int getMinutosPorEpisodio() {
		return minutosPorEpisodio;
	}
	
	public void setMinutosPorEpisodio(int minutosPorEpisodio) {
		this.minutosPorEpisodio = minutosPorEpisodio;
	}

	@Override
	public int getDuracaoEmMinutos() {
		return temporadas * episodiosPorTemporada * minutosPorEpisodio;
	}
	
	@Override
	public String toString() {
		return "Serie: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
	}
	
}
