package br.java.fic.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Date dataPedido;
	
	private Integer valorTotal;

	private List<Item> itens;
	 
	public Pedido() {
		super();
	}
	
	public Pedido(Integer id, Date dataPedido, Integer valorTotal) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
