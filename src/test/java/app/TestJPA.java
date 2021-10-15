package app;

import model.Admin;
import model.Joueur;
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

		Context.getInstance().closeEmf();


	}
	
	
	
	public static void initPlateau() {
		
		Plateau testPlateau = new Plateau("Test", 9);
		Context.getInstance().getDaoPlateau().save(testPlateau);
		Context.getInstance().closeEmf();
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
		Context.getInstance().closeEmf();
	}
	
	
	
	public static void initJoueur() {

		Joueur joueur1 = new Joueur("login", "password", "nomjoueur1", "prenomjoueur1", "joueur1@mail.com", "joueur1", "0", 1);
		Context.getInstance().getDaoJoueur().save(joueur1);
		Context.getInstance().closeEmf();
	}
	
	public static void initAdmin() {
		Admin admin1 = new Admin("admin", "admin", "nomAdmin1", "prenomAdmin1", "admin1@mail.com");
		Context.getInstance().getDaoAdmin().save(admin1);
		Context.getInstance().closeEmf();
	}
	
	
	
	public static void main(String[] args) {

		//initCase();
		//initPlateau();
		//initCasesPlateau();
		//initAdmin();
		initJoueur();
		
		
		
		
		

	}
}
