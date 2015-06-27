package br.java.fic.service;
import br.java.fic.entidade.Pedido;
import br.java.fic.facade.ConsultaPedidoServiceInterface;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//http://localhost:8080/fornecedor-ejb/ConsultaPedidoService/ConsultaPedidoService
@Stateless
@WebService(serviceName="ConsultaPedidoService")
public class ConsultaPedidoService {

	public ConsultaPedidoService(){
	}

	@PersistenceContext(unitName="fic-pu")
	private EntityManager entityManager;         

	public void adicionarPedido(@WebParam(name = "pedido") Pedido pedido) {
		entityManager.persist(pedido);
	}    


	@SuppressWarnings({ "unused", "unchecked" })
	private List<Pedido> listarTodosPedidos() {
		return entityManager.createQuery("From Pedido").getResultList();
	}
}