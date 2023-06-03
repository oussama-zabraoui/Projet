package dataLayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import Model.ddocument;
import Model.equipe;	
public class Adocument {
	
	public ArrayList<ddocument> listdocuments(int part_number,String name_element){
		ArrayList<ddocument> l=new ArrayList<ddocument>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
		PreparedStatement ps=con.prepareStatement("SELECT name_document,dated,etat,remarque,fichier,nom,prenom FROM document WHERE part_number=? And name_element=?");
		ps.setInt(1, part_number);
		ps.setString(2, name_element);
		ResultSet re=ps.executeQuery();
		while(re.next()) {
		ddocument dd=new ddocument();
		dd.setName_document(re.getString(1));
		dd.setDated(re.getTimestamp(2));
		dd.setEtat_d(re.getString(3));
		dd.setRemarque(re.getString(4));
		dd.setF(re.getString(5));
		dd.setNom(re.getString(6));
		dd.setPrenom(re.getString(7));
		l.add(dd);
		
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public ArrayList<ddocument> listdocumentArchives(int part_number,String name_element,String name_document){
		ArrayList<ddocument> l=new ArrayList<ddocument>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
		PreparedStatement ps=con.prepareStatement("SELECT name_document,dated,etat,remarque,fichier,nom,prenom FROM document_archive WHERE part_number=? And name_element=? And name_document=?");
		ps.setInt(1, part_number);
		ps.setString(2, name_element);
		ps.setString(3, name_document);
		ResultSet re=ps.executeQuery();
		while(re.next()) {
		ddocument dd=new ddocument();
		dd.setName_document(re.getString(1));
		dd.setDated(re.getTimestamp(2));
		dd.setEtat_d(re.getString(3));
		dd.setRemarque(re.getString(4));
		dd.setF(re.getString(5));
		dd.setNom(re.getString(6));
		dd.setPrenom(re.getString(7));
		l.add(dd);
		
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	
	
	
	
	
	public int savedocuments (String name_element, int part_number, Timestamp  dated, String name_document, String etat, String remarque,
			String fichier,String nom,String prenom) {
		int i=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
		PreparedStatement ps = con.prepareStatement("INSERT INTO document(name_element, part_number,dated,name_document,etat,remarque,fichier,nom,prenom) VALUES (?,?,?,?,?,?,?,?,?)");
		ps.setString(1, name_element);
		ps.setInt(2, part_number);
		ps.setString(4, name_document);
		ps.setTimestamp(3,dated);
		ps.setString(5, etat);
		ps.setString(6, remarque);
		ps.setString(7, fichier);
		ps.setString(8,nom);
		ps.setString(9,prenom);
		i = ps.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
	
	
	}
	public int savedocumentsarchives (String name_element, int part_number, Timestamp  dated, String name_document, String etat, String remarque,
			String fichier,String nom,String prenom) {
		int i=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
		PreparedStatement ps = con.prepareStatement("INSERT INTO document_archive(name_element, part_number,dated,name_document,etat,remarque,fichier,nom,prenom) VALUES (?,?,?,?,?,?,?,?,?)");
		ps.setString(1, name_element);
		ps.setInt(2, part_number);
		ps.setString(4, name_document);
		ps.setTimestamp(3,dated);
		ps.setString(5, etat);
		ps.setString(6, remarque);
		ps.setString(7, fichier);
		ps.setString(8,nom);
		ps.setString(9,prenom);
		i = ps.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
	
	
	}
	
	
	public int updatedocuments(String name_element, int part_number, Timestamp  dated, String name_document, String etat, String remarque,
			String fichier,String nom,String prenom) {
		int i=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
		PreparedStatement ps = con.prepareStatement("UPDATE document SET dated=?,etat=?,remarque=?,fichier=?,nom=?,prenom=? WHERE name_element=? AND name_document=? AND part_number=?");
		ps.setString(7, name_element);
		ps.setInt(9, part_number);
		ps.setString(8, name_document);
		ps.setTimestamp(1,dated);
		ps.setString(2, etat);
		ps.setString(3, remarque);
		ps.setString(4, fichier);
		ps.setString(5,nom);
		ps.setString(6,prenom);
		i = ps.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
	}
	
	
	
	

	
	

}
