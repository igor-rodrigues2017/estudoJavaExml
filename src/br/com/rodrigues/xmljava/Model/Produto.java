package br.com.rodrigues.xmljava.Model;

public class Produto {

	private String nome;
	private double preco;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto() {
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nPreco: " + preco + "\n";
	}

}
