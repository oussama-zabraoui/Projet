package dataLayer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import Model.element;
import Model.equipe;
import Model.responsable;
import bussnissLayer.ChartI;
public class Aelement implements ChartI {
	
	public int saveelements( String name_element, String date_debut, String date_fin, String statu_element,
			int part_number,int id_equipe) throws ParseException {
		int i=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO element(name_element,date_debut,date_fin,statu_element,part_number,id_equipe) values(?,?,?,?,?,?)");
			ps.setString(1, name_element);
			
			ps.setInt(6, id_equipe);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = dateFormat.parse(date_debut);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(2, sqlDate);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date1 = dateFormat.parse(date_fin);
			java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
			ps.setDate(3,sqlDate1);
			ps.setString(4, statu_element);
			ps.setInt(5, part_number);

			
			
			i=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	
	
	
	public ArrayList<element> loadelements(int part_number) 
	{
		ArrayList<element> l=new ArrayList<element>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		int counter=0;
		try {
			PreparedStatement ps=con.prepareStatement("SELECT name_element as 'name',e.date_debut as 'date de debut',e.date_fin as 'date du fin',e.statu_element as 'statu',e.part_number as 'numero de projet',e.id_equipe as 'equipe',eq.nom_equipe as 'nomequipe',r.nom_responsable as 'nomresp',r.matricule_responsable as 'matresp' FROM element e,responsable r,equipe eq WHERE part_number=? And e.id_equipe=eq.id_equipe And r.matricule_responsable=eq.matricule_responsable ORDER BY CAST(SUBSTRING_INDEX(name_element, '-', 1) AS UNSIGNED)");
			ps.setInt(1, part_number);
			ResultSet re=ps.executeQuery();
			while(re.next()) {
				element e=new element();
				e.setName_element(re.getString(1));
				e.setDate_debut(re.getString(2));
				e.setDate_fin(re.getString(3));
				e.setStatu_element(re.getString(4));
				e.setPart_number(re.getInt(5));
				e.setId_equipe(re.getInt(6)) ;
				
				equipe eq = new equipe();
				eq.setNom_equipe(re.getString(7));
				e.setP(eq);
				responsable resp = new responsable();
				resp.setNom_responsable(re.getString(8));
				resp.setMatricule_responble(re.getInt(9));
				counter+=1;
				System.out.println(c);
				e.setR(resp);
				l.add(e);
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return l;
		
	}
	public int Updateelements( String name_element, String date_debut, String date_fin, String statu_element,
			int part_number,int id_equipe) throws ParseException 
	{
		int i=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE element SET date_debut=?,date_fin=?,statu_element=?,id_equipe=? WHERE part_number=? And name_element=?");
			ps.setString(6, name_element);
			ps.setInt(4, id_equipe);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = dateFormat.parse(date_debut);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(1, sqlDate);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date1 = dateFormat.parse(date_fin);
			java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
			ps.setDate(2,sqlDate1);
			ps.setString(3, statu_element);
			ps.setInt(5, part_number);

			
			
			i=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}





	@Override
	public ArrayList<String> getNomes_Element(String part_number) {
		ArrayList<String> nomes=new ArrayList<String>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		int counter=0;
		try {
			PreparedStatement ps=con.prepareStatement("SELECT name_element FROM element WHERE part_number=? ORDER BY CAST(SUBSTRING_INDEX(name_element, '-', 1) AS UNSIGNED) ");
			ps.setString(1, part_number);
			ResultSet re=ps.executeQuery();
			while(re.next()) {
				
				
				nomes.add(re.getString(1));
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		return nomes;
	}





	@Override
	public ArrayList<String> getEtat_Element(String part_number) {
		ArrayList<String> nomes=new ArrayList<String>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		int counter=0;
		try {
			PreparedStatement ps=con.prepareStatement("SELECT statu_element FROM element WHERE part_number=? ORDER BY CAST(SUBSTRING_INDEX(name_element, '-', 1) AS UNSIGNED) ");
			ps.setString(1, part_number);
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
