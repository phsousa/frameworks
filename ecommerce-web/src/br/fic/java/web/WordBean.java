package br.fic.java.web;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.fic.java.ejb.WordService;

@ManagedBean
@SessionScoped
public class WordBean {
	
	@EJB
	private WordService service;  
	
	private String word;
	
	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public List<String> getWords(){
		return service.getAllwords();
	}
	
	public void add(){
		service.addWord(word);
	}
	
	
}
