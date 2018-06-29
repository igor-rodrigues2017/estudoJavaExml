package br.com.rodrigues.xmljava.Teste;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.rodrigues.xmljava.Model.Produto;

/**
 * Com essa abordagem todo o documento xml é carregado na memória. Isso é um
 * problema para arquivos grandes!
 * 
 * @author igor
 *
 */

public class LerXMLComDOMComXpath {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		fabrica.setValidating(true);
		fabrica.setNamespaceAware(true);
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
				"http://www.w3.org/2001/XMLSchema");

		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");

		String exp = "venda/produtos/produto[contains(nome,'O.O')]";
		XPath path = XPathFactory.newInstance().newXPath();
		XPathExpression expression = path.compile(exp);

		NodeList produtos = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println("moeda: " + moeda + "\n");
		for (int i = 0; i < produtos.getLength(); i++) {
			Element produto = (Element) produtos.item(i);
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
			Produto prod = new Produto(nome, preco);
			System.out.println(prod);
		}
	}
}
