package br.java.fic.fila;
 
import java.io.IOException;
 




import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.java.fic.entidade.User;
import br.java.fic.facade.MessageCreatorService;
 
@WebServlet("/test")
public class ServletCreateMessage extends HttpServlet {
    private static final long serialVersionUID = -973490316445738120L;
 
    @EJB
    private MessageCreatorService messageCreatorService;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>>Creating test message...");
        User user = new User();
        user.setName("Paulo Henrique");
        messageCreatorService.sendMessage(user);
    }
}