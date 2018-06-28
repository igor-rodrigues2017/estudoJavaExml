package br.com.rodrigues.xmljava.Handlers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.rodrigues.xmljava.Model.Produto;
/**
 * Logica para leitura das partes que me interessam que vão virar objeo na memória.
 * @author igor
 *
 */
public class ProdutosHandler extends DefaultHandler{
	
	private StringBuilder conteudo;
	private Produto produto;
	private List<Produto> produtos = new ArrayList<>();
	/**
	 * Inicio de um Element no xml: Ele "escuta" a cada nova tag acessada. E a cana nova tag ele cria um novo StringBuilder 
	 * para ler o conteudo. Quando for uma tag produto ele cria um Produto na memória
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("produto")) {
			produto = new Produto();
		}
		
		conteudo = new StringBuilder();
	}
	
	/**
	 * "Escuta" mais esse evento Lê o conteúdo da tag e guarda no StringBuilder;
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		conteudo.append(new String(ch, start, length));
	}
	
	/**
	 * Quando finaliza o elemento que foi inicializado, seta as variáveis de instancia do objeto criado;
	 * Adiciona o Objeto numa lista;
	 */
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("produto")) {
			produtos.add(produto);
		}else if(qName.equals("nome")) {
			produto.setNome(conteudo.toString());
		}else if(qName.equals("preco")) {
			produto.setPreco(Double.parseDouble(conteudo.toString()));
		}
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
}
