package br.fic.java.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.fic.java.ejb.LogonServiceBeanImpl;

@ManagedBean
@SessionScoped
public class LogonControllerBean {
	private String userName;
	private String password;
	
	@EJB
	private LogonServiceBeanImpl logonService;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getCount(){
		return logonService.getCount();
	}
	
	public String authenticate(){
		String result = "logon";
		
		boolean ok = logonService.authenticate(userName, password);
		
		if( ok ){
			result = "home";
		}
		
		return result;
	}
}
