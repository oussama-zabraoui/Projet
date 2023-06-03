package Model;
import java.sql.Date;
import java.time.LocalDate;
public class projet {
	private String nom_projet; 
	private String  part_name ;
	private int part_number; 
	private String drawing;
	private String  date_soumission;
	private String delai_projet;
	private String statu_PPAP;
	private String part_n;
	private client c;
	public projet() {
		
	}
	
	public projet(String nom_projet, String part_name, int part_number, String drawing, String date_soumission,
			String delai_projet, String statu_PPAP,String part_n) {
		super();
		this.nom_projet = nom_projet;
		this.part_name = part_name;
		this.part_number = part_number;
		this.drawing = drawing;
		this.date_soumission = date_soumission;
		this.delai_projet = delai_projet;
		this.statu_PPAP = statu_PPAP;
		this.part_n = part_n;
	}
	public String getNom_projet() {
		return nom_projet;
	}
	public void setNom_projet(String nom_projet) {
		this.nom_projet = nom_projet;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public int getPart_number() {
		return part_number;
	}
	public void setPart_number(int part_number) {
		this.part_number = part_number;
	}
	public String getDrawing() {
		return drawing;
	}
	public void setDrawing(String drawing) {
		this.drawing = drawing;
	}
	public String getDate_soumission() {
		return date_soumission;
	}
	public void setDate_soumission(String date) {
		this.date_soumission = date;
	}
	public String getDelai_projet() {
		return delai_projet;
	}
	public void setDelai_projet(String date) {
		this.delai_projet = date;
	}
	public String getStatu_PPAP() {
		return statu_PPAP;
	}
	public void setStatu_PPAP(String statu_PPAP) {
		this.statu_PPAP = statu_PPAP;
	}
	public String getPart_n() {
		return part_n;
	}
	public void setPart_n(String part_n) {
		this.part_n = part_n;
	}

	public client getC() {
		return this.c;
	}

	public void setC(client c) {
		this.c = c;
	}

	
	
	
	
	

	

       
}
