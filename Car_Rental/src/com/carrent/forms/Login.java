package com.carrent.forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carrent.bdd.Client;
import com.carrent.beans.Utilisateur;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       Client cl=new Client();
          String cin=request.getParameter("cin");
          String username=request.getParameter("username");
          String password=request.getParameter("password");
          Utilisateur us=new Utilisateur();
          us.setCIN(cin);
          us.setPassword(password);
          us.setUsername(username);
          
          try {
        	  
        	  if(cl.recuperUtilisateur(us)) {
        		  
        		  HttpSession session=request.getSession();
        		  session.setAttribute("cin", cin);
        		  session.setAttribute("username", username);
        		  
        		  response.sendRedirect("camion");
        		  
        	  }
        	  else {
        		  response.sendRedirect("connect");
        		  
        	  }
        	  
          }
          
          catch (Exception e) {
              e.printStackTrace();
          }
	}

}
