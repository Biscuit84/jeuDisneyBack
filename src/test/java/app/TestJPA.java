package app;

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

	public static void initPersonnage () {


		Personnage p1 = new Personnage ("Elsa","Olaf","Prince hans des iles du sud","Gèle:tous le monde ne joue pas pendat un tour");
		Personnage p2 = new Personnage ("Ariel","Prince Eric","Ursula","Noie:tous le monde ne joue pas pendat un tour");
		Personnage p3 = new Personnage ("Cendrillon","Prince Thomas","Belle-mère","Perd sa chaussure :tous le monde ne joue pas pendat un tour");
		Context.getInstance().getDaoPersonnage().save(p1);
		Context.getInstance().getDaoPersonnage().save(p2);
		Context.getInstance().getDaoPersonnage().save(p3);
		Context.getInstance().closeEmf();
	}





	public static void main(String[] args) {

		initPersonnage();

	}
}
