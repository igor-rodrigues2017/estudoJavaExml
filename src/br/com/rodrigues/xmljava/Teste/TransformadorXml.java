package br.com.rodrigues.xmljava.Teste;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformadorXml {
	public static void main(String[] args) throws Exception {
		InputStream dados = new FileInputStream("src/vendas.xml");
		InputStream xsl = new FileInputStream("src/xmlToHtml.xsl");
		
		StreamSource xslSource = new StreamSource(xsl);
		StreamSource dadosSource = new StreamSource(dados);
		
		StreamResult result = new StreamResult("src/vendasHtml.html");
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
		transformer.transform(dadosSource, result);

	}
}
