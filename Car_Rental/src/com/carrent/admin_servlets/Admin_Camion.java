package com.carrent.admin_servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carrent.bdd.Client;
import com.carrent.beans.Truck;

/**
 * Servlet implementation class Admin_Camion
 */
@WebServlet("/Admin_Camion")
public class Admin_Camion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Camion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession hs=request.getSession();
		String admin=(String)hs.getAttribute("admin_username");
		if(admin==null) {
			response.sendRedirect("../connect");
			
		}
		else {
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin-views/camion_insert.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		Truck tr=new Truck();
		Double prix =Double.parseDouble(request.getParameter("prix"));
		tr.setMatricule(request.getParameter("admin_matricule"));
		tr.setMarque(request.getParameter("admin_marque"));
		tr.setPrix(prix);
		Client cl=new Client();
		cl.ajoutCamion(tr);
		
	}

}
