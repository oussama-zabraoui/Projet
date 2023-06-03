package dataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.*;

public class Aresponsable {
	
	
	public int saveresponsables(String nom_responsable,int matricule_responble) {
		int i=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO responsable(nom_responsable,matricule_responsable) values(?,?)");
			ps.setString(1, nom_responsable);
			ps.setInt(2, matricule_responble);
			i= ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public int modifiersponsables(String nom_responsable,int matricule_responble) {
		int i=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE responsable SET nom_responsable=? WHERE matricule_responsable=?");
			ps.setString(1, nom_responsable);
			ps.setInt(2, matricule_responble);
			i= ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public  ArrayList<responsable> listresponsables() {
		ArrayList<responsable> l=new ArrayList<responsable>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT nom_responsable,matricule_responsable FROM responsable");
			
			ResultSet re=ps.executeQuery();
			while(re.next()) {
				responsable r=new responsable();
				r.setNom_responsable(re.getString(1));
				r.setMatricule_responble(re.getInt(2));
				l.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public ArrayList<Integer> getResponsables() {
		ArrayList<Integer> nomes=new ArrayList<Integer>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		int counter=0;
		try {
			
			PreparedStatement ps=con.prepareStatement("SELECT matricule_responsable FROM responsable");
			ResultSet re=ps.executeQuery();
			while(re.next()) {
				
				
				nomes.add(re.getInt(1));
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		return nomes;
	}
	

}
