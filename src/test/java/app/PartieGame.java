package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.Case;

import DAO.DAOCases;
import IDAO.IDAOCases;
import model.Compte;
import model.Joueur;
import model.Partie;
import model.PersoObtenu;
import model.Personnage;

import plateau.CasesPlateau;
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
	static List<CasesPlateau> listeOrdreCases;

	static int[] positionCase;


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

	public static void positionJoueur(int[] positionCase, List<CasesPlateau> listeOrdreCases)
	{
		System.out.println("Position des joueurs : ");
		for(int i=0; i<listeDesJoueurs.size(); i++)
		{ 
			if (positionCase[i]>=listeOrdreCases.size()) {
				System.out.println(listeDesJoueurs.get(i).getPseudo()+" est arrivé");
			}
			else {
				System.out.println(listeDesJoueurs.get(i).getPseudo() + " est sur la case " + positionCase[i] + ". C'est une case " + listeOrdreCases.get(positionCase[i]).getUneCase().getNom() +".");
			}

		}

	}



	public static int[] tourJeu (int[] posistionCase)
	{

		//String lanceDeDe;
		//String tourSuivant;

		positionCase[0]++; //test
		return positionCase;
	}
	public static void jouerUnePartie() {
		listeDesJoueurs=joueurPartie();
		plateaudelaPartie=plateauChoix();
		choixPerso=persoChoix();
		IAChoixPersonnages=persoIA();
		List <Personnage >listePersoPartie = new ArrayList();
		listePersoPartie.add(choixPerso); 
		listePersoPartie.addAll(IAChoixPersonnages);
		System.out.println(listePersoPartie);

		Partie partieEssai = new Partie (plateaudelaPartie); //creation de la partie
		//Context.getInstance().getDaoPartie().save(partieEssai); // on save la création de la partie
		partieEssai.setPersonnages(listePersoPartie); //on dit que ces persos sont dans cette partie
		//System.out.println(partieEssai.getPersonnages()); //verif

		List<CasesPlateau>listeOrdreCases=Context.getInstance().getDaoPlateau().listeCasesPlateau(plateaudelaPartie.getId()); // on charge les cases du plateau		
		System.out.println(listeOrdreCases);



		// initialisation position des personnages : 
		int [] positionCase = {0,0,0,0}; //mettre case depart
		//System.out.println(positionCase);
		positionJoueur(positionCase, listeOrdreCases);

		//lancement de la partie
		System.out.println("c'est parti !");
		String lanceDeDe;
		String tourSuivant;
		int nb=plateaudelaPartie.getNbCases()-1;
		do
		{


			for (int i=0; i<listePersoPartie.size(); i++) {
				System.out.println("\nJoueur "+listeDesJoueurs.get(i).getPseudo() +" A vous de jouer");
				// pour chaque joueur demander de faire le lance de des (plus tard on cliquera sur un bouton)
				do {
					if (i==0 || i==1 || i==2) {
						//lanceDeDe="y";
						//System.out.println("Voulez vous lancer les des? (y/n)");
						//System.out.println("y");
						System.out.println(listeDesJoueurs.get(i).getPseudo() +" lance les des.");
						break;
					} else {
						lanceDeDe= saisieString("Voulez vous lancer les des? (y/n)");
					}

				} while (lanceDeDe.equalsIgnoreCase("n"));

				//generer deux lancements de des aleatoires
				int de1 = r.nextInt(6)+1;
				System.out.println("de 1: "+de1);
				int de2 = r.nextInt(6)+1;
				System.out.println("de 2: "+de2);

				//int sommeDes = de1+de2;
				int sommeDes = de1;
				System.out.println("Vous avancez de "+ sommeDes +" cases.");

				positionCase[i]=positionCase[i]+sommeDes;



				// si tu as depasse la case arrivee
				if (positionCase[i]>=nb) {
					System.out.println("le joueur " +listeDesJoueurs.get(i).getPseudo() +" gagne !");
					break;
				}
				else {
					System.out.println("Vous êtes sur la case "+ positionCase[i] + ". C'est une case " + listeOrdreCases.get(positionCase[i]).getUneCase().getNom() +".");
				}



				do {
					if (i==0 || i==1 || i==2) {
						//tourSuivant="y";
						//System.out.println("Fin de tour? (y/n) ");
						//System.out.println("y");
						System.out.println(listeDesJoueurs.get(i).getPseudo() +" a fini son tour.");
						break;
					} else {
						tourSuivant = saisieString("Fin de tour? (y/n) ");
					}
				} while (tourSuivant.equalsIgnoreCase("n"));


			} //fin du tour 
			System.out.println("-------------------------------------------------");
			positionJoueur(positionCase, listeOrdreCases);



		}  while (positionCase[0]<nb && positionCase[1]<nb  && positionCase[2]<nb && positionCase[3]<nb);


		System.out.println("fini"); //test




		//Context.getInstance().getDaoPartie().save(partieEssai); // on save la création de la partie
		Context.getInstance().closeEmf();
	}






public static void main(String[] args) {


	// a effacer
	String login = saisieString("Saisir votre login");
	String password = saisieString("Saisir votre password");
	connected=Context.getInstance().getDaoCompte().connect(login, password);
	Context.getInstance().setConnected(connected);

}
}	


