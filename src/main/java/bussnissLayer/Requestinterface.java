package bussnissLayer;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import Model.*;
import dataLayer.*;
public interface Requestinterface {
	
public  ArrayList<client> listclient()	;


public  ArrayList<projet> listprojet();


public int updateProjet(String nom_projet, String part_name, int part_number, String drawing,
		String date_soumission,String delai_projet, String statu_PPAP, String part_n)throws Exception ;	
public ArrayList<equipe> listequipe();
public int saveelement( String name_element, String date_debut, String date_fin, String statu_element,
		int part_number,int id_equipe) throws ParseException;
public ArrayList<element> loadelement(int part_number)  ;
int Updateelement( String name_element, String date_debut, String date_fin, String statu_element,
		int part_number,int id_equipe) throws ParseException ;
public ArrayList<ddocument> listdocument(int part_number,String name_element);
public int savedocument (String name_element, int part_number, Timestamp  dated, String name_document, String etat, String remarque,
		String fichier,String nom,String prenom);
public int savedocumentsarchive (String name_element, int part_number, Timestamp  dated, String name_document, String etat, String remarque,
		String fichier,String nom,String prenom);
public int updatedocument(String name_element, int part_number, Timestamp  dated, String name_document, String etat, String remarque,
		String fichier,String nom,String prenom);
public int saveclient(String part_n, String num_telephone, String prenom, String nom, String email);
public int saveProjet(String nom_projet, String part_name, int part_number, String drawing,
		String date_soumission,String delai_projet, String statu_PPAP, String part_n)throws Exception ;
public int saveresponsable(String nom_responsable,int matricule_responble);
public int saveequipe(int id_equipe, String nom_equipe, int matricule_responble);
public  ArrayList<responsable> listresponsable();
public ArrayList<ddocument> listdocumentArchive(int part_number,String name_element,String name_document);
public int ajouteruser(String nom, String prenom, String email, String mot_de_passe, String role);
public int supprimerUser(String email);
public int editUser(String nom, String prenom, String email, String mot_de_passe, String role);
public ArrayList<uuser> listuser();

public int modifierequipe(int id_equipe, String nom_equipe, int matricule_responsable);
public int modifiersponsable(String nom_responsable,int matricule_responble) ;
public ArrayList<String> getClient();
public ArrayList<Integer> getResponsable();
public ArrayList<Integer> getEquipe();
}
