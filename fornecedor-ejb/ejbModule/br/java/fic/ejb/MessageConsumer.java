package br.java.fic.ejb;
 
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.java.fic.entidade.Pedido;
import br.java.fic.util.ConverterJsonToObject;
 
 
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/test") })
public class MessageConsumer implements MessageListener {
	
	@EJB
	private ConverterJsonToObject converterJsonToObject;
	
	Pedido pedido;
	
    @Override
    public void onMessage(Message message) {
        ObjectMessage objMsg = (ObjectMessage) message;
        try {
        	
        	pedido = new Pedido();
        	pedido = converterJsonToObject.converteJson(objMsg.getObject().toString());
        	System.out.println(pedido.getValorTotal());
        	System.out.println(pedido.getDataPedido());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
 
}

