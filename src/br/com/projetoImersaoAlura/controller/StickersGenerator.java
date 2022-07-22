package br.com.projetoImersaoAlura.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {
	
	// Criação do metodo de leitura da imagem:
	public void generateSticker(InputStream inputStream, String nomeArquivo) throws IOException {
		
		// Leitura da Imagem: 
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// Cria uma nova imagem em memoria com transparencia e tamanho novo: 
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// Copiar a imagem original para nova imagem (em memoria):
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
	}
	
}
