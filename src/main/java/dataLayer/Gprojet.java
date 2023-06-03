package dataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import Model.*;



public class Gprojet {
	public  ArrayList<projet> listprojets() {
		ArrayList<projet> l=new ArrayList<projet>();
		ConnectionDB c=new ConnectionDB();
		Connection con =c.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT p.nom_projet,p.part_name,p.part_number,p.drawing,p.date_soumission,p.delai_projet,p.statu_PPAP,p.part_n,c.nom,c.prenom  FROM projet p,client c WHERE p.part_n=c.part_n");
			
			ResultSet re=ps.executeQuery();
			while(re.next()) {
				projet p=new projet();
				p.setNom_projet(re.getString(1));
				p.setPart_name(re.getString(2));
				p.setPart_number(re.getInt(3));
				p.setDrawing(re.getString(4));
				p.setDate_soumission(re.getString(5));
				p.setDelai_projet(re.getString(6));
				p.setStatu_PPAP(re.getString(7));
				p.setPart_n(re.getString(8));
				client cl =new client();
				cl.setNom(re.getString(9));
				cl.setPrenom(re.getString(10));
				p.setC(cl);
				l.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
}
