package br.java.fic.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="ITEM")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column(name="id_produto", unique=true, nullable=false)
	private Integer id;
	
	@Column (name="quantidade")
	private Integer quantidade;
	
	
	
	public Item() {
		super();
	}

	public Item(Integer id, Integer quantidade) {
		super();
		this.id = id;
		this.quantidade = quantidade;
	}

	@OneToOne
    @PrimaryKeyJoinColumn
    private  Produto produto;
	
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
