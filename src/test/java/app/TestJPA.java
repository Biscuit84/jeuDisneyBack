package app;

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
	public static void main(String[] args) {

		initCase();

	}
}
