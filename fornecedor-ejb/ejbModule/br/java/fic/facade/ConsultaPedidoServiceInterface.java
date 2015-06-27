package br.java.fic.facade;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.java.fic.entidade.Pedido;

@WebService
public interface ConsultaPedidoServiceInterface {
    
	@WebMethod
    List<Pedido> listar();
	
}