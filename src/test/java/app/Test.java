package app;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.Admin;
import model.Compte;
import model.Joueur;
import model.PersoObtenu;
import model.Personnage;
import util.Context;

public class Test {


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
			menuAdmin();
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

	//--------------------MENU JOUEUR--------------------
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
		case 4 : menuConnexion(); break;
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
		case 2 : modifEMail();break;
		case 3 : modifLogin();break;
		case 4 : modifPassword();break;
		case 5 : gestionProfilJoueur(); break;
		case 6 : menuJoueur(); break;
		}
		modifProfilJoueur();
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
					gestionProfilAdmin();
				}
				else if (connected instanceof Joueur) {
					modifProfilJoueur();
				}
				break;
			}
		}


		if (connected instanceof Admin) {
			gestionProfilAdmin();
		}
		else if (connected instanceof Joueur) {
			modifProfilJoueur();
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
			gestionProfilAdmin();
		}
		else if (connected instanceof Joueur) {
			modifProfilJoueur();
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
			gestionProfilAdmin();
		}
		else if (connected instanceof Joueur) {
			modifProfilJoueur();
		}

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
		System.out.println("3- Acheter des skins");
		System.out.println("4- Retour menu Joueur");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : achatEtoiles();break;
		case 2 : achatPerso();break;
		case 3 : achatSkins(); break;
		case 4 : menuJoueur(); break;
		}
		menuBoutiqueJoueur();

	}


	private static void achatSkins() {
		// TODO Auto-generated method stub

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

	//--------------------------MENU ADMIN--------------

	public static void menuAdmin() {
		System.out.println("Menu Admin");
		System.out.println("1- Gestion du profil");
		System.out.println("2- Gestion des comptes");
		System.out.println("3- Gestion des parties");
		System.out.println("4- Gestion de la boutique");
		System.out.println("5- Deconnexion");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : gestionProfilAdmin(); break;
		case 2 : gestionComptes();break;
		case 3 : gestionParties();break;
		case 4 : gestionBoutique(); break;
		case 5 : menuConnexion(); break;
		}
		menuAdmin();

	}

	public static void gestionProfilAdmin() {
		System.out.println("Menu Admin/ Gestion de Profil");
		System.out.println("1- Modifier l'adresse e-mail");
		System.out.println("2- Modifier le login");
		System.out.println("3- Modifier le mot de passe");
		System.out.println("4- Retour au menu admin");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : modifEMail();break;
		case 2 : modifLogin();break;
		case 3 : modifPassword();break;
		case 4 : menuAdmin(); break;
		}
		gestionProfilAdmin();

	}

	public static void gestionComptes() {
		System.out.println("Menu Admin/Gestion des Comptes");
		System.out.println("1- Créer un nouveau compte Admin");
		System.out.println("2- Créer un nouveau compte Joueur");
		System.out.println("3- Supprimer un compte Admin");
		System.out.println("4- Supprimer un compte Joueur");
		System.out.println("5- Retour au menu Admin");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : creerNewCompteAdmin();break;
		case 2 : creerNewCompteJoueur();break;
		case 3 : supprimerCompteAdmin();break;
		case 4 : supprimerCompteJoueur();break;
		case 5 : menuAdmin(); break;
		}
		gestionComptes();

	}

	public static void creerNewCompteAdmin() {
		System.out.println("Menu Admin/Gestion des Comptes/Creation d'un Compte Admin");
		String nom = saisieString("Saisir le nom du nouvel admin");
		String prenom = saisieString("Saisir le prenom du nouvel admin");
		String login = saisieString("Saisir le login du nouvel admin");
		String password = saisieString("Saisir le password du nouvel admin");
		String mail = saisieString("Saisir le mail du nouvel admin");


		Compte a = new Admin (login,password,nom,prenom,mail);
		Context.getInstance().getDaoCompte().save(a);
		System.out.println("Bravo! vous venez de créer le compte admin de "+a.getPrenom() + " "+ a.getNom()); 
		System.out.println(a); 


		menuAdmin();

	}

	public static void supprimerCompteAdmin() {
		System.out.println("Menu Admin/Gestion des Comptes/Supression d'un Compte Admin");
		System.out.println("Voici la liste des comptes admin:");
		System.out.println(Context.getInstance().getDaoAdmin().findAll());
		int idSelection=saisieInt("Quel compte voulez vous supprimer? (saisir son id)");
		Compte c = Context.getInstance().getDaoAdmin().findById(idSelection);
		String confirmation =saisieString("Vous allez supprimer le compte "+c+"\nVoulez-vous confirmer? (y/n)");
		if (confirmation.equalsIgnoreCase("y")) {
			Context.getInstance().getDaoCompte().delete(c);
			System.out.println("vous avez supprimé "+c+" de la base de donnée");
		}
		else {
			System.out.println("La suppression du compte "+c+" a été annulée");
			System.out.println("1- Supprimer un autre compte admin");
			System.out.println("2- Retour au menu Gestion des comptes");
			int choix = saisieInt("Choisir un menu :");
			switch(choix) 
			{
			case 1 : supprimerCompteAdmin();break;
			case 2 : gestionComptes();break;
			default: gestionComptes();
			}

		}
		gestionComptes();
	}

	public static void supprimerCompteJoueur() {
		System.out.println("Menu Admin/Gestion des Comptes/Supression d'un Compte Joueur");
		System.out.println("Voici la liste des comptes joueur:");
		System.out.println(Context.getInstance().getDaoJoueur().findAll());
		int idSelection=saisieInt("Quel compte voulez vous supprimer? (saisir son id)");
		Compte c = Context.getInstance().getDaoJoueur().findById(idSelection);
		String confirmation =saisieString("Vous allez supprimer le compte "+c+"\nVoulez-vous confirmer? (y/n)");
		if (confirmation.equalsIgnoreCase("y")) {
			Context.getInstance().getDaoCompte().delete(c);
			System.out.println("vous avez supprimé "+c+" de la base de donnée");
		}
		else {
			System.out.println("La suppression du compte "+c+" a été annulée");
			System.out.println("1- Supprimer un autre compte joueur");
			System.out.println("2- Retour au menu Gestion des comptes");
			int choix = saisieInt("Choisir un menu :");
			switch(choix) 
			{
			case 1 : supprimerCompteJoueur();break;
			case 2 : gestionComptes();break;
			default: gestionComptes();
			}

		}
		gestionComptes();

	}


	public static void gestionParties() {
		System.out.println("Menu Admin/Gestion des Parties");
		System.out.println("1- Gestion des plateaux");
		System.out.println("2- Gestion des cases");
		System.out.println("3- Gestion des cartes");
		System.out.println("4- Gestion des personnages");
		System.out.println("5- Gestion des duels");
		System.out.println("6- Retour au menu Admin");	

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : gestionPlateaux();break;
		case 2 : gestionCases();break;
		case 3 : gestionCartes(); break;
		case 4 : gestionPersonnages(); break;
		case 5 : gestionDuels(); break;
		case 6 : menuAdmin(); break;
		}
		gestionParties();


	}

	private static void gestionDuels() {
		// TODO Auto-generated method stub

	}


	private static void gestionBoutique() {
		// TODO Auto-generated method stub

	}

	public static void gestionPersonnages() {
		System.out.println("Menu Admin/Gestion des Parties/Gestion des Personnages");
		System.out.println("1- Créer un nouveau personnage");
		System.out.println("2- Supprimer un personnage");
		System.out.println("3- Modifier le nom d'un personnage");
		System.out.println("4- Modifier le mechant associé a un personnage");
		System.out.println("5- Modifier le cout d'un personnage");
		System.out.println("6- Modifier le prince associé a un personnage");
		System.out.println("7- Modifier le pouvoir d'un personnage");
		System.out.println("8- Retour au menu Admin");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : creerNewPersonnage();break;
		case 2 : supprimerPersonnage();break;
		case 3 : modifNomPerso();break;
		case 4 : modifMechantPerso();break;
		case 5 : modifCoutPerso();break;
		case 6 : modifPrincePerso();break;
		case 7 : modifPouvoirPerso();break;
		case 8 : menuAdmin(); break;
		}
		gestionPersonnages();

	}


	private static void modifPouvoirPerso() {
		// TODO Auto-generated method stub

	}

	private static void modifPrincePerso() {
		// TODO Auto-generated method stub

	}

	private static void modifCoutPerso() {
		// TODO Auto-generated method stub

	}

	private static void modifMechantPerso() {
		// TODO Auto-generated method stub

	}

	public static void modifNomPerso() {
		System.out.println("Voici la liste des personnages existants:");
		System.out.println(Context.getInstance().getDaoPersonnage().findAll());
		int choixPerso = saisieInt("De quel personnage voulez-vous modifier le nom? (n°id)");
		Personnage perso = Context.getInstance().getDaoPersonnage().findById(choixPerso);
		String nouveauNomPerso = saisieString("Entrez le nouveau nom du personnage");
		perso.setNom(nouveauNomPerso);
		Context.getInstance().getDaoPersonnage().save(perso);
		System.out.println("Le personnage n°"+choixPerso+" a bien ete modifie");
		
		gestionPersonnages();

	}
	

	public static void supprimerPersonnage() {
		System.out.println("Voici la liste des personnages existants:");
		System.out.println(Context.getInstance().getDaoPersonnage().findAll());
		int choixPerso = saisieInt("Quel personnage voulez-vous supprimer? (n°id)");
		Personnage persoASupprimer = Context.getInstance().getDaoPersonnage().findById(choixPerso);
		System.out.println("Vous allez supprimer definitivement le personnage :"+persoASupprimer);
		String confirmationChoix = saisieString("Etes-vous sur? (y/n)");

		if (confirmationChoix.equalsIgnoreCase("y")) {
			Context.getInstance().getDaoPersonnage().delete(persoASupprimer);
			System.out.println("Le personnage "+persoASupprimer+" a bien ete supprime de la base de donnee");
		}
		else {
			System.out.println("Que voulez vous faire?");
			System.out.println("1- Reessayer");
			System.out.println("2- Retour au menu gestion des personnages");

			int choix = saisieInt("Choisir un menu :");
			switch(choix) 
			{
			case 1 : supprimerPersonnage();break;
			case 2 : gestionPersonnages();break;
			}
		}

		gestionPersonnages();
	}

	public static void creerNewPersonnage() {
		System.out.println("Voici la liste des personnages deja crees:");
		System.out.println(Context.getInstance().getDaoPersonnage().findAll());
		String nomPerso = saisieString("Saisir le nom du nouveau personnage:");
		String prince = saisieString("Saisir le prince associe au nouveau personnage:");
		String mechant = saisieString("Saisir le nom du mechant associe au nouveau personnage:");
		String pouvoir = saisieString("Saisir le pouvoir du nouveau personnage:");
		int prixAchat = saisieInt("Saisir le prix d'achat du nouveau personnage:");
		Personnage newP= new Personnage(nomPerso,prince,mechant,pouvoir,prixAchat);
		Context.getInstance().getDaoPersonnage().save(newP);
		System.out.println("Bravo! vous venez de creer le nouveau personnage: "+Context.getInstance().getDaoPersonnage().findById(newP.getId()));

		gestionPersonnages();

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
		Context.getInstance().closeEmf();

	}
}
