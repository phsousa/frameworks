package br.java.fic.outro.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/*@MessageDriven(name="nameMDB", activationConfig = {
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination", propertyValue="java:/queue/test"),
		@ActivationConfigProperty(propertyName="acknowledgeMode", propertyValue="Auto-acknowledge")
})*/
public class NameMDB implements MessageListener {
	
	@Override
	public void onMessage(Message message) {
		
		TextMessage textMessage = (TextMessage) message;
		
		try {
			String name = textMessage.getText();
			System.out.println("Novo Usuario Cadastrado: " + name);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
