package dataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.element;
import Model.equipe;
import Model.responsable;
import Model.uuser;
public class auser {
	public int ajouterusers(String nom, String prenom, String email, String mot_de_passe, String role) {
		 int u=0;
			ConnectionDB c=new ConnectionDB();
			Connection con =c.getConnection();
			try {
		
				
			
			PreparedStatement ps=con.prepareStatement("INSERT INTO users(nom,prenom,email,mot_de_passe,role) values(?,?,?,?,?)");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3,email);
			ps.setString(4, mot_de_passe);
			ps.setString(5, role);
			u=ps.executeUpdate();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return u;
		  
	}
	public int supprimerUsers(String email) {
		int u=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM users WHERE email=?");
			ps.setString(1, email);
			u=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
	}
		return u;
	}
	public int editUsers(String nom, String prenom, String email, String mot_de_passe, String role) {
		 int u=0;
			ConnectionDB c=new ConnectionDB();
			Connection con =c.getConnection();
			try {
			PreparedStatement ps=con.prepareStatement("UPDATE users SET nom=?,prenom=?,mot_de_passe=?,role=? WHERE email=?");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(5,email);
			ps.setString(3, mot_de_passe);
			ps.setString(4, role);
			u=ps.executeUpdate();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return u;
		  
	}
	public ArrayList<uuser> listusers() 
	{
		ArrayList<uuser> us=new ArrayList<uuser>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		int counter=0;
		try {
			PreparedStatement ps=con.prepareStatement("SELECT nom,prenom,email,mot_de_passe,role FROM users");
			ResultSet re=ps.executeQuery();
			while(re.next()) {
				uuser u=new uuser();
				u.setNom(re.getString(1));
				u.setRole(null);;
				u.setPrenom(re.getString(2));
				u.setEmail(re.getString(3));
				u.setMot_de_passe(re.getString(4));
				u.setRole(re.getString(5));
	
				us.add(u);
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return us;
		
	}


}
