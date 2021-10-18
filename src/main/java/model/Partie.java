package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import plateau.Plateau;



@Entity
public class Partie {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Plateau plateau;
	
	
	@OneToMany
	private List<Personnage> personnages;
	
	
	
	@OneToMany
	private List<Joueur> joueursPartie;
	
	
	public Partie(Plateau plateau) {
		this.plateau = plateau;
		
		
	}



	public Partie(Plateau plateau, Personnage personnage) {
		super();
		this.plateau = plateau;
		
		
	}




	public Partie() {
		
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Plateau getPlateau() {
		return plateau;
	}




	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}



	public List<Personnage> getPersonnages() {
		return personnages;
	}




	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}




	public List<Joueur> getJoueursPartie() {
		return joueursPartie;
	}




	public void setJoueursPartie(List<Joueur> joueursPartie) {
		this.joueursPartie = joueursPartie;
	}




	@Override
	public String toString() {
		return "Partie [id=" + id + ", plateau=" + plateau +  "]";
	}




	
	
	
	
	
	
	
	
	
	
	
}
