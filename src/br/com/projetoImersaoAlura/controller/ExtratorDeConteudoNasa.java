package br.com.projetoImersaoAlura.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.projetoImersaoAlura.model.Conteudo;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {

	public List<Conteudo> extrairConteudo(String json) {
		// Tarefa: Extrair apenas os dados importantes.
				JsonParser parser = new JsonParser();
				List<Map<String, String>> listaDeConteudos = parser.parse(json);
				List<Conteudo> conteudos = new ArrayList<Conteudo>();
		for(Map<String, String> atributos: listaDeConteudos) {
			
			String titulo = atributos.get("title").replace(":", " -");
			String url = atributos.get("url");
			Conteudo conteudo = new Conteudo(url, titulo);
			conteudos.add(conteudo);
			
		}
		return conteudos;
	}
	
}
