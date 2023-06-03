package dataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.client;

public class Gclient {
		public  ArrayList<client> listclients() {
			ArrayList<client> l=new ArrayList<client>();
			ConnectionDB c=new ConnectionDB();
			Connection con =c.getConnection();
			int counter=0;
			try {
				PreparedStatement ps=con.prepareStatement("SELECT * FROM client");
				
				ResultSet re=ps.executeQuery();
				while(re.next()) {
					client c1=new client();
					c1.setPart_n(re.getString(1));
					c1.setNum_telephone(re.getString(2));
					c1.setPrenom(re.getString(3));
					c1.setNom(re.getString(4));
					c1.setEmail(re.getString(5));
					counter+=1;
					System.out.println(c);
					l.add(c1);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return l;
		}
		public ArrayList<String> getClients() {
			ArrayList<String> nomes=new ArrayList<String>();
			ConnectionDB c=new ConnectionDB();
			Connection con =c.getConnection();
			int counter=0;
			try {
				PreparedStatement ps=con.prepareStatement("SELECT part_n FROM client");
				ResultSet re=ps.executeQuery();
				while(re.next()) {
					
					
					nomes.add(re.getString(1));
				}
				
				}catch(SQLException e) {
					e.printStackTrace();
				}
			
			return nomes;
		}
		
}



