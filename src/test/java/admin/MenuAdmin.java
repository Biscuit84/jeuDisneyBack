package admin;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import app.Test;
import model.Admin;
import model.Compte;
import model.PersoObtenu;
import model.Personnage;
import plateau.Cases;
import plateau.CasesPlateau;
import plateau.Plateau;
import util.Context;

public class MenuAdmin {
	
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
		case 5 : Test.menuConnexion(); break;
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
		case 1 : Test.modifEMail();break;
		case 2 : Test.modifLogin();break;
		case 3 : Test.modifPassword();break;
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
		case 2 : Test.creerNewCompteJoueur();break;
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


	public static void modifPouvoirPerso() {
		System.out.println("Voici la liste des personnages existants:");
		System.out.println(Context.getInstance().getDaoPersonnage().findAll());
		int choixPerso = saisieInt("De quel personnage voulez-vous modifier le pouvoir? (n°id)");
		Personnage perso = Context.getInstance().getDaoPersonnage().findById(choixPerso);
		String nouveauPouvoirPerso = saisieString("Entrez le nouveau pouvoir du personnage");
		perso.setPouvoir(nouveauPouvoirPerso);
		perso=Context.getInstance().getDaoPersonnage().save(perso);
		System.out.println("Le personnage n°"+choixPerso+" a bien ete modifie");
		System.out.println(perso);
		
		gestionPersonnages();

	}

	public static void modifPrincePerso() {
		System.out.println("Voici la liste des personnages existants:");
		System.out.println(Context.getInstance().getDaoPersonnage().findAll());
		int choixPerso = saisieInt("De quel personnage voulez-vous modifier le prince? (n°id)");
		Personnage perso = Context.getInstance().getDaoPersonnage().findById(choixPerso);
		String nouveauPrincePerso = saisieString("Entrez le nouveau prince du personnage");
		perso.setPrince(nouveauPrincePerso);
		perso=Context.getInstance().getDaoPersonnage().save(perso);
		System.out.println("Le personnage n°"+choixPerso+" a bien ete modifie");
		System.out.println(perso);
		
		gestionPersonnages();

	}

	public static void modifCoutPerso() {
		System.out.println("Voici la liste des personnages existants:");
		System.out.println(Context.getInstance().getDaoPersonnage().findAll());
		int choixPerso = saisieInt("De quel personnage voulez-vous modifier le prix ? (n°id)");
		Personnage perso = Context.getInstance().getDaoPersonnage().findById(choixPerso);
		int nouveauPrixPerso = saisieInt("Entrez le nouveau prix du personnage");
		perso.setPrixAchatPerso(nouveauPrixPerso);
		perso=Context.getInstance().getDaoPersonnage().save(perso);
		System.out.println("Le personnage n°"+choixPerso+" a bien ete modifie");
		System.out.println(perso);
		
		gestionPersonnages();

	}

	public static void modifMechantPerso() {
		System.out.println("Voici la liste des personnages existants:");
		System.out.println(Context.getInstance().getDaoPersonnage().findAll());
		int choixPerso = saisieInt("De quel personnage voulez-vous modifier le mechant? (n°id)");
		Personnage perso = Context.getInstance().getDaoPersonnage().findById(choixPerso);
		String nouveauMechantPerso = saisieString("Entrez le nouveau mechant du personnage");
		perso.setMechant(nouveauMechantPerso);
		perso=Context.getInstance().getDaoPersonnage().save(perso);
		System.out.println("Le personnage n°"+choixPerso+" a bien ete modifie");
		System.out.println(perso);
		
		gestionPersonnages();

	}

