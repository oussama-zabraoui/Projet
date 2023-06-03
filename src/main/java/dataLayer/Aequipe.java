package dataLayer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import Model.equipe;
import Model.responsable;


public class Aequipe {
	public ArrayList<equipe> listequipes(){
		ArrayList<equipe> l=new ArrayList<equipe>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		int counter=0;
		try {
			PreparedStatement ps=con.prepareStatement("SELECT e.id_equipe,e.nom_equipe,e.matricule_responsable,r.nom_responsable  FROM equipe e, responsable r WHERE e.matricule_responsable=r.matricule_responsable");
			
			ResultSet re=ps.executeQuery();
			while(re.next()) {
				equipe e=new equipe();
				e.setNom_equipe(re.getString(2));
				e.setId_equipe(re.getInt(1));
				e.setId_responsable(re.getInt(3));
				responsable r=new responsable();
				r.setNom_responsable(re.getString(4));
				System.out.println(r.getNom_responsable());
			    e.setResponsable(r);
			    System.out.println("name"+e.getResponsable().getNom_responsable());
			    counter+=1;
			    
				l.add(e);
				System.out.println("nom in function"+l.get(0).getResponsable().getNom_responsable());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public int saveequipes(int id_equipe, String nom_equipe, int matricule_responsable) {
		int i=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO equipe(id_equipe,nom_equipe,matricule_responsable) values(?,?,?)");
			ps.setInt(1, id_equipe);
			ps.setString(2, nom_equipe);
			ps.setInt(3, matricule_responsable);
		
			
			
			i=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int modifierequipes(int id_equipe, String nom_equipe, int matricule_responsable) {
		int i=0;
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE equipe SET nom_equipe=?,matricule_responsable=? WHERE id_equipe=? ");
			ps.setInt(3, id_equipe);
			ps.setString(1, nom_equipe);
			ps.setInt(2, matricule_responsable);
		
			i=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	public ArrayList<Integer> getEquipes() {
		ArrayList<Integer> nomes=new ArrayList<Integer>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		int counter=0;
		try {
			
			PreparedStatement ps=con.prepareStatement("SELECT id_equipe FROM equipe");
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
