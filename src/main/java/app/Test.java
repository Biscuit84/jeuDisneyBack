package app;

import java.util.Random;
import java.util.Scanner;

import DAO.DAOCompte;
import model.Admin;
import model.Compte;
import model.Joueur;

public class Test {

	static DAOCompte daoCompte = new DAOCompte();
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

	public static void menuPrincipal() {

//		menu connection => admin ou joueur
//
//				menu admin
//				gestion compte joueur
//				(gestion partie) 
//				gestion plateau 
//				gestion cases
//				gestion carte
//				gestion personnage
//				gestion boutique
//
//
//				menu joueur
//				jouer une partie
//				profil
//				boutique
//				quitter

				//MyGame.jouer();
	}

	public static void jouerUnePartie() {








	}
	
	public static void menuConnexion() {

		System.out.println("Menu Connection");
		System.out.println("1- Créer un nouveau compte joueur");
		System.out.println("2- Se connecter à mon compte");
		System.out.println("3- Quitter l'application");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : creerNewCompteJoueur();break;
		case 2 : connec();break;
		case 3 : System.exit(0);
		}
		menuConnexion();
	}
	
	
	public static void creerNewCompteJoueur() {
		
		String nom = saisieString("Saisir votre nom");
		String prenom = saisieString("Saisir votre prenom");
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		String mail = saisieString("Saisir votre mail");
		String type = saisieString("Voulez vous créer un compte joueur ou admin? (admin/joueur)");
		switch (type) {
		case "admin" : System.out.println("veuillez nous contacter pour créer un compte admin"); break;
		case "joueur": 
			System.out.println("on est bientôt arrivé au bout");
			String pseudo = saisieString("Saisir un pseudo");
			Joueur j = new Joueur (login,password,nom,prenom,pseudo,mail);
			daoCompte.insert(j); 
			System.out.println("Bravo! vous venez de créer votre compte"); 
			System.out.println(j); 
			break;
		default: System.out.println("saisie incorrecte"); break;
		}
		
		menuConnexion();
		
		
	}

	public static void connec() {
		
		
				
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		connected=daoCompte.connectSecure(login, password);
		if(connected instanceof Admin) 
		{ 
			menuAdmin();
			
		}
		else if(connected instanceof Joueur) 
		{
			menuJoueur();
		}
		else 
		{
			System.out.println("Identifiants invalides");
			menuConnexion();
		}
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
		case 2 : menuBoutique();break;
		case 3 : gestionProfil(); break;
		case 4 : menuConnexion(); break;
		}
		menuJoueur();
		
	}

	public static void gestionProfil() {
		System.out.println("Menu Profil");
		System.out.println("1- Modifier les informations profil");
		System.out.println("2- Historique des parties");
		System.out.println("3- Deconnexion");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : modifProfil();break;
		case 2 : historiqueParties();break;
		case 3 : menuJoueur(); break;
		}
		gestionProfil();
		
	}

	private static void historiqueParties() {
		// TODO Auto-generated method stub
		
	}

	private static void modifProfil() {
		// TODO Auto-generated method stub
		
	}

	private static void menuBoutique() {
		System.out.println("Menu Boutique");
		System.out.println("1- Acheter des étoiles");
		System.out.println("2- Acheter des personnages");
		System.out.println("3- Acheter des skins");
		System.out.println("7- Deconnexion");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : achatEtoiles();break;
		case 2 : achatPerso();break;
		case 3 : achatSkins(); break;
		case 7 : menuBoutique(); break;
		}
		menuBoutique();
		
	}

	private static void achatSkins() {
		// TODO Auto-generated method stub
		
	}

	private static void achatPerso() {
		// TODO Auto-generated method stub
		
	}

	private static void achatEtoiles() {
		// TODO Auto-generated method stub
		
	}

	public static void menuAdmin() {
		System.out.println("Menu Admin");
		System.out.println("1- Créer un nouveau compte Admin");
		System.out.println("2- Gestion des plateaux");
		System.out.println("3- Gestion des cases");
		System.out.println("4- Gestion des cartes");
		System.out.println("5- Gestion des personnages");
		System.out.println("6- Gestion de la boutique");
		System.out.println("7- Deconnexion");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : creerNewCompteAdmin();break;
		case 2 : gestionPlateaux();break;
		case 3 : gestionCases(); break;
		case 4 : gestionCartes(); break;
		case 5 : gestionPersonnages(); break;
		case 6 : gestionBoutique(); break;
		case 7 : menuConnexion(); break;
		}
		menuAdmin();
		
	}

	private static void creerNewCompteAdmin() {
		String nom = saisieString("Saisir le nom du nouvel admin");
		String prenom = saisieString("Saisir le prenom du nouvel admin");
		String login = saisieString("Saisir le login du nouvel admin");
		String password = saisieString("Saisir le password du nouvel admin");
		String mail = saisieString("Saisir le mail du nouvel admin");
		
		System.out.println("on est bientôt arrivé au bout");
		Admin a = new Admin (login,password,nom,prenom,mail);
		daoCompte.insert(a); 
		System.out.println("Bravo! vous venez de créer le compte admin de "+a.getPrenom() + " "+ a.getNom()); 
		System.out.println(a); 
		
		
		menuConnexion();
		
	}

	private static void gestionBoutique() {
		// TODO Auto-generated method stub
		
	}

	private static void gestionPersonnages() {
		// TODO Auto-generated method stub
		
	}

	private static void gestionCartes() {
		// TODO Auto-generated method stub
		
	}

	private static void gestionCases() {
		// TODO Auto-generated method stub
		
	}

	private static void gestionPlateaux() {
		// TODO Auto-generated method stub
		
	}

	

	public static void main(String[] args) {
//		MyGame mg = new MyGame();
//		mg.jouer();
		
		
		menuConnexion();
		
		
	}
}
