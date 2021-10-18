package joueur;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import app.MyGame;
import app.Test;
import model.Admin;
import model.Compte;
import model.Joueur;
import model.PersoObtenu;
import model.Personnage;
import util.Context;

public class MenuJoueur {
	
	
	static Compte connected=null;
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
	

	public static void menuJoueur() {
		System.out.println("Menu Joueur");
		System.out.println("1- Jouer une partie");
		System.out.println("2- Boutique");
		System.out.println("3- Gérer son profil");
		System.out.println("4- Deconnexion");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : MyGame.jouer();break;
		case 2 : menuBoutiqueJoueur();break;
		case 3 : gestionProfilJoueur(); break;
		case 4 : Test.menuConnexion(); break;
		}
		menuJoueur();

	}

	//----Gestion De Profil Joueur-----------
	public static void gestionProfilJoueur() {
		System.out.println("Menu Joueur/ Gestion de Profil");
		System.out.println("1- Modifier les informations du profil");
		System.out.println("2- Historique des parties");
		System.out.println("3- Retour au menu joueur");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : modifProfilJoueur();break;
		case 2 : historiqueParties();break;
		case 3 : menuJoueur(); break;
		}
		gestionProfilJoueur();

	}

	private static void historiqueParties() {
		// TODO Auto-generated method stub

	}

	public static void modifProfilJoueur() {
		System.out.println("Menu Joueur ou Admin/ Gestion de Profil/Modifications Profil");
		System.out.println("1- Modifier le pseudo");
		System.out.println("2- Modifier l'adresse e-mail");
		System.out.println("3- Modifier le login");
		System.out.println("4- Modifier le mot de passe");
		System.out.println("5- Retour au menu gestion de profil");
		System.out.println("6- Retour au menu Joueur");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : modifPseudo();break;
		case 2 : Test.modifEMail();break;
		case 3 : Test.modifLogin();break;
		case 4 : Test.modifPassword();break;
		case 5 : gestionProfilJoueur(); break;
		case 6 : menuJoueur(); break;
		}
		modifProfilJoueur();
	}


	

	



	public static void modifPseudo() {
		System.out.println("Menu Joueur/ Gestion de Profil/Modifications Profil/Modifier Pseudo");

		boolean confirmationPseudo = false;
		while (!confirmationPseudo) {
			System.out.println("Voici votre pseudo actuel: " +(((Joueur) connected).getPseudo()));
			String nouveauPseudo = saisieString("Veuillez saisir votre nouveau pseudo");
			String confirmationSaisie= saisieString("Vous avez saisi: "+nouveauPseudo+". Voulez-vous confirmer votre saisie? (y/n)");
			if (confirmationSaisie.equalsIgnoreCase("y")) {
				confirmationPseudo=true;
				((Joueur) connected).setPseudo(nouveauPseudo);
				Context.getInstance().getDaoJoueur().save((Joueur) connected);
			}
			else {
				confirmationPseudo=false;
			}
		}
		System.out.println("Votre nouveau pseudo "+((Joueur)connected).getPseudo() + " a bien été enregistré");
		modifProfilJoueur();	

	}


	public static void menuBoutiqueJoueur() {
		System.out.println("Joueur/ Menu Boutique");
		System.out.println("1- Acheter des étoiles");
		System.out.println("2- Acheter des personnages");
		System.out.println("3- Retour menu Joueur");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : achatEtoiles();break;
		case 2 : achatPerso();break;
		case 3 : menuJoueur(); break;
		}
		menuBoutiqueJoueur();

	}



	public static void achatPerso() {

		List<PersoObtenu> persos= Context.getInstance().getDaoJoueur().listePersonnagesJoueur(((Joueur)connected).getId());
		List<Personnage> listeTotalePerso=Context.getInstance().getDaoPersonnage().findAll();
		System.out.println("Voici la liste de vos personnages:");
		for (PersoObtenu persoObtenu : persos) {
			System.out.println(persoObtenu.getPerso());
			listeTotalePerso.remove(persoObtenu.getPerso());
		}


		System.out.println("Voici la liste des personnages que vous pouvez acheter:");
		System.out.println(listeTotalePerso);


		int choixAchatPerso = saisieInt("Quel personnage voulez vous acheter? (saisir 0 ou n°Id)");


		if (choixAchatPerso==0) {
			menuBoutiqueJoueur(); 
		}
		else 
		{
			System.out.println("L'achat du personnage"+ Context.getInstance().getDaoPersonnage().findById(choixAchatPerso).getNom() +"coûte "+ Context.getInstance().getDaoPersonnage().findById(choixAchatPerso).getPrixAchatPerso()+" Etoiles");
			System.out.println("Votre solde est de "+((Joueur) connected).getNbEtoiles()+" Etoiles");
			String confirmationChoixPerso= saisieString("Vous souhaitez acheter le personnage "+Context.getInstance().getDaoPersonnage().findById(choixAchatPerso)+" . Etes vous sur? (y/n)");
			if (confirmationChoixPerso.equalsIgnoreCase("y")) {
				if (((Joueur) connected).getNbEtoiles()>= Context.getInstance().getDaoPersonnage().findById(choixAchatPerso).getPrixAchatPerso()) {
					int nbEtoilesJoueur=(((Joueur) connected).getNbEtoiles())-(Context.getInstance().getDaoPersonnage().findById(choixAchatPerso).getPrixAchatPerso());
					((Joueur) connected).setNbEtoiles(nbEtoilesJoueur);


					PersoObtenu po = new PersoObtenu(Context.getInstance().getDaoPersonnage().findById(choixAchatPerso),(Joueur)connected);
					Context.getInstance().getDaoPersoObtenu().save(po);



					((Joueur) connected).getPersos().add(po);
					System.out.println("Bravo, vous venez d'acquerir un nouveau personnage");
					System.out.println("Voici la liste de vos personnages");
					System.out.println(((Joueur) connected).getPersos());

					for(PersoObtenu perso : ((Joueur) connected).getPersos()){
						System.out.println(perso.getPerso().getNom());
					}

					Context.getInstance().getDaoJoueur().save((Joueur) connected);
				}
				else {
					System.out.println("Votre solde est insuffisant, l'achat du personnage est annulé");
				}

			}
			else {
				System.out.println("Que souhaitez vous faire?");
				System.out.println("1- Acheter un autre personnage");
				System.out.println("2- Retour au menu Boutique");

				int choix = saisieInt("Choisir un menu :");
				switch(choix) 
				{
				case 1 : achatPerso();break;
				case 2 : menuBoutiqueJoueur();break;
				}
			}
		}

		menuBoutiqueJoueur();	

	}

	public static void achatEtoiles() {
		System.out.println("Votre solde actuel est de "+((Joueur) connected).getNbEtoiles()+" Etoiles");
		int achatEtoiles= saisieInt("Combien d'etoiles voulez vous acheter?");
		// faire tout le systeme pour se connecter avec un compte bancaire

		String confirmationAchatEtoiles= saisieString("Vous souhaitez acheter "+achatEtoiles +" Etoiles. Etes vous sur? (y/n)");
		if (confirmationAchatEtoiles.equalsIgnoreCase("y")) {
			int nbEtoilesJoueur=(((Joueur) connected).getNbEtoiles())+achatEtoiles;
			((Joueur) connected).setNbEtoiles(nbEtoilesJoueur);
			Context.getInstance().getDaoJoueur().save((Joueur) connected);
			System.out.println("Bravo! vous avez maintenant "+((Joueur) connected).getNbEtoiles()+" Etoiles");
		}
		else {
			System.out.println("l'achat est annulé");
		}

		menuBoutiqueJoueur();	

	}
}
