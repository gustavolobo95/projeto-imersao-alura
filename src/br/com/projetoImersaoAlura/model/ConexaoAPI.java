package br.com.projetoImersaoAlura.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import br.com.projetoImersaoAlura.controller.JsonParser;

public class ConexaoAPI {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Tarefa: Criar uma conexão HTTP e buscar o Top 10 filmes.
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		URI endereco = URI.create(url);
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		//Tarefa: Extrair apenas os dados importantes.
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
	}
	
}
