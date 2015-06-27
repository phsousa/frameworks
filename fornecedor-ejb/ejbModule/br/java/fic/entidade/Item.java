package br.java.fic.entidade;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer quantidade;

	
	public Item() {
		super();
	}

	public Item(Integer id, Integer quantidade) {
		super();
		this.id = id;
		this.quantidade = quantidade;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
