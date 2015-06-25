package br.java.fic.outro.ejb;
 
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.java.fic.entidade.User;
 
 
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/test") })
public class MessageConsumer implements MessageListener {
 
    @Override
    public void onMessage(Message message) {
        ObjectMessage objMsg = (ObjectMessage) message;
        try {
            System.out.println(">>>>> Receiving message with user " + ((User) objMsg.getObject()).getName());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
 
}