package com.carrent.forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carrent.bdd.Client;
import com.carrent.beans.Reserve_Truck;
import com.carrent.beans.Utilisateur;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession se= request.getSession();
		String name=(String)se.getAttribute("username");
		if(name==null) {
			
			response.sendRedirect("connect");
		}
		else {
			
			
		
		Client cl=new Client();
	
	
		String cin=(String)se.getAttribute("cin");
		request.setAttribute("us", se.getAttribute("username"));
		se.setAttribute("prix",request.getParameter("price"));
		se.setAttribute("marque",request.getParameter("marque"));
		
		String matricule=request.getParameter("idC");
		request.setAttribute("mat", matricule);
        
         
        
       	  
       	  
       		this.getServletContext().getRequestDispatcher("/WEB-INF/reserve.jsp").forward(request, response);
       		    
       		  
		}
       	
       
	
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession se= request.getSession();
		String cin=(String)se.getAttribute("cin");
	
		 Reserve_Truck Rt=new Reserve_Truck();
		 Rt.setClient(cin);
		 Rt.setMatricule(request.getParameter("matricule"));
		 Rt.setDate_Debut(request.getParameter("Date_Debut"));
		 Rt.setDate_Fin(request.getParameter("Date_Fin"));
		 Client c=new Client();
		 c.ajoutResrvation(Rt);
		 se.setAttribute("Db",request.getParameter("Date_Debut"));
		 se.setAttribute("Df",request.getParameter("Date_Fin"));
		 se.setAttribute("matricule",request.getParameter("matricule"));
		 response.sendRedirect("imprimer");

		 
	}

}
