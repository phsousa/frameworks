package br.java.fic.util;

import javax.ejb.Stateless;

import com.google.gson.Gson;

import br.java.fic.entidade.Pedido;

@Stateless
public class ConverterJsonToObject { 
	
	/**
	 * Responsavel por coonverter json em objeto
	 * @param mensagem
	 * @return pedidoConvertido
	 */
	public Pedido converteJson(String pedidoJson) {

		//instancia um objeto da classe Gson	
		Gson gson = new Gson(); 

		//instancia um filme e preenche seus dados com a informação vinda 
		//da string JSON 
		Pedido pedidoConvertido = gson.fromJson(pedidoJson, Pedido.class);
		
		//Retorna o pedido convertido em objeto.
		return pedidoConvertido;
	}

}

