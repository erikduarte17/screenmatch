package br.com.alura.modelo;

public class Titulo {

	private String nome;
	private int anoDeLancamento;
	private double somaAvaliacoes;
	private int totalAvaliacoes;
	private int duracaoEmMinutos;

	public Titulo(String nome, int anoDeLancamento) {
		this.nome = nome;
		this.anoDeLancamento = anoDeLancamento;
	}

	public Titulo(TituloRecord tituloOMDB) {
		this.nome = tituloOMDB.title();
		this.anoDeLancamento = Integer.valueOf(tituloOMDB.year().substring(0,4));
		if(tituloOMDB.runtime().length() < 7) {
			this.duracaoEmMinutos = Integer.valueOf(tituloOMDB.runtime().substring(0,2));
		} else {
			this.duracaoEmMinutos = Integer.valueOf(tituloOMDB.runtime().substring(0,3));
		}
	}

	public String getNome() {
		return nome;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public int getTotalAvaliacoes() {
		return totalAvaliacoes;
	}
	
	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	public void avalia(Double nota) {
		this.somaAvaliacoes += nota;
		this.totalAvaliacoes++;
	}

	public void exibeInformacoes() {
		System.out.println("Nome do titulo: " + this.nome);
		System.out.println("Ano de lançamento: " + this.anoDeLancamento);
	}
	
	public double pegaMedia() {
		return somaAvaliacoes / totalAvaliacoes;
	}
	
	private int compareTo(Titulo outroTitulo) {
		return this.getNome().compareTo(outroTitulo.getNome());
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.getNome() + "(" + this.anoDeLancamento + " - " + this.duracaoEmMinutos + "min)";
	}
}
