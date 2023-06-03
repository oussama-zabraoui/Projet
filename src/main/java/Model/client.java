package Model;

public class client {
	private String part_n; 
	private String  num_telephone ;
	private String prenom; 
	private String nom ;
	private String email ;
	
	public client()
	{
		
	}
	
	
	public client(String part_n, String num_telephone, String prenom, String nom, String email) {
		super();
		this.part_n = part_n;
		this.num_telephone = num_telephone;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}
	public String getPart_n() {
		return part_n;
	}
	public void setPart_n(String part_n) {
		this.part_n = part_n;
	}
	public String getNum_telephone() {
		return num_telephone;
	}
	public void setNum_telephone(String num_telephone) {
		this.num_telephone = num_telephone;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
