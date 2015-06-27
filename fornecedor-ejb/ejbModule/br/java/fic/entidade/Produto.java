package br.java.fic.entidade;

import java.io.Serializable;

public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;

	private Integer preco;
	
	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, Integer preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}
}
