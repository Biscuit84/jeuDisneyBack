package app;


import java.util.List;

import model.Admin;
import model.Joueur;
import model.PersoObtenu;
import model.Personnage;
import plateau.CaseArrivee;
import plateau.CaseDepart;
import plateau.CaseDeplacement;
import plateau.CaseDuel;
import plateau.CaseMechant;
import plateau.CasePioche;
import plateau.CasePrince;
import plateau.CasePrison;
import plateau.CaseVide;
import plateau.Cases;
import plateau.CasesPlateau;
import plateau.Plateau;
import util.Context;

public class TestJPA {

	public static void initCase() {

		Cases cd = new CaseDepart("Depart");
		Cases cv = new CaseVide("Vide");
		Cases cde = new CaseDeplacement("Deplacement");
		Cases cdu = new CaseDuel("Duel");
		Cases cm = new CaseMechant("Mechant");
		Cases cp = new CasePioche("Pioche");
		Cases cpr = new CasePrince("Charmant");
		Cases cpri = new CasePrison("Prison");
		Cases ca = new CaseArrivee("Arrivee");

		Context.getInstance().getDaoCases().save(cd);
		Context.getInstance().getDaoCases().save(cv);
		Context.getInstance().getDaoCases().save(cde);
		Context.getInstance().getDaoCases().save(cdu);
		Context.getInstance().getDaoCases().save(cm);
		Context.getInstance().getDaoCases().save(cp);
		Context.getInstance().getDaoCases().save(cpr);
		Context.getInstance().getDaoCases().save(cpri);
		Context.getInstance().getDaoCases().save(ca);

		


	}

	public static void initPlateau() {

		Plateau testPlateau = new Plateau("Test", 9);
		Context.getInstance().getDaoPlateau().save(testPlateau);
		
	}

	public static void initCasesPlateau() {
		Plateau plateau= Context.getInstance().getDaoPlateau().findById(1);
		CasesPlateau cp = new CasesPlateau(plateau, Context.getInstance().getDaoCases().findById(1), 0);
		CasesPlateau cp1 = new CasesPlateau(plateau, Context.getInstance().getDaoCases().findById(2), 1);
		CasesPlateau cp2 = new CasesPlateau(plateau, Context.getInstance().getDaoCases().findById(3), 2);
		CasesPlateau cp3 = new CasesPlateau(plateau, Context.getInstance().getDaoCases().findById(4), 3);
		CasesPlateau cp4 = new CasesPlateau(plateau, Context.getInstance().getDaoCases().findById(5), 4);
		CasesPlateau cp5 = new CasesPlateau(plateau, Context.getInstance().getDaoCases().findById(6), 5);
		CasesPlateau cp6 = new CasesPlateau(plateau, Context.getInstance().getDaoCases().findById(7), 6);
		CasesPlateau cp7 = new CasesPlateau(plateau, Context.getInstance().getDaoCases().findById(8), 7);
		CasesPlateau cp8 = new CasesPlateau(plateau, Context.getInstance().getDaoCases().findById(9), 8);

		Context.getInstance().getDaoCasesPlateau().save(cp);
		Context.getInstance().getDaoCasesPlateau().save(cp1);
		Context.getInstance().getDaoCasesPlateau().save(cp2);
		Context.getInstance().getDaoCasesPlateau().save(cp3);
		Context.getInstance().getDaoCasesPlateau().save(cp4);
		Context.getInstance().getDaoCasesPlateau().save(cp5);
		Context.getInstance().getDaoCasesPlateau().save(cp6);
		Context.getInstance().getDaoCasesPlateau().save(cp7);
		Context.getInstance().getDaoCasesPlateau().save(cp8);
		
	}


	public static void initPersonnage () {


		Personnage p1 = new Personnage ("Elsa","Olaf","Prince hans des iles du sud","Gèle:tous le monde ne joue pas pendat un tour");
		Personnage p2 = new Personnage ("Ariel","Prince Eric","Ursula","Noie:tous le monde ne joue pas pendat un tour");
		Personnage p3 = new Personnage ("Cendrillon","Prince Thomas","Belle-mère","Perd sa chaussure :tous le monde ne joue pas pendat un tour");
		Context.getInstance().getDaoPersonnage().save(p1);
		Context.getInstance().getDaoPersonnage().save(p2);
		Context.getInstance().getDaoPersonnage().save(p3);
		
	}
	
	public static void initJoueur() {

		Joueur joueur1 = new Joueur("login", "password", "nomjoueur1", "prenomjoueur1", "joueur1@mail.com", "joueur1", "0", 1);
		Context.getInstance().getDaoJoueur().save(joueur1);
		
	}
	
	public static void initAdmin() {
		Admin admin1 = new Admin("admin", "admin", "nomAdmin1", "prenomAdmin1", "admin1@mail.com");
		Context.getInstance().getDaoAdmin().save(admin1);
		
	}
	
	
	
	public static void main(String[] args) {

		initCase();
		initPlateau();
		initCasesPlateau();
		initAdmin();
		initJoueur();
		initPersonnage();
		PersoObtenu po = new PersoObtenu(Context.getInstance().getDaoPersonnage().findById(1),Context.getInstance().getDaoJoueur().findById(1));
		PersoObtenu po1 = new PersoObtenu(Context.getInstance().getDaoPersonnage().findById(2),Context.getInstance().getDaoJoueur().findById(1));
		Context.getInstance().getDaoPersoObtenu().save(po);
		Context.getInstance().getDaoPersoObtenu().save(po1);
		//Test.connec();
		
		
		List<PersoObtenu> persos=Context.getInstance().getDaoJoueur().listePersonnagesJoueur(Context.getInstance().getConnected().getId());
		
		for(PersoObtenu p : persos) 
		{
			System.out.println(p.getPerso().getNom());
		}
		Context.getInstance().closeEmf();
		
		


	}
}
