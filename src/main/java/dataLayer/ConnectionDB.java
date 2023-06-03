package dataLayer;
import java.sql.*;
public class ConnectionDB{

	
	Connection con ;
	String url,pilote;
	public ConnectionDB() {
	try {
	//Chargement de pilote
	pilote=new String("com.mysql.jdbc.Driver");
	Class.forName(pilote);
	// Definition de l'URL de connexion
	url = new String("jdbc:mysql://localhost/pppap");
	// Etablissement de la Connexion
	con=DriverManager.getConnection(url,"root","");


	System.out.println("CONNEXION ETABLIE");
	// Fermeture de la connexion
	
	} catch( ClassNotFoundException e) {
	System.err.println("Erreur lors du chargement du pilote : " + e); }
	catch (SQLException e) {
	System.err.println("Erreur de syntaxe SQL : " + e); 
	} 
	}
	public Connection getConnection() {
		return con;
	}
	
}