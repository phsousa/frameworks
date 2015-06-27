package br.fic.java.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fic.java.ejb.entity.Produto;

public class ProdutoDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(name="fic-pu")
	private EntityManager manager;
	
	//Metodo responsavel por salvar o produto
	public Produto guardar(Produto produto) {
		return this.manager.merge(produto);
	}
	
	//Metodo responsavel por obter todos os produtos
	public List<Produto> listarTodosProdutos() {
		
		@SuppressWarnings("unchecked")
		List<Produto> resultList = manager.createQuery("From Produto").getResultList();
		return resultList;
	}
	
}

