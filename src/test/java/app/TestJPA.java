package app;

import plateau.Cases;
import plateau.CaseDepart;
import plateau.CaseVide;
import util.Context;

public class TestJPA {

	public static void initCase() {
		
		Cases cd = new CaseDepart("Départ");
		Cases cv = new CaseVide("Vide");

	}
	public static void main(String[] args) {


		//	Cases cd=new Cases("ligne");
		Context.getInstance().getDaoCases();
		Context.getInstance().closeEmf();

	}
}