	public static void modifNomPerso() {
		System.out.println("Voici la liste des personnages existants:");
		System.out.println(Context.getInstance().getDaoPersonnage().findAll());
		int choixPerso = saisieInt("De quel personnage voulez-vous modifier le nom? (n°id)");
		Personnage perso = Context.getInstance().getDaoPersonnage().findById(choixPerso);
		String nouveauNomPerso = saisieString("Entrez le nouveau nom du personnage");
		perso.setNom(nouveauNomPerso);
		perso=Context.getInstance().getDaoPersonnage().save(perso);
		System.out.println("Le personnage n°"+choixPerso+" a bien ete modifie");
		System.out.println(perso);
		
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
		newP=Context.getInstance().getDaoPersonnage().save(newP);
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
		System.out.println("Menu Admin/Gestion des Parties/Gestion des Plateaux");
		System.out.println("1- Ajouter un nouveau plateau");
		System.out.println("2- Supprimer un plateau");
		System.out.println("3- Modifier le nom d'un plateau");
		System.out.println("4- Modifier le nombre de cases d'un plateau");
		System.out.println("5- Assigner des cases au plateau");
		System.out.println("6- Retour au menu Admin");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : creerNewPlateau();break;
		case 2 : supprimerPlateau();break;
		case 3 : modifNomPlateau();break;
		case 4 : modifNbCasesPlateau();break;
		case 5 : modifCasesPlateau();break;
		case 6 : menuAdmin(); break;
		}
		gestionPlateaux();

	}
	
	
	
	
	public static void modifCasesPlateau() {
		System.out.println("Voici la liste des plateaux existants:");
		System.out.println(Context.getInstance().getDaoPlateau().findAll());
		int choixPlateau = saisieInt("De quel plateau voulez-vous modifier des cases? (n°id)");
		Plateau plateau = Context.getInstance().getDaoPlateau().findById(choixPlateau);
		System.out.println("Il y a "+plateau.getNbCases()+" cases dans le plateau");
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT cp from CasesPlateau cp where cp.plateau.id=:id",CasesPlateau.class);
		q.setParameter("id",plateau.getId());
		List<CasesPlateau> casesPlateau = q.getResultList();
		System.out.println("Liste des cases du plateau: ");
		for (CasesPlateau cp:casesPlateau) {
			System.out.println(cp.getIdCasePlateau()+"  "+cp.getUneCase().getNom());
		}
		
		int choixCase = saisieInt("Quelle case voulez-vous modifier? (n°id)");
		CasesPlateau cp = Context.getInstance().getDaoCasesPlateau().findById(choixCase);
		System.out.println(cp);
		System.out.println(Context.getInstance().getDaoCases().findAll());
		int modifCase = saisieInt("Quelle type de case ? (n°id)");
		cp.getUneCase().setId(modifCase);
		cp=Context.getInstance().getDaoCasesPlateau().save(cp);
		System.out.println(cp);
		
		
		gestionPlateaux();
		
	}

	public static void modifNbCasesPlateau() {
		System.out.println("Voici la liste des plateaux existants:");
		System.out.println(Context.getInstance().getDaoPlateau().findAll());
		int choixPlateau = saisieInt("De quel plateau voulez-vous modifier le nombre de cases? (n°id)");
		Plateau plateau = Context.getInstance().getDaoPlateau().findById(choixPlateau);
		int nouveauNbrPlateau = saisieInt("Entrez le nouveau nb de cases du plateau");
		plateau.setNbCases(nouveauNbrPlateau);
		plateau=Context.getInstance().getDaoPlateau().save(plateau);
		System.out.println("Le personnage n°"+choixPlateau+" a bien ete modifie");
		System.out.println(plateau);
		
		gestionPlateaux();
		
	}

	public static void modifNomPlateau() {
		System.out.println("Voici la liste des plateaux existants:");
		System.out.println(Context.getInstance().getDaoPlateau().findAll());
		int choixPlateau = saisieInt("De quel plateau voulez-vous modifier le nom? (n°id)");
		Plateau plateau = Context.getInstance().getDaoPlateau().findById(choixPlateau);
		String nouveauNomPlateau = saisieString("Entrez le nouveau nom du plateau");
		plateau.setNom(nouveauNomPlateau);
		plateau=Context.getInstance().getDaoPlateau().save(plateau);
		System.out.println("Le personnage n°"+choixPlateau+" a bien ete modifie");
		System.out.println(plateau);
		
		gestionPlateaux();
		
	}

	public static void supprimerPlateau() {
		System.out.println("Voici la liste des plateaux existants:");
		System.out.println(Context.getInstance().getDaoPlateau().findAll());
		int choixPlateau = saisieInt("Quel plateau voulez-vous supprimer? (n°id)");
		Plateau plateauASupprimer = Context.getInstance().getDaoPlateau().findById(choixPlateau);
		System.out.println("Vous allez supprimer definitivement le personnage :"+plateauASupprimer);
		String confirmationChoix = saisieString("Etes-vous sur? (y/n)");

		if (confirmationChoix.equalsIgnoreCase("y")) {
			Context.getInstance().getDaoPlateau().delete(plateauASupprimer);
			System.out.println("Le personnage "+plateauASupprimer+" a bien ete supprime de la base de donnee");
		}
		else {
			System.out.println("Que voulez vous faire?");
			System.out.println("1- Reessayer");
			System.out.println("2- Retour au menu gestion des plateaux");

			int choix = saisieInt("Choisir un menu :");
			switch(choix) 
			{
			case 1 : supprimerPersonnage();break;
			case 2 : gestionPlateaux();break;
			}
		}

		gestionPlateaux();
		
	}

	public static void creerNewPlateau() {
		System.out.println("Voici la liste des plateaux deja crees:");
		System.out.println(Context.getInstance().getDaoPlateau().findAll());
		String nomPlateau = saisieString("Saisir le nom du nouveau plateau:");
		int nbCases = saisieInt("Saisir le nombre de cases du nouveau plateau:");
		Plateau newP= new Plateau(nomPlateau,nbCases);
		newP=Context.getInstance().getDaoPlateau().save(newP);
		System.out.println("Bravo! vous venez de creer le nouveau plateau: "+Context.getInstance().getDaoPlateau().findById(newP.getId()));

		gestionPlateaux();
		
	}

	public static void main(String[] args) {
		modifCasesPlateau();

	}
	
	

	
}
