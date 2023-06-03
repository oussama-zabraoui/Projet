package Model;


import java.util.Date;

public class element {
	private String  name_element ;
	private String date_debut;
	private String date_fin;
	private String statu_element; 
	private int part_number;
	private int id_equipe;
	private equipe p;
	private responsable r;
	public element() {
		
	}
	
	
	
	public element( String name_element, String date_debut, String date_fin, String statu_element,
			int part_number,int id_equipe) {
		super();
		
		this.name_element = name_element;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.statu_element = statu_element;
		this.part_number = part_number;
		this.id_equipe=id_equipe;
	}
	
	public String getName_element() {
		return name_element;
	}
	public void setName_element(String name_element) {
		this.name_element = name_element;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public int getPart_number() {
		return part_number;
	}
	public void setPart_number(int part_number) {
		this.part_number = part_number;
	}
	public String getStatu_element() {
		return statu_element;
	}
	public void setStatu_element(String statu_element) {
		this.statu_element = statu_element;
	}



	public int getId_equipe() {
		return id_equipe;
	}



	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}



	public equipe getP() {
		return p;
	}

	public void setP(equipe p) {
		this.p = p;
	}




	public responsable getR() {
		return r;
	}



	public void setR(responsable r) {
		this.r = r;
	}
	
	public String getNomequipe() {
		return p.getNom_equipe();
	}
	
	public void setNomequipe(String nom_equipe) {
		p.setNom_equipe(nom_equipe);
	}
	public String getNomresponsable() {
		return r.getNom_responsable();
	}
	public void setNomresponsable(String nom_responsable) {
		r.setNom_responsable(nom_responsable);;
	}
	public int getMatriculeresponble() {
		return r.getMatricule_responble();
	}
	public void setMatriculeresponble(int matricule_responble) {
		r.setMatricule_responble(matricule_responble);;
	} 
	



	



	


	
	
}

