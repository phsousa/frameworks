package br.fic.java.ejb;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class MySchedule {
	
	@Schedule(minute="*/30", hour="*")
	public void automaticTimer(){
		System.out.println("Schedule funcionando...");
	}
	
}
