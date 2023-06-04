package br.com.alura.principal;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.modelo.Titulo;
import br.com.alura.modelo.TituloRecord;

public class ComunicacaoHTTP {

	public static void main(String[] args) throws Exception {

		var scan = new Scanner(System.in);
		var busca = "";
		List<Titulo> titulos = new ArrayList<>();

		Gson gson = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.setPrettyPrinting()
				.create();

		while (!busca.equalsIgnoreCase("sair")) {

			System.out.println("Entre com o nome do filme");
			busca = scan.nextLine();

			if (busca.equalsIgnoreCase("sair")) {
				break;
			}

			String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "*************";
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			TituloRecord tituloOMDB = gson.fromJson(response.body(), TituloRecord.class);
			System.out.println(tituloOMDB);

			try {
				Titulo titulo = new Titulo(tituloOMDB);
				titulos.add(titulo);
				System.out.println(titulo);
			} catch (NumberFormatException e) {
				System.out.println("Entrada de números incorreta: " + e.getMessage());
			}

		}

		FileWriter writer = new FileWriter("src\\titulos.txt");
		writer.write(gson.toJson(titulos));

		writer.close();
		scan.close();
		
	}

}
