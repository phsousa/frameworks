package br.java.fic.facade;

import javax.ejb.Remote;

import br.java.fic.entidade.User;


@Remote
public interface MessageCreatorService {
	
	public void sendMessage(User user);
	
}
