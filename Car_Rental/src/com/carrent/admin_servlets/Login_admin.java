package com.carrent.admin_servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carrent.bdd.Client;
import com.carrent.beans.Admin_lg;
import com.carrent.beans.Utilisateur;

/**
 * Servlet implementation class Login_admin
 */
@WebServlet("/Login_admin")
public class Login_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin-views/admin_login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
Client cl=new Client();
		
		String username=request.getParameter("admin_username");
        String password=request.getParameter("admin_password");
        
        Admin_lg admin=new Admin_lg();
        admin.setPassword(password);
        admin.setUsername(username);
        
        try {
      	  
      	  if(cl.recuperAdmin(admin)) {
      		  
      		  HttpSession session=request.getSession();
      		  
      		  session.setAttribute("admin_username", username);
      		  
      		  
      		  response.sendRedirect("1212/camion");
      		  
      	  }
      	  else {
      		  response.sendRedirect("../connect");
      		  System.out.println("connectednot");
      		  
      	  }
      	  
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }


	}

}
