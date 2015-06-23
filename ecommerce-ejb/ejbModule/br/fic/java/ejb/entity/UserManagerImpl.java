package br.fic.java.ejb.entity;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserManagerImpl implements UserManager {
	
	@Resource(name="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(lookup="java:/queue/test")
	private Queue inboundQueue;
	
	@PersistenceContext(name="fic-pu")
	private EntityManager entityManager;
	
	@Override
	public List<User> getAll() {
		
		Query query = entityManager.createQuery("select u from User u");
		
		return query.getResultList();
		
	}

	@Override
	public void insert(User user) {
		
		entityManager.persist(user);
		
		sendMessage(user.getName());
	}

	private void sendMessage(String name) {
		
		try {
			Connection connection = connectionFactory.createConnection();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			MessageProducer producer = session.createProducer(inboundQueue);
			
			TextMessage message = session.createTextMessage();
			message.setText(name);
			
			producer.send(message);		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
