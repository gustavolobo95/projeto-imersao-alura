package br.com.projetoImersaoAlura.controller;

import java.util.List;

import br.com.projetoImersaoAlura.model.Conteudo;

public interface ExtratorDeConteudo {

	public List<Conteudo> extrairConteudo(String json);
	
}
