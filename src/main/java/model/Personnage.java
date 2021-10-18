package model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import plateau.CasesPlateau;

@Entity
public class Personnage  {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	private String prince;
	
	private String mechant;
	
	private String pouvoir;
	@ManyToOne
	private CasesPlateau position;

	private int prixAchatPerso;
	
	public Personnage(String nom, String prince, String mechant, String pouvoir) {
		this.nom = nom;
		this.prince = prince;
		this.mechant = mechant;
		this.pouvoir = pouvoir;
	}
	
	public Personnage(String nom, String prince, String mechant, String pouvoir, int prixAchatPerso) {
		this.nom = nom;
		this.prince = prince;
		this.mechant = mechant;
		this.pouvoir = pouvoir;
		this.prixAchatPerso=prixAchatPerso;
	}
	
	public Personnage() {
		
	}

	


	public CasesPlateau getPosition() {
		return position;
	}

	public void setPosition(CasesPlateau position) {
		this.position = position;
	}

	public int getPrixAchatPerso() {
		return prixAchatPerso;
	}

	public void setPrixAchatPerso(int prixAchatPerso) {
		this.prixAchatPerso = prixAchatPerso;
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

	
	//pour remove un objet
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personnage other = (Personnage) obj;
		return id == other.id;
	}




//	public int getPosition() {
//		return position;
//	}
//
//	public void setPosition(int position) {
//		this.position = position;
//	}
	
	
	
	
	

}
