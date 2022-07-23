package br.com.projetoImersaoAlura.model;

public class Conteudo {
	
	private final String urlImagem;
	private final String titulo;
	
	public Conteudo(String urlImagem, String titulo) {
		this.urlImagem = urlImagem;
		this.titulo = titulo;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	public String getTitulo() {
		return titulo;
	}
	
}
