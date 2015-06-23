package br.fic.java.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Singleton
@Startup
public class ProgrammaticScheduleExemple {
	@Resource
	TimerService timerService;
	
	@PostConstruct
	public void createTimer(){
		System.out.println("Creating Timer... ");
		Timer timer = timerService.createTimer(1000, "Timer has been initialized...");
	}
	
	@Timeout
	public void timeout(Timer timer){
		System.out.println("Timeout of Programmatic Timer example...");
	}
}
