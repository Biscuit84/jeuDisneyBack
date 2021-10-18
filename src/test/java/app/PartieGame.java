package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import DAO.DAOCases;
import IDAO.IDAOCases;
import model.Compte;
import model.Joueur;
import model.Partie;
import model.PersoObtenu;
import model.Personnage;
import plateau.Plateau;
import util.Context;

public class PartieGame {

	static Random r = new Random();
	
	static Personnage choixPerso;
	static List<Personnage> IAChoixPersonnages;
	static List<Personnage> listePersoPartie;
	static List <Joueur> listeDesJoueurs; 
	static Compte connected;
	static Plateau plateaudelaPartie;
	
	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static String saisieString(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextLine();
	}


	public static List <Joueur> joueurPartie() {


		// deplacer la liste des IA sur context util
		List <Joueur> listeDesJoueurs = new ArrayList <Joueur> ();
		Joueur IA1 = new Joueur ("Mickey");
		Joueur IA2 = new Joueur ("Donald");
		Joueur IA3 = new Joueur ("Dingo");


		Compte joueur=Context.getInstance().getConnected();

		listeDesJoueurs.add(IA1);
		listeDesJoueurs.add(IA2);
		listeDesJoueurs.add(IA3);
		listeDesJoueurs.add((model.Joueur) joueur);

		System.out.println("Bienvenue! \nVoici la liste des Joueurs");
		System.out.println(listeDesJoueurs);

		
		
		return listeDesJoueurs;


	}

	public static Plateau plateauChoix ()
	{

		//Choix du plateau
		System.out.println("Voici la liste des plateaux");
		System.out.println(Context.getInstance().getDaoPlateau().findAll());
		int idPlateau = saisieInt("Choisissez un plateau:");
		Plateau plateaudelaPartie =Context.getInstance().getDaoPlateau().findById(idPlateau);
		System.out.println("Vous avez choisi le plateau " +plateaudelaPartie.getNom());
		
		
		return plateaudelaPartie;

	}

	public static Personnage persoChoix()
	{
		System.out.println("Voici la liste de vos personnages :");


		List<PersoObtenu> listePersoJoueur=Context.getInstance().getDaoJoueur().listePersonnagesJoueur(Context.getInstance().getConnected().getId());

		for(PersoObtenu p : listePersoJoueur) 
		{
			System.out.println(p.getPerso().getNom());
		}

		int idPersonnage = saisieInt("Quel personnage voulez vous choisir?");
		Personnage choixPerso=Context.getInstance().getDaoPersonnage().findById(idPersonnage);
		System.out.println("Vous avez choisi: "+choixPerso);

		return choixPerso;


	}
	
	public static List<Personnage> persoIA()
	{
		//Affiche la liste de tous les perso dispo pour IA:
		List <Personnage> listePersonnagesIA= Context.getInstance().getDaoPersonnage().findAll();
		listePersonnagesIA.remove(choixPerso);
		System.out.println(listePersonnagesIA);

		//tirage aleatoire pour choix des perso IA
		
		List <Personnage> IAChoixPersonnage = new ArrayList ();
		
		for (int i=0;i<=2;i++) {
			int nombreAleatoireIA = r.nextInt(listePersonnagesIA.size());
			Personnage personnageIA= listePersonnagesIA.get(nombreAleatoireIA);
			IAChoixPersonnage.add(personnageIA);
			System.out.println(listeDesJoueurs.get(i).getPseudo()+" joue avec "+personnageIA);
		}
		
		
		
		return IAChoixPersonnage;
		
	}
	

	public static void tourJeu ()
	{
		int positionCase = 0; //mettre case depart
		
		
		
	}
	


	public static void main(String[] args) {

		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		connected=Context.getInstance().getDaoCompte().connect(login, password);
		Context.getInstance().setConnected(connected);
		
		
		
		listeDesJoueurs=joueurPartie();
		plateaudelaPartie=plateauChoix();
		choixPerso=persoChoix();
		IAChoixPersonnages=persoIA();
		List <Personnage >listePersoPartie = new ArrayList();
		listePersoPartie.add(choixPerso);
		listePersoPartie.addAll(IAChoixPersonnages);
		System.out.println(listePersoPartie);
		
		Partie partieEssai = new Partie (plateaudelaPartie);
	
	    partieEssai.setPersonnages(listePersoPartie); 
	    
	    //System.out.println(partieEssai.getPersonnages());
	    
	    
	 
		
		
		
		
		
		
		
		
		Context.getInstance().closeEmf();
	}

}
