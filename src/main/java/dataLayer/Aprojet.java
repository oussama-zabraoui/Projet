package dataLayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import Model.projet;	


public class Aprojet {
	
	

	
	public int updateProjets(String nom_projet, String part_name, int part_number, String drawing,
			String date_soumission,String delai_projet, String statu_PPAP, String part_n)throws Exception  {
		 int p=0;
			ConnectionDB c=new ConnectionDB();
			Connection con =c.getConnection();
			try {
		
				
			
			PreparedStatement ps=con.prepareStatement("UPDATE projet SET nom_projet=?,part_name=?,drawing=?,date_soumission=?,delai_projet=?,statu_PPAP=?  WHERE part_number=? And part_n=?");
			ps.setString(1, nom_projet);
			ps.setString(2, part_name);
			ps.setInt(7, part_number);
			ps.setString(3, drawing);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = dateFormat.parse(date_soumission);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(4, sqlDate);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date1 = dateFormat.parse(delai_projet);
			java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
			ps.setDate(5,sqlDate1);
			ps.setString(6, statu_PPAP);
			ps.setString(8, part_n);
			p=ps.executeUpdate();
				
				
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return p;
		
	}
	public int saveProjets(String nom_projet, String part_name, int part_number, String drawing,
			String date_soumission,String delai_projet, String statu_PPAP, String part_n)throws Exception {
		 int p=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
	
			
		
		PreparedStatement ps=con.prepareStatement("INSERT INTO projet(nom_projet,part_name,part_number,drawing,date_soumission,delai_projet,statu_PPAP,part_n) values(?,?,?,?,?,?,?,?)");
		ps.setString(1, nom_projet);
		ps.setString(2, part_name);
		ps.setInt(3, part_number);
		ps.setString(4, drawing);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = dateFormat.parse(date_soumission);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		ps.setDate(5, sqlDate);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = dateFormat.parse(delai_projet);
		java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
		ps.setDate(6,sqlDate1);
		ps.setString(7, statu_PPAP);
		ps.setString(8, part_n);
		p=ps.executeUpdate();
			
			
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	  
		
	}

	
	
	
}