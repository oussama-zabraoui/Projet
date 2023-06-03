package dataLayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.*;
public class valider {
	private int id_valider; 
	private int  part_number ;
	private String message;
	
	public valider() {
		
	}
	
	
	public valider(int id_valider, int part_number, String message) {
		super();
		this.id_valider = id_valider;
		this.part_number = part_number;
		this.message = message;
	}
	public String getOo() {
		return message;
	}
	public void setOo(String message) {
		this.message = message;
	}
	public int getPart_number() {
		return part_number;
	}
	public void setPart_number(int part_number) {
		this.part_number = part_number;
	}
	public int getId_valider() {
		return id_valider;
	}
	public void setId_valider(int id_valider) {
		this.id_valider = id_valider;
	}
	

}
