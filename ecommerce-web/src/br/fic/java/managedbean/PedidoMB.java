package br.fic.java.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.fic.java.dao.PedidoDao;
import br.fic.java.ejb.entity.Pedido;
import br.fic.java.ejb.entity.Produto;
import br.fic.java.facade.MessageCreatorService;

import com.google.gson.Gson;



@Named(value="pedidoMB")
@RequestScoped
public class PedidoMB implements Serializable{

	private static final long serialVersionUID = 5034139674653171213L;

	private List<Produto> produtos;

	@Inject
	private PedidoDao pedidoDao;

	private Pedido pedido;

	private Produto produto;

	private Integer valorTotal;	

	@PostConstruct
	public void reset() {
		pedido = new Pedido();
		//produtos = listarProdutos();
		produto = new Produto();
	}

	@EJB
	private MessageCreatorService messageCreatorService;

	//Metodo responsavel por salvar o pedido
	public void salvarPedido(){


		pedido.setDataPedido(new Date());

		
		/*produto.setNome("PH");
		produto.setPreco(100);
		
		produtos.add(produto);
		
		pedido.setProdutos(produtos);

		pedidoDao.guardar(pedido);*/

		//instancia um objeto da classe Gson	
		Gson gson = new Gson();

		//pega os dados do filme, converte para JSON e armazena em string 
		String pedidoJson = gson.toJson(pedido); 

		//imprime os resultados 
		System.out.println(pedidoJson); 

		messageCreatorService.sendMessage(pedidoJson);

	}

	//Metodo responsavel por obter todos os produtos
	public List<Produto> listarProdutos(){

		produtos = pedidoDao.listarTodosProdutos();
		
		return produtos;

	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}
}
