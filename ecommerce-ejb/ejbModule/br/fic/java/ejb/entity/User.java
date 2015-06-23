package br.fic.java.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="USUARIO")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
//	@Id
	private Integer id;
	
//	@Column(name="nome")
	private String name;
	
//	@Column(name="login")
	private String userName;
	
//	@Column(name="senha")
	private String senha;
	
	public User(){}
	
	public User(Integer id, String name, String userName, String senha) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.senha = senha;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
