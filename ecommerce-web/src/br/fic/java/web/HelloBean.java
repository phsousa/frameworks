package br.fic.java.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.fic.java.ejb.HelloService;

@ManagedBean
@SessionScoped
public class HelloBean {
	
	private String nome;
	private String out;
	
	@EJB
	private HelloService service;
			
	
	public String getOut() {
		return out;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public void execute(){
		
		this.out = service.sayHello(this.nome);
		
	}
}
