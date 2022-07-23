package br.com.projetoImersaoAlura.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import br.com.projetoImersaoAlura.controller.ClienteHTTP;
import br.com.projetoImersaoAlura.controller.ExtratorDeConteudoIMDB;
import br.com.projetoImersaoAlura.controller.ExtratorDeConteudoNasa;
import br.com.projetoImersaoAlura.controller.StickersGenerator;

public class ConexaoAPI {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Tarefa: Criar uma conexão HTTP e buscar o Top 10 filmes e as fotos astronomicas do dia de 11/07 a 23/07.
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		String url2 = "https://api.nasa.gov/planetary/apod?api_key=qDeeFcX02oTqRpnah9Pdq7uEd5rSalQ6OVHJcpPc&start_date=2022-07-11&end_date=2022-07-23";
		ClienteHTTP http = new ClienteHTTP();
		String json = http.buscarDados(url);
		String json2 = http.buscarDados(url2);
		
		// Tarefa: Criar as figurinhas do IMBD.
		ExtratorDeConteudoIMDB extratorIMDB = new ExtratorDeConteudoIMDB();
		List<Conteudo> listaDeConteudos = extratorIMDB.extrairConteudo(json);
		StickersGenerator stickerGenerator = new StickersGenerator();
		
		for (Conteudo conteudo: listaDeConteudos) {
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/filmes/" + conteudo.getTitulo() + ".png";
			
			stickerGenerator.generateSticker(inputStream, nomeArquivo);
			System.out.println(conteudo.getTitulo());
			System.out.println();
		}
		
		// Tarefa: Criar as figurinhas da NASA.
		ExtratorDeConteudoNasa extratorNASA = new ExtratorDeConteudoNasa();
		List<Conteudo> listaDeConteudos2 = extratorNASA.extrairConteudo(json2);
		
		for(Conteudo conteudo: listaDeConteudos2) {
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/nasa/" + conteudo.getTitulo() + ".png";
			
			stickerGenerator.generateSticker(inputStream, nomeArquivo);
			System.out.println(conteudo.getTitulo());
			System.out.println();
		}
		
	}

}
