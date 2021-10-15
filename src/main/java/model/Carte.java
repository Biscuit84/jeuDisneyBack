package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Carte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String nom;
	
	public Carte(String nom) {
		
		this.nom = nom;
	}

	public Carte() {
	
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

	
	@Override
	public String toString() {
		return "Carte [id=" + id + ", nom=" + nom + "]";
	}
	
	

	
	
	
}
