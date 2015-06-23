package br.fic.java.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloService {
	
	public String sayHello(String string);
	
}
