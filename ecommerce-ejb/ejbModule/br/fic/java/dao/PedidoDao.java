package br.fic.java.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fic.java.ejb.entity.Pedido;
import br.fic.java.ejb.entity.Produto;

public class PedidoDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="fic-pu")
	private EntityManager manager;
	
	@PersistenceContext(name="fic-pu")
	private ProdutoDao produtoDao;

	//Metodo responsavel por salvar o pedido
	public Pedido guardar(Pedido pedido) {
		
		return this.manager.merge(pedido);
		
	}
	
	public List<Produto> listarTodosProdutos(){
		
		return produtoDao.listarTodosProdutos();
	}
}
