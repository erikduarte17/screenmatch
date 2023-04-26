package br.com.alura.utilitario;

public class FiltroRecomendacao {

	public void filtra(Classificavel classificavel) {
		if(classificavel.getClassificacao() >= 4.5) {
			System.out.println("Excelente escolha!");
		}
		else if (classificavel.getClassificacao() >= 3.5) {
			System.out.println("Está entre as preferidas");
		}
		else {
			System.out.println("Assista quando tiver tempo livre");
		}
		
	}
	
}
