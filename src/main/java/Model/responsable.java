package Model;

public class responsable {
	private String  nom_responsable ;
	private int matricule_responble;
	
	public responsable() {
		
	}
	
	public responsable(String nom_responsable,int matricule_responble) {
		super();
		this.nom_responsable = nom_responsable;
		this.matricule_responble = matricule_responble;
	}

	public String getNom_responsable() {
		return nom_responsable;
	}
	public void setNom_responsable(String nom_responsable) {
		this.nom_responsable = nom_responsable;
	}
	public int getMatricule_responble() {
		return matricule_responble;
	}
	public void setMatricule_responble(int matricule_responble) {
		this.matricule_responble = matricule_responble;
	} 
	
	

}
