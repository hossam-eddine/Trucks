package com.carrent.forms;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.carrent.bdd.Client;

/**
 * Servlet implementation class Imprimer
 */
@WebServlet("/Imprimer")
public class Imprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imprimer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession se=request.getSession();
		
		String name=(String)se.getAttribute("username");
		if(name==null) {
			
			response.sendRedirect("connect");
		}
		else {
		String prix=(String)se.getAttribute("prix");
		String marque=(String)se.getAttribute("marque");
		String Db=(String)se.getAttribute("Db");
		String Df=(String)se.getAttribute("Df");
		String mat=(String)se.getAttribute("matricule");
		request.setAttribute("prix", prix);
		request.setAttribute("marque",marque);
		request.setAttribute("Db",Db);
		request.setAttribute("Df",Df);
		request.setAttribute("mat",mat);
		/////date now 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
		Date dateobj = new Date();
		request.setAttribute("now", df.format(dateobj));
		
			 LocalDate localDate1 = LocalDate.parse(Db);
			 LocalDate localDate2 = LocalDate.parse(Df);
			 long days=Period.between(localDate1, localDate2).getDays();
			
			request.setAttribute("days",days);
		 


		
		
		
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/imprimer.jsp").forward(request, response);
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
