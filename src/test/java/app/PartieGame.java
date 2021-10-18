package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Compte;
import model.Joueur;
import model.PersoObtenu;
import model.Personnage;
import plateau.Plateau;
import util.Context;

public class PartieGame {


	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}


	public static List <Joueur> joueurPartie() {


		// deplacer la liste des IA sur context util
		List <Joueur> listeDesJoueurs = new ArrayList <Joueur> ();
		Joueur IA1 = new Joueur ("Piere");
		Joueur IA2 = new Joueur ("Paul");
		Joueur IA3 = new Joueur ("Jacques");


		Compte joueur=Context.getInstance().getConnected();

		listeDesJoueurs.add(IA1);
		listeDesJoueurs.add(IA2);
		listeDesJoueurs.add(IA3);
		listeDesJoueurs.add((model.Joueur) joueur);

		System.out.println("Bienvenue! \nVoici la liste des Joueurs");
		System.out.println(listeDesJoueurs);

		return listeDesJoueurs;


	}

	public static void plateauPersoChoix ()
	{

		//Choix du plateau
		System.out.println("Voici la liste des plateaux");
		System.out.println(Context.getInstance().getDaoPlateau().findAll());
		int idPlateau = saisieInt("Choisissez un plateau:");
		Plateau plateaudelaPartie =Context.getInstance().getDaoPlateau().findById(idPlateau);
		System.out.println("Vous avez choisi le plateau " +plateaudelaPartie.getNom());

		
		System.out.println("Voici la liste de vos personnages :");
		
		
		List<PersoObtenu> listePersoJoueur=Context.getInstance().getDaoJoueur().listePersonnagesJoueur(Context.getInstance().getConnected().getId());

		for(PersoObtenu p : listePersoJoueur) 
		{
			System.out.println(p.getPerso().getNom());
		}
		Context.getInstance().closeEmf();

		int idPersonnage = saisieInt("Quel personnage voulez vous choisir?");
		Personnage choixPerso=Context.getInstance().getDaoPersonnage().findById(idPersonnage);
		System.out.println("Vous avez choisi: "+choixPerso);
		
		



	}




	public static void main(String[] args) {


	}

}
