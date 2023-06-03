package Model;

public class admin {
	private int id_admin;
    private String login;
    private String mot_de_passe;
    
	public admin() {
		
	}


	public admin(int id_admin, String login, String mot_de_passe) {
		super();
		this.id_admin = id_admin;
		this.login = login;
		this.mot_de_passe = mot_de_passe;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	


	public int getId_admin() {
		return id_admin;
	}


	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

}
