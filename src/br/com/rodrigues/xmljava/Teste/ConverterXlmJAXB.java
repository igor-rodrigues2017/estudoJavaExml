package br.com.rodrigues.xmljava.Teste;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.rodrigues.xmljava.Model.Produto;
import br.com.rodrigues.xmljava.Model.Venda;

public class ConverterXlmJAXB {
	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);

		xmlParaObjeto(jaxbContext);
		
		ObjetoParaXml(jaxbContext);
	}

	private static void ObjetoParaXml(JAXBContext jaxbContext) throws Exception {
		Marshaller marshaller = jaxbContext.createMarshaller();
		Venda venda = new Venda();
		venda.setFormaDePagamento("Debito");
		List<Produto> produtos = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Produto produto = new Produto("Jujuba" ,10.50);
			produtos.add(produto);
		}
		venda.setProdutos(produtos);	
		marshaller.marshal(venda, new FileWriter("src/vendas2.xml"));
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws Exception {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		System.out.println(venda);
	}
}
