package br.com.projetoImersaoAlura.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import br.com.projetoImersaoAlura.controller.ClienteHTTP;
import br.com.projetoImersaoAlura.controller.JsonParser;
import br.com.projetoImersaoAlura.controller.StickersGenerator;

public class ConexaoAPI {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Tarefa: Criar uma conexão HTTP e buscar o Top 10 filmes.
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		ClienteHTTP http = new ClienteHTTP();
		String json = http.buscarDados(url);
		
		// Tarefa: Extrair apenas os dados importantes.
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(json);

		// Tarefa: Criar as figurinhas.
		StickersGenerator stickerGenerator = new StickersGenerator();
		for (Map<String, String> filme : listaDeFilmes) {
			String urlImagem = filme.get("image");
			String titulo = filme.get("title").replace(":", " -");
			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo = "saida/" + titulo + ".png";
			stickerGenerator.generateSticker(inputStream, nomeArquivo);
			System.out.println(titulo);

		}
	}

}
