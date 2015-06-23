package br.fic.java.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class LogonServiceBeanImpl {
	
	private static Integer count;
	
	public boolean authenticate (String name, String password){
		
		if("fic".equals(name) && "123".equals(password)){
			count ++;
			return true;
		}
		
		return false;
		
	}
	
	public Integer getCount(){
		return count;
	}
	
	@PostConstruct
	public void init(){
		System.out.println(getClass().getName() + "inicializado!");
		count = 0;
	}
}
