package br.fic.java.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface WordService {
	
	public void addWord(String word);
	
	public List<String> getAllwords();
	
}
