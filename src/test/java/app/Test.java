package app;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import admin.MenuAdmin;
import joueur.MenuJoueur;
import model.Admin;
import model.Compte;
import model.Joueur;
import model.PersoObtenu;
import model.Personnage;
import util.Context;

public class Test {


	static Compte connected=Context.getInstance().getConnected();;
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


	//------------------MENU CONNECTION------------------
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
		String pseudo = saisieString("Saisir un pseudo");
		Joueur j = new Joueur (login,password,nom,prenom,mail,pseudo);
		Context.getInstance().getDaoCompte().save(j);
		System.out.println("Bravo! vous venez de créer votre compte"); 
		System.out.println(j); 

		if (connected instanceof Admin) {
			MenuAdmin.menuAdmin();
		}
		else {
			menuConnexion();
		}

	}

	public static void connec() {


		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		connected=Context.getInstance().getDaoCompte().connect(login, password);
		Context.getInstance().setConnected(connected);
		if(connected instanceof Admin) 
		{ 
			MenuAdmin.menuAdmin();

		}
		else if(connected instanceof Joueur) 
		{
			MenuJoueur.menuJoueur();
		}
		else 
		{
			System.out.println("Identifiants invalides");
			menuConnexion();
		}
	}

	
	
	
	public static void modifPassword() {
		System.out.println("Menu Joueur ou Admin/ Gestion de Profil/Modifications Profil/Modifier Password");
		boolean nouveauxPasswordIdentiques = false;

		String passwordActuel = saisieString("Veuillez saisir votre mot de passe actuel");
		if (passwordActuel.equals(connected.getPassword())) {
			while (!nouveauxPasswordIdentiques) {
				String nouveauPassword = saisieString("Veuillez saisir votre nouveau mot de passe");
				String nouveauPassword2 = saisieString("Pour confirmer, veuillez saisir une nouvelle fois votre nouveau mot de passe");
				if (nouveauPassword.equals(nouveauPassword2)) {
					nouveauxPasswordIdentiques=true;
					connected.setPassword(nouveauPassword2);
					Context.getInstance().getDaoCompte().save(connected);
				}
				else {
					nouveauxPasswordIdentiques=false;
					System.out.println("Les mots de passe saisis ne sont pas identiques");
				}
			}
			System.out.println("Votre nouveau mot de passe a bien été enregistré");
		} else {
			System.out.println("Votre mot de passe actuel n'est pas correct. Que voulez vous faire:");
			System.out.println("1- Essayer à nouveau");
			System.out.println("2- Retourner au menu Gestion de Profil");

			int choix = saisieInt("Choisir un menu :");
			switch(choix) 
			{
			case 1 : modifPassword();break;
			case 2 : 
				if (connected instanceof Admin) {
					MenuAdmin.gestionProfilAdmin();
				}
				else if (connected instanceof Joueur) {
					MenuJoueur.modifProfilJoueur();
				}
				break;
			}
		}


		if (connected instanceof Admin) {
			MenuAdmin.gestionProfilAdmin();
		}
		else if (connected instanceof Joueur) {
			MenuJoueur.modifProfilJoueur();
		}


	}
	
	
	
	public static void modifLogin() {
		System.out.println("Menu Joueur ou Admin/ Gestion de Profil/Modifications Profil/Modifier Login");
		boolean loginIdentiques = false;
		while (!loginIdentiques) {
			System.out.println("Voici le login que vous avez enregistré: " +connected.getLogin());
			String nouveauLogin = saisieString("Veuillez saisir votre nouveau login");
			String nouveauLogin2 = saisieString("Pour confirmer, veuillez saisir une nouvelle fois votre nouveau login");
			if (nouveauLogin.equals(nouveauLogin2)) {
				loginIdentiques=true;
				connected.setLogin(nouveauLogin2);
				Context.getInstance().getDaoCompte().save(connected);
			}
			else {
				loginIdentiques=false;
				System.out.println("Les login saisis ne sont pas identiques");
			}
		}
		System.out.println("Votre nouveau login "+connected.getLogin() + " a bien été enregistré");

		if (connected instanceof Admin) {
			MenuAdmin.gestionProfilAdmin();
		}
		else if (connected instanceof Joueur) {
			MenuJoueur.modifProfilJoueur();
		}

	}
	
	public static void modifEMail() {
		System.out.println("Menu Joueur ou Admin / Gestion de Profil/Modifications Profil/Modifier E-mail");
		boolean mailsIdentiques = false;
		while (!mailsIdentiques) {
			System.out.println("Voici l'adresse e-mail que vous avez enregistré: " +connected.getMail());
			String nouveauMail = saisieString("Veuillez saisir votre nouvelle adresse e-mail");
			String nouveauMail2 = saisieString("Pour confirmer, veuillez saisir une nouvelle fois votre nouvelle adresse e-mail");
			if (nouveauMail.equals(nouveauMail2)) {
				mailsIdentiques=true;
				connected.setMail(nouveauMail);
				Context.getInstance().getDaoCompte().save(connected);
			}
			else {
				mailsIdentiques=false;
				System.out.println("Les adresses e-mail saisies ne sont pas identiques");
			}
		}
		System.out.println("Votre nouvelle adresse email "+connected.getMail() + " a bien été enregistrée");

		if (connected instanceof Admin) {
			MenuAdmin.gestionProfilAdmin();
		}
		else if (connected instanceof Joueur) {
			MenuJoueur.modifProfilJoueur();
		}

	}
	
	
	//--------------------MENU JOUEUR--------------------
	

	//--------------------------MENU ADMIN--------------

	



	public static void main(String[] args) {
		

		menuConnexion();
		Context.getInstance().closeEmf();

	}
}
