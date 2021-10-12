package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Historique  {
	private LocalDateTime dateHeurePartie;
	private LocalTime tempsPartie;
	private int positionArrivee;
	private int nbEtoilesGagnees;
	private Partie partie;
	
	
	
	

	public Historique(LocalDateTime dateHeurePartie, LocalTime tempsPartie, int positionArrivee, int nbEtoilesGagnees,
			Partie partie) {
		super();
		this.dateHeurePartie = dateHeurePartie;
		this.tempsPartie = tempsPartie;
		this.positionArrivee = positionArrivee;
		this.nbEtoilesGagnees = nbEtoilesGagnees;
		this.partie = partie;
	}
	
	
	
	
	
	public Historique() {
		super();
	}





	public LocalDateTime getDateHeurePartie() {
		return dateHeurePartie;
	}
	public void setDateHeurePartie(LocalDateTime dateHeurePartie) {
		this.dateHeurePartie = dateHeurePartie;
	}
	public LocalTime getTempsPartie() {
		return tempsPartie;
	}
	public void setTempsPartie(LocalTime tempsPartie) {
		this.tempsPartie = tempsPartie;
	}
	public int getPositionArrivee() {
		return positionArrivee;
	}
	public void setPositionArrivee(int positionArrivee) {
		this.positionArrivee = positionArrivee;
	}
	public int getNbEtoilesGagnees() {
		return nbEtoilesGagnees;
	}
	public void setNbEtoilesGagnees(int nbEtoilesGagnees) {
		this.nbEtoilesGagnees = nbEtoilesGagnees;
	}





	public Partie getPartie() {
		return partie;
	}





	public void setPartie(Partie partie) {
		this.partie = partie;
	}





	@Override
	public String toString() {
		return "Historique [dateHeurePartie=" + dateHeurePartie + ", tempsPartie=" + tempsPartie + ", positionArrivee="
				+ positionArrivee + ", nbEtoilesGagnees=" + nbEtoilesGagnees + ", partie=" + partie + "]";
	}
	
	

	
	
	

	
	
	
	
	
	
	
	

}
