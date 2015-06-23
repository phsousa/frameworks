package br.fic.java.ejb.entity;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface UserManager {
	public List<User> getAll();
	
	public void insert(User user);
}
