package br.fic.java.facade;

import java.util.List;

import javax.ejb.Remote;

import br.fic.java.ejb.entity.Pedido;
import br.fic.java.ejb.entity.Produto;

@Remote
public interface PedidoService {
	
	public void salvarPedido(Pedido pedido);
	
	public List<Produto> listarTodosProdutos();
	
}
