package br.fic.java.web;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.fic.java.ejb.entity.User;
import br.fic.java.ejb.entity.UserManager;


@ManagedBean
public class UserBean {

	@EJB
	private UserManager userManager;
	private User user = new User();
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public void save(){
		userManager.insert(user);
		user = new User();
	}
	
	public List<User> getUsers(){
		return userManager.getAll();
	}
}
