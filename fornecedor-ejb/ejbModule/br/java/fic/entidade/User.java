package br.java.fic.entidade;
import java.io.Serializable;


//@Entity
//@Table(name="USUARIO")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
//	@Column(name="nome")
	private String name;
	
	public User(){
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
