package com.carrent.forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carrent.bdd.Client;

/**
 * Servlet implementation class Camion
 */
@WebServlet("/Camion")
public class Camion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Camion() {
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
		request.setAttribute("Trucks", cl.recupererTrucks());
		
		String user=(String)se.getAttribute("cin");
		
		
		request.setAttribute("user", user);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/truck.jsp").forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
