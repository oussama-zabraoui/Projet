package bussnissLayer;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Model.projet;
import Model.responsable;
import Model.uuser;
import Model.validdocp;
import dataLayer.*;
import Model.element;
import Model.equipe;
import Model.etat;
import Model.client;
import Model.ddocument;
public class Requestimpl implements Requestinterface {
	Aclient acl = new Aclient();
	Adocument ado = new Adocument();
	Aelement ael = new Aelement();
	Aequipe aeq = new Aequipe();
	Aprojet apr = new Aprojet();
	Aresponsable are = new Aresponsable();
	auser us = new auser();
	Gclient gcli = new Gclient();
	Gprojet gpro = new Gprojet();
	
	@Override
	public ArrayList<projet> listprojet() {
		
		return gpro.listprojets();
	}

	@Override
	public ArrayList<client> listclient() {
		return gcli.listclients();
	}

	
	

	

	@Override
	public ArrayList<equipe> listequipe() {
		return aeq.listequipes();
	}

	

	

	


	@Override
	public int saveclient(String part_n, String num_telephone, String prenom, String nom, String email) {
		// TODO Auto-generated method stub
		return acl.saveclients(part_n,num_telephone,prenom,nom,email);
	}

	

	


	@Override
	public int saveresponsable(String nom_responsable, int matricule_responble) {
		return are.saveresponsables(nom_responsable,matricule_responble);
	}

	@Override
	public int saveequipe(int id_equipe, String nom_equipe, int matricule_responble) {
		// TODO Auto-generated method stub
		return aeq.saveequipes(id_equipe, nom_equipe, matricule_responble);
	}

	@Override
	public ArrayList<responsable> listresponsable() {
		return are.listresponsables();
	}

	@Override
	public int saveProjet(String nom_projet, String part_name, int part_number, String drawing, String date_soumission,
			String delai_projet, String statu_PPAP, String part_n) throws Exception {
		return apr.saveProjets(nom_projet, part_name, part_number, drawing, date_soumission, delai_projet, statu_PPAP, part_n);
		}

	@Override
	public int updateProjet(String nom_projet, String part_name, int part_number, String drawing,
			String date_soumission, String delai_projet, String statu_PPAP, String part_n) throws Exception {
		// TODO Auto-generated method stub
		return apr.updateProjets(nom_projet, part_name, part_number, drawing, date_soumission, delai_projet, statu_PPAP, part_n);
	}

	@Override
	public int saveelement(String name_element, String date_debut, String date_fin, String statu_element,
			int part_number, int id_equipe) throws ParseException {
		// TODO Auto-generated method stub
		return ael.saveelements(name_element, date_debut, date_fin, statu_element, part_number, id_equipe);
	}

	@Override
	public ArrayList<element> loadelement(int part_number) {
		// TODO Auto-generated method stub
		return ael.loadelements(part_number);
	}

	@Override
	public int Updateelement(String name_element, String date_debut, String date_fin, String statu_element,
			int part_number, int id_equipe) throws ParseException {
		// TODO Auto-generated method stub
		return ael.Updateelements(name_element, date_debut, date_fin, statu_element, part_number, id_equipe);
	}

	@Override
	public ArrayList<ddocument> listdocument(int part_number, String name_element) {
		// TODO Auto-generated method stub
		return ado.listdocuments(part_number, name_element);
	}

	@Override
	public int savedocument(String name_element, int part_number, Timestamp dated, String name_document, String etat,
			String remarque, String fichier,String nom,String prenom) {
		// TODO Auto-generated method stub
		return ado.savedocuments(name_element, part_number, dated, name_document, etat, remarque, fichier,nom,prenom);
	}

	@Override
	public int updatedocument(String name_element, int part_number, Timestamp dated, String name_document, String etat,
			String remarque, String fichier,String nom,String prenom) {
		// TODO Auto-generated method stub
		return ado.updatedocuments(name_element, part_number, dated, name_document, etat, remarque, fichier,nom,prenom);
	}

	@Override
	public ArrayList<ddocument> listdocumentArchive(int part_number, String name_element, String name_document) {
		// TODO Auto-generated method stub
		return ado.listdocumentArchives(part_number, name_element, name_document);
	}

	

	@Override
	public int ajouteruser(String nom, String prenom, String email, String mot_de_passe, String role) {
		// TODO Auto-generated method stub
		return us.ajouterusers(nom, prenom, email, mot_de_passe, role);
	}

	@Override
	public int supprimerUser(String email) {
		// TODO Auto-generated method stub
		return us.supprimerUsers(email);
	}

	@Override
	public int editUser(String nom, String prenom, String email, String mot_de_passe, String role) {
		// TODO Auto-generated method stub
		return us.editUsers(nom, prenom, email, mot_de_passe, role);
	}

	@Override
	public ArrayList<uuser> listuser() {
		// TODO Auto-generated method stub
		return us.listusers();
	}

	@Override
	public int modifierequipe(int id_equipe, String nom_equipe, int matricule_responsable) {
		// TODO Auto-generated method stub
		return aeq.modifierequipes(id_equipe, nom_equipe, matricule_responsable);
	}

	@Override
	public int modifiersponsable(String nom_responsable, int matricule_responble) {
		return are.modifiersponsables(nom_responsable, matricule_responble);
	}

	@Override
	public int savedocumentsarchive(String name_element, int part_number, Timestamp dated, String name_document,
			String etat, String remarque, String fichier,String nom,String prenom) {
		// TODO Auto-generated method stub
		return ado.savedocumentsarchives(name_element, part_number, dated, name_document, etat, remarque, fichier,nom,prenom);
	}

	@Override
	public ArrayList<String> getClient() {
		// TODO Auto-generated method stub
		return gcli.getClients();
	}

	@Override
	public ArrayList<Integer> getResponsable() {
		// TODO Auto-generated method stub
		return are.getResponsables();
	}

	@Override
	public ArrayList<Integer> getEquipe() {
		// TODO Auto-generated method stub
		return aeq.getEquipes();
	}


}
