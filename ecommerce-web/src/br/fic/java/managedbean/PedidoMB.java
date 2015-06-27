package br.fic.java.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import br.fic.java.ejb.entity.Item;
import br.fic.java.ejb.entity.Pedido;
import br.fic.java.ejb.entity.Produto;
import br.fic.java.facade.MessageCreatorService;
import br.fic.java.facade.PedidoService;
import br.fic.java.web.CadastroPedido;

import com.google.gson.Gson;

@Named(value="pedidoMB")
@RequestScoped
public class PedidoMB implements Serializable{

	private static final long serialVersionUID = 5034139674653171213L;

	private List<Produto> produtos;

	@EJB
	private PedidoService pedidoService;
	
	@EJB
	private MessageCreatorService messageCreatorService;

	private Pedido pedido;

	private Produto produto;

	private Item item;

	private ArrayList<CadastroPedido> carro; 

	private Integer valorTotal;	

	@PostConstruct
	public void init() {
		pedido = new Pedido();
		produtos = getProdutos();
		produto = new Produto();
	}

	//Metodo responsavel por salvar o pedido
	public void salvarPedido(){

		pedido.setDataPedido(new Date());

		pedidoService.salvarPedido(pedido);
		
		enviarPedidosFila(pedido);

	}

	//Resposavel por converter para JSON e enviar para fila.
	public void enviarPedidosFila(Pedido pedido) {
		
		//instancia um objeto da classe Gson	
		Gson gson = new Gson();

		//pega os dados do filme, converte para JSON e armazena em string 
		String pedidoJson = gson.toJson(pedido); 

		//imprime os resultados 
		System.out.println(pedidoJson); 

		messageCreatorService.sendMessage(pedidoJson);
	}

	//Metodo responsavel por obter todos os produtos
	public List<Produto> getProdutos(){

		produtos = pedidoService.listarTodosProdutos(); 

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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setCarro(ArrayList<CadastroPedido> carro){  
		this.carro = carro;  
	}  

	public ArrayList<CadastroPedido> getCarro(){  
		return carro;  
	}

	public void addPedidoItem(ActionEvent ev){  
		CadastroPedido c = new CadastroPedido();   
		carro.add(c); //adiciona na lista, vai aparecer no grid quando ele for atualizado  
	}
}
