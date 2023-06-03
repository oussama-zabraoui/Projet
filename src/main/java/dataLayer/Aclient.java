package dataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Model.client;	

public class Aclient {
	
	
	public int saveclients(String part_n, String num_telephone, String prenom, String nom, String email) {
		int i=0;
		
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
           PreparedStatement ps=con.prepareStatement("INSERT INTO client(part_n,num_telephone,prenom,nom,email) values(?,?,?,?,?)");
			
			ps.setString(1, part_n);
			ps.setString(2, num_telephone);
			ps.setString(3, prenom);
			ps.setString(4, nom);
			ps.setString(5, email);
			
			i=ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int enreclients(client c1) {
		
int i=0;
		
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
           PreparedStatement ps=con.prepareStatement("INSERT INTO client(part_n,num_telephone,prenom,nom,email) values(?,?,?,?,?)");
			
			ps.setString(1,c1.getPart_n());
			ps.setString(2, c1.getNum_telephone());
			ps.setString(3,c1.getPrenom());
			ps.setString(4, c1.getNom());
			ps.setString(5, c1.getEmail());
			
			i=ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	
	
}

	

