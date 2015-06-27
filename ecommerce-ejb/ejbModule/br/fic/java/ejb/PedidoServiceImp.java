package br.fic.java.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.fic.java.ejb.entity.Pedido;
import br.fic.java.ejb.entity.Produto;
import br.fic.java.facade.PedidoService;

@Stateful
public class PedidoServiceImp implements PedidoService{

	@PersistenceContext(name = "fic-pu")
	EntityManager entityManager;
	
	@PostConstruct
    public void init() {
    }
	
	public void salvarPedido(Pedido pedido) {
		entityManager.merge(pedido);
	}

	public List<Produto> listarTodosProdutos() {
		
		Query query = entityManager.createQuery("Select p From Produto p");
		return query.getResultList();
	}
	
}
