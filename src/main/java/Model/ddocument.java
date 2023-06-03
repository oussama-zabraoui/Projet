package Model;


import java.util.Date;

public class ddocument {
	private String name_element; 
	private Date dated;
	private String name_document;
	private String f;
	private String etat_d ;
	private String remarque;
	private int part_number;
	private String nom;
	private String prenom;
	public ddocument() {
		
	}
	
	public ddocument(String name_element,String name_document, Date dated,  String f, String etat_d,
			String remarque,int part_number,String nom,String prenom) {
		super();
		this.name_element=name_element;
		this.name_document = name_document;
		this.dated = dated;
		this.f = f;
		this.etat_d = etat_d;
		this.remarque = remarque;
		this.part_number=part_number;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public String getEtat_d() {
		return etat_d;
	}
	public void setEtat_d(String etat_d) {
		this.etat_d = etat_d;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public String getName_document() {
		return name_document;
	}
	public void setName_document(String name_document) {
		this.name_document = name_document;
	}
	
	
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}

	public int getPart_number() {
		return part_number;
	}

	public void setPart_number(int part_number) {
		this.part_number = part_number;
	}

	public String getName_element() {
		return name_element;
	}

	public void setName_element(String name_element) {
		this.name_element = name_element;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
