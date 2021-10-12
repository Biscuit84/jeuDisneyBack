package model;

import java.time.LocalDateTime;
import java.util.List;

public class Partie {

	private int idPlateau;
	private Personnage personnage;
	private Joueur j;
	private int position;
	
	

	public Partie(int idPlateau, Personnage personnage, Joueur j, int position) {
		this.idPlateau = idPlateau;
		this.personnage = personnage;
		this.j = j;
		this.position = position;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getIdPlateau() {
		return idPlateau;
	}

	public void setIdPlateau(int idPlateau) {
		this.idPlateau = idPlateau;
	}

	public Joueur getJ() {
		return j;
	}

	public void setJ(Joueur j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "Partie [idPlateau=" + idPlateau + ", personnage=" + personnage + ", j=" + j + ", position=" + position
				+ "]";
	}
	
	
	
	
	
	
	
	
	
}
