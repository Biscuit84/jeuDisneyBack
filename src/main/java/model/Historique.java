package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Historique  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDateTime dateHeurePartie;
	
	private LocalTime tempsPartie;
	
	private int positionArrivee;
	
	private int nbEtoilesGagnees;
	
	
	
	@OneToMany
	private List <Partie> parties;
	
	
	
	

	
	
	
	
	public Historique(LocalDateTime dateHeurePartie, LocalTime tempsPartie, int positionArrivee, int nbEtoilesGagnees) {
		
		this.dateHeurePartie = dateHeurePartie;
		this.tempsPartie = tempsPartie;
		this.positionArrivee = positionArrivee;
		this.nbEtoilesGagnees = nbEtoilesGagnees;
	}





	public Historique() {
		
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





	


	@Override
	public String toString() {
		return "Historique [dateHeurePartie=" + dateHeurePartie + ", tempsPartie=" + tempsPartie + ", positionArrivee="
				+ positionArrivee + ", nbEtoilesGagnees=" + nbEtoilesGagnees +  "]";
	}





	public List<Partie> getParties() {
		return parties;
	}





	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}





	public int getId() {
		return id;
	}
	
	

	
	
	

	
	
	
	
	
	
	
	

}
