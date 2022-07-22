package br.com.projetoImersaoAlura.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import br.com.projetoImersaoAlura.controller.JsonParser;
import br.com.projetoImersaoAlura.controller.StickersGenerator;

public class ConexaoAPI {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Tarefa: Criar uma conexão HTTP e buscar o Top 10 filmes.
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		URI endereco = URI.create(url);
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
		String body = response.body();

		// Tarefa: Extrair apenas os dados importantes.
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);

		// Tarefa: Criar as figurinhas.
		StickersGenerator stickerGenerator = new StickersGenerator();
		for (Map<String, String> filme : listaDeFilmes) {
			String urlImagem = filme.get("image");
			String titulo = filme.get("title").replace(":", " -");
			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo = titulo + ".png";
			stickerGenerator.generateSticker(inputStream, nomeArquivo);
			System.out.println(titulo);

		}
	}

}
