package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PersoObtenu {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Personnage perso;
	
	@ManyToOne
	private Joueur joueur;
	
	public PersoObtenu() {
		// TODO Auto-generated constructor stub
	}

	public PersoObtenu(Personnage perso, Joueur joueur) {
		
		this.perso = perso;
		this.joueur = joueur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Personnage getPerso() {
		return perso;
	}

	public void setPerso(Personnage perso) {
		this.perso = perso;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	@Override
	public String toString() {
		return "PersoObtenu [id=" + id + ", perso=" + perso + ", joueur=" + joueur + "]";
	}
	
	
	
}
