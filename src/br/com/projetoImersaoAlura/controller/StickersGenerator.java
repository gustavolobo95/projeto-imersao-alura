package br.com.projetoImersaoAlura.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {
	
	// Criação do metodo de leitura da imagem:
	public void generateSticker(InputStream inputStream, String nomeArquivo) throws IOException {
		
		// Leitura da Imagem: 
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
	}
	
}
