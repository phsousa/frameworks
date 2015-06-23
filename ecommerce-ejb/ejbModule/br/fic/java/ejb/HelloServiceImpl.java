package br.fic.java.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello(String string) {
		
		return "Hello, " + string;
	}
	
}
