package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import DAO.DAOCasesPlateau;
import DAO.DAOCompte;
import DAO.DAOPersonnage;
import DAO.DAOPlateau;
import model.Joueur;
import model.Partie;
import model.Personnage;
import plateau.CasesPlateau;
import plateau.Plateau;

public class MyGame {


	static DAOPersonnage daoPersonnage = new DAOPersonnage();
	static DAOPlateau daoPlateau= new DAOPlateau();
	static DAOCasesPlateau daoCasesPlateau= new DAOCasesPlateau();
	static Random r = new Random();

	public static String saisieString(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}






	public static void jouer() 
	{

		//Liste des joueurs:



		List <Joueur> listeDesJoueurs = new ArrayList <Joueur> ();

		Joueur IA1 = new Joueur ("Piere");
		Joueur IA2 = new Joueur ("Paul");
		Joueur IA3 = new Joueur ("Jacques");

		listeDesJoueurs.add((Joueur)Test.connected);
		listeDesJoueurs.add(IA1);
		listeDesJoueurs.add(IA2);
		listeDesJoueurs.add(IA3);



		System.out.println("Bienvenue! \nVoici la liste des Joueurs");
		System.out.println(listeDesJoueurs);



		try {
			System.out.println("Voici la liste des plateaux");
			System.out.println(daoPlateau.findAll());
			int idPlateau = saisieInt("Choisissez un plateau:");
			Plateau plateaudelaPartie = daoPlateau.findById(idPlateau);
			System.out.println("Vous avez choisi le plateau " +plateaudelaPartie);





			//liste de personnages dispo d'un joueur
			List <Personnage> listePersonnagesJoueur= listePersonnagesJoueur();

			//la liste des perso de chaque joueur après le choix
			List <Partie> listePersonnagesDeLaPartie= new ArrayList();

			System.out.println("Voici la liste des personnages disponibles");
			for (Personnage p: listePersonnagesJoueur) {
				System.out.println(p);
			}


			int positionCase = 0; //mettre case départ



			int idPersonnage = saisieInt("Quel personnage voulez vous choisir?");
			Personnage choixPerso=daoPersonnage.findById(idPersonnage);
			System.out.println("Vous avez choisi: "+choixPerso);



			//Ajouter le perso et sa position à la liste des parties du joueur
			Partie partieJoueur= new Partie(idPlateau,choixPerso,(Joueur)Test.connected,positionCase);
			List<Partie> partie=new ArrayList();
			partie.add(partieJoueur);
			((Joueur)Test.connected).setListePartie(partie);


			listePersonnagesDeLaPartie.add(partieJoueur);



			//Affiche la liste de tous les perso dispo pour IA:
			List <Personnage> listePersonnagesIA= daoPersonnage.findAll();
			listePersonnagesIA.remove(partieJoueur.getPersonnage().getId());
			System.out.println(listePersonnagesIA);

			//tirage aleatoire pour choix des perso IA
			for (int i=1;i<listeDesJoueurs.size();i++) {
				int nombreAleatoireIA = r.nextInt(listePersonnagesIA.size());
				Personnage personnageIA= listePersonnagesIA.get(nombreAleatoireIA);
				Partie partieIA= new Partie (idPlateau,personnageIA,listeDesJoueurs.get(i),positionCase);
				listePersonnagesDeLaPartie.add(partieIA);
				//				List<Partie> listePartieIA=new ArrayList();
				//				listePartieIA.add(partieIA);
				//				listeDesJoueurs.get(i).setListePartie(listePartieIA);

				System.out.println(listeDesJoueurs.get(i).getPseudo()+" joue avec "+personnageIA);

			}


			String lanceDeDe;
			String tourSuivant;
			List<CasesPlateau>listeOrdreCases= daoCasesPlateau.findAllByIdPlateau(idPlateau);
			System.out.println(daoCasesPlateau.findAllByIdPlateau(idPlateau));

			//---------------------------Jeu-----------------------------

			do {

				for (int i=0; i<listePersonnagesDeLaPartie.size(); i++) {
					System.out.println("\nJoueur "+listePersonnagesDeLaPartie.get(i).getPersonnage().getNom()+" à vous de jouer");

					// pour chaque joueur demander de faire le lancé de dés (plus tard on cliquera sur un bouton)
					do {
						if (i==1 || i==2 || i==3) {
							lanceDeDe="y";
							System.out.println("Voulez vous lancer les dés? (y/n)");
							System.out.println("y");
							break;
						} else {
							lanceDeDe= saisieString("Voulez vous lancer les dés? (y/n)");
						}

					} while (lanceDeDe.equalsIgnoreCase("n"));

					//		// génère "..."
					//		for(int j =0;j<3;j++) {
					//			System.out.println(".");
					//			Thread.sleep(1000);
					//		}


					//générer deux lancements de dés aléatoires
					int de1 = r.nextInt(6)+1;
					System.out.println("dé 1: "+de1);
					int de2 = r.nextInt(6)+1;
					System.out.println("dé 2: "+de2);


					//récupérer la position actuelle du personnage
					positionCase=listePersonnagesDeLaPartie.get(i).getPosition();
					positionCase+=calculSommeDe(de1, de2);
					//actualiser la nouvelle position du joueur
					listePersonnagesDeLaPartie.get(i).setPosition(positionCase);
					System.out.println("le personnage "+listePersonnagesDeLaPartie.get(i).getPersonnage().getNom()+" du joueur " +listePersonnagesDeLaPartie.get(i).getJ().getPseudo()+" est à la case "+listePersonnagesDeLaPartie.get(i).getPosition());




					if (positionCase>=listeOrdreCases.size()) {
						System.out.println("le joueur " +listePersonnagesDeLaPartie.get(i).getJ().getPseudo() +" gagné");
						break;
					}

					do {
						if (i==1 || i==2 || i==3) {
							tourSuivant="y";
							System.out.println("Fin de tour? (y/n) ");
							System.out.println("y");
							break;
						} else {
							tourSuivant = saisieString("Fin de tour? (y/n) ");
						}
					} while (tourSuivant.equalsIgnoreCase("n"));



				}


			} while (positionCase<listeOrdreCases.size());

		}
		catch (NullPointerException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}















	}



	//		menuJoueur();
	//		
	//		Case départ List<Plateau> id 0
	//		Pouvoir?
	//		Lancer dé random()
	//		déplacement de x sur la List<Plateau>
	//		effet en fonction de la Case
	//		fin de tour
	//		
	//		
	//		Base :
	//			
	//			Case = id nom 
	//			Plateau= id plateau 
	//			Case_plateau id p id Case ordre nb déplacement
	//			




	public static int calculSommeDe (int de1, int de2) {
		return de1+de2;
	}


	//affiche la liste des personnages d'un joueur
	public static List<Personnage> listePersonnagesJoueur () {
		List <Personnage> listePersonnages= new ArrayList();
		listePersonnages=daoPersonnage.findByJoueurId(Test.connected.getId());
		return listePersonnages;
	}





	public static void menuJoueur() {


	}
}
