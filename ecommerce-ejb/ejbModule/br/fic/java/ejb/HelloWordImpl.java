package br.fic.java.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

@Stateful
public class HelloWordImpl implements WordService {
	
	
	private List<String> words = new ArrayList<String>();
	
	
	@Override
	public void addWord(String word) {
		
		this.words.add(word);

	}

	@Override
	public List<String> getAllwords() {
		
		return this.words;
	}

}
