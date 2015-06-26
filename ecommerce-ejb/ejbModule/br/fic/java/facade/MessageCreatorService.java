package br.fic.java.facade;

import javax.ejb.Remote;


@Remote
public interface MessageCreatorService {
	
	public void sendMessage(String string);
	
}
