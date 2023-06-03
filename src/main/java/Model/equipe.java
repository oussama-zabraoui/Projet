package Model;

public class equipe {
	private int id_equipe; 
	private String  nom_equipe ;
    private int id_responsable;
   
    private responsable responsable;
    
	
    public equipe()
    {
    	
    	responsable=new responsable();
    }
	
	public equipe(int id_equipe, String nom_equipe, int id_responsable) {
		super();
		this.id_equipe = id_equipe;
		this.nom_equipe = nom_equipe;
		this.id_responsable = id_responsable;
	}
	public String getNom_equipe() {
		return nom_equipe;
	}
	public void setNom_equipe(String nom_equipe) {
		this.nom_equipe = nom_equipe;
	}
	public int getId_equipe() {
		return id_equipe;
	}
	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}


	public int getId_responsable() {
		return id_responsable;
	}


	public void setId_responsable(int id_responsable) {
		this.id_responsable = id_responsable;
	}

	

	public responsable getResponsable() {
		
		return this.responsable;
	}

	public void setResponsable(responsable responsable) {
		this.responsable=responsable;
	}
	



	/*public responsable getR() {
		return r;
	}

	public void setR(responsable r) {
		this.r = r;
	}*/
	/*public void setRnom(String nom_res) {
		r.setNom_responsable(nom_res);
	}
	public String getRnom()
	{
		return r.getNom_responsable();
	}*/
	
	
}
