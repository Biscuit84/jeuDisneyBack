package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Personnage  {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	private String prince;
	
	private String mechant;
	
	private String pouvoir;
	
//	private int position;
	
	public Personnage(int id, String nom, String prince, String mechant, String pouvoir) {
		
		this.id = id;
		this.nom = nom;
		this.prince = prince;
		this.mechant = mechant;
		this.pouvoir = pouvoir;
	}
	
	
	public Personnage() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrince() {
		return prince;
	}


	public void setPrince(String prince) {
		this.prince = prince;
	}


	public String getMechant() {
		return mechant;
	}


	public void setMechant(String mechant) {
		this.mechant = mechant;
	}


	public String getPouvoir() {
		return pouvoir;
	}


	public void setPouvoir(String pouvoir) {
		this.pouvoir = pouvoir;
	}


	@Override
	public String toString() {
		return "Personnage [id=" + id + ", nom=" + nom + ", prince=" + prince + ", mechant=" + mechant + ", pouvoir="
				+ pouvoir + "]";
	}

	
	




//	public int getPosition() {
//		return position;
//	}
//
//	public void setPosition(int position) {
//		this.position = position;
//	}
	
	
	
	
	

}
