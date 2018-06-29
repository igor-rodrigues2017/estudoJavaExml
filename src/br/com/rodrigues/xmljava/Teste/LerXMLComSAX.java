package br.com.rodrigues.xmljava.Teste;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import br.com.rodrigues.xmljava.Handlers.ProdutosHandler;


public class LerXMLComSAX {
	public static void main(String[] args) throws Exception {
		InputStream ips = new FileInputStream("src/vendas.xml");
		InputSource is = new InputSource(ips);
		
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		ProdutosHandler logica = new ProdutosHandler();
		reader.setContentHandler(logica);
		reader.parse(is);
		
		System.out.println(logica.getProdutos());
		
	}
}
