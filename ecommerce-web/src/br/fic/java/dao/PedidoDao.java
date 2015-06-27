package br.fic.java.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.fic.java.ejb.entity.Pedido;
import br.fic.java.ejb.entity.Produto;

public class PedidoDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Inject
	private ProdutoDao produtoDao;

	//Metodo responsavel por salvar o pedido
	public Pedido guardar(Pedido pedido) {
		
		return this.manager.merge(pedido);
		
	}
	
	public List<Produto> listarTodosProdutos(){
		
		return produtoDao.listarTodosProdutos();
	}
}
