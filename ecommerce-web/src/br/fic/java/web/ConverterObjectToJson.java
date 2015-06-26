package br.fic.java.web;
import java.util.Date;

import br.fic.java.ejb.entity.Pedido;
import br.fic.java.facade.MessageCreatorService;

import com.google.gson.Gson; 

/*//classe com exemplo de uso do JSON 
//converte objeto ConverterObjectToJson para uma string JSON 
public class ConverterObjectToJson { 
	public static void main(String[] args) { 
		
		//instancia um filme e preenche suas propriedades
		Filme f = new Filme(); 
		f.titulo = "JSON x XML"; 
		f.ano = 2012; 
		f.generos = new ArrayList(); 
		f.generos.add("Aventura"); 
		f.generos.add("Ação"); 
		f.generos.add("Ficção"); 
		//instancia um objeto da classe Gson	
		Gson gson = new Gson(); 
		//pega os dados do filme, converte para JSON e armazena em string 
		String aux = gson.toJson(f); 
		//imprime os resultados 
		System.out.println(aux); 
	} 
}*/

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/testMensagemJson")
public class ConverterObjectToJson extends HttpServlet {
    private static final long serialVersionUID = -973490316445738120L;
    
    @EJB
    private MessageCreatorService messageCreatorService;
    
    private Pedido pedido;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>>Creating test message...");
        
        	pedido = new Pedido();
        	
        	pedido.setDataPedido(new Date());
        	pedido.setValorTotal(500);
        
        	//instancia um objeto da classe Gson	
      		Gson gson = new Gson();

      		//pega os dados do filme, converte para JSON e armazena em string 
      		String pedidoJson = gson.toJson(pedido); 
      		
      		//imprime os resultados 
      		System.out.println(pedidoJson); 
      		
      		messageCreatorService.sendMessage(pedidoJson);
 
    }
}