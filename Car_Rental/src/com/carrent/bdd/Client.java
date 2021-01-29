package com.carrent.bdd;

import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.carrent.admin_servlets.Admin_Camion;
import com.carrent.beans.Admin_lg;
import com.carrent.beans.Reserve_Truck;
import com.carrent.beans.Truck;
import com.carrent.beans.Utilisateur;

public class Client {
	Connection connexion;
	
	  public boolean recuperUtilisateur(Utilisateur ut){
	  boolean status =false;
	  
		  
	  loadDatabase();
	  try {
		  
		 
		 //create statement  using connexion object
		  PreparedStatement preparedStatement=connexion.prepareStatement("select  * from client where CIN=? and password=? and username=?");
		  preparedStatement.setString(1, ut.getCIN());
		  preparedStatement.setString(2, ut.getPassword());
		  preparedStatement.setString(3, ut.getUsername());
		 
		
		 // System.out.println(preparedStatement);
		
		  ResultSet rs=preparedStatement.executeQuery();
		  
		    status=rs.next();
			  
		
		 
		 
		  
	  }
	  catch(SQLException e) {
		    
		  e.printStackTrace();
		  }
	  
	  
	 return status;
	  
	  
	  
	  
	  }
	 
	
	
	
	  private void loadDatabase() {
	        // Chargement du driver
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        }

	        try {
	            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/location_devoiture", "root", "root");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  //register client ///
	  public  void ajoutUtilisateur(Utilisateur us) {
		  loadDatabase();
		  try {
			PreparedStatement preparedStatement=connexion.prepareStatement("INSERT INTO client(CIN,username,email,password) values(?,?,?,?);");
			preparedStatement.setString(1, us.getCIN());
			preparedStatement.setString(2, us.getUsername());
			preparedStatement.setString(3,us.getEmail());
			preparedStatement.setString(4, us.getPassword());
		
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  
	  }
	  
	  //INSERTION RESERVATION ///
	  
	  public void ajoutResrvation(Reserve_Truck rt) {
		 
		  loadDatabase();
		  try {
			  PreparedStatement preparedStatement=connexion.prepareStatement("insert into reservation(Date_Debut,Date_Fin,Clientid,CamionMatricule) values(?,?,?,?)");
			  preparedStatement.setString(1,rt.getDate_Debut() );
			  preparedStatement.setString(2, rt.getDate_Fin());
			  preparedStatement.setString(3, rt.getClient());
			  preparedStatement.setString(4, rt.getMatricule());
			  preparedStatement.executeUpdate();
			  
			  
		  }catch (SQLException e) {
			  
			// TODO: handle exception
			  e.printStackTrace();
		}
		  
		  
		  
	  }
	  ////afficher les camions disponibles///
	  public List<Truck> recupererTrucks( ) {
		  
	        List<Truck> Trs = new ArrayList<Truck>();
	        Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT * FROM Camion;");
                
	            // Récupération des données
	            while (resultat.next()) {
	                String matricule = resultat.getString("matricule");
	                String marque = resultat.getString("marque");
	                Double  prix=resultat.getDouble("prix");
	                Truck tr=new Truck();
	                tr.setMarque(marque);
	                tr.setMatricule(matricule);
	                tr.setPrix(prix);
	               
	                
	                Trs.add(tr);
	            }
	        } catch (SQLException e) {
	        } finally {
	            // Fermeture de la connexion
	            try {
	                if (resultat != null)
	                    resultat.close();
	                if (statement != null)
	                    statement.close();
	                if (connexion != null)
	                    connexion.close();
	            } catch (SQLException ignore) {
	            }
	        }
	        
	        return Trs;
	    }
	  	  
	  ////////////////////////////////////////////////
	  
	  
	  
	  public List<Reserve_Truck>reserve(HttpServletRequest rq) {
		  
	        List<Reserve_Truck> Trs = new ArrayList<Reserve_Truck>();
	       
	        ResultSet resultat = null;

	        loadDatabase();
	        Reserve_Truck rt=null;
	        try {
	            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM reservation where Clientid= ?");
             HttpSession sw=rq.getSession();
             String cin=(String)sw.getAttribute("cin");
	            // Exécution de la requête
             statement.setString(1, cin);
	            resultat = statement.executeQuery();
              System.out.println(resultat);
	            // Récupération des données
	            while (resultat.next()) {
	             
	                String Date_Debut = resultat.getString("Date_Debut");
	                String Date_Fin = resultat.getString("Date_Fin");
	                String  matricule=resultat.getString("CamionMatricule");
	                rt=new Reserve_Truck();
	               rt.setDate_Debut(Date_Debut);
                  rt.setDate_Fin(Date_Fin);
                  rt.setMatricule(matricule);
                  rt.setClient(cin);
                  Trs.add(rt);
                 
                  
	               
	            }
	        } catch (SQLException e) {
	        } 
	        
	  
	  
	        
	        return Trs;
	    }

	  
	  
	  
	  public boolean recuperAdmin(Admin_lg admin){
		  boolean status =false;
		  
			  
		  loadDatabase();
		  try {
			  
			 
			 //create statement  using connexion object
			  PreparedStatement preparedStatement=connexion.prepareStatement("select  * from admin where username=? and password=? ");
			  preparedStatement.setString(1, admin.getUsername());
			  preparedStatement.setString(2, admin.getPassword());
			  
			 
			
			 // System.out.println(preparedStatement);
			
			  ResultSet rs=preparedStatement.executeQuery();
			  
			    status=rs.next();
				  
			
			 
			 
			  
		  }
		  catch(SQLException e) {
			    
			  e.printStackTrace();
			  }
		  
		  
		 return status;
		  
		  
		  
		  
		  }
	  //insert camion ///
	  public  void ajoutCamion(Truck tr) {
		  loadDatabase();
		  try {
			PreparedStatement preparedStatement=connexion.prepareStatement("INSERT INTO camion(matricule,marque,prix) values(?,?,?);");
			preparedStatement.setString(1, tr.getMatricule());
			preparedStatement.setString(2, tr.getMarque());
			preparedStatement.setDouble(3,tr.getPrix());
		
		
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	    

}
