package app;

import java.util.ArrayList;
import java.util.List;

import model.Joueur;

public class PartieGame {
	
	
	public static void Joueur() {
		
		List <Joueur> listeDesJoueurs = new ArrayList <Joueur> ();
		Joueur IA1 = new Joueur ("Piere");
		Joueur IA2 = new Joueur ("Paul");
		Joueur IA3 = new Joueur ("Jacques");
		listeDesJoueurs.add((Joueur)Test.connected); //connected du bon endroit
		listeDesJoueurs.add(IA1);
		listeDesJoueurs.add(IA2);
		listeDesJoueurs.add(IA3);
		
		
	}
	
	
	

	public static void main(String[] args) {
	

	}

}
