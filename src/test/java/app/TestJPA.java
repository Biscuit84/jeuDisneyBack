package app;

import plateau.Cases;
import plateau.CaseDepart;
import util.Context;

public class TestJPA {


	public static void main(String[] args) {
		
		
	//	Cases cd=new Cases("ligne");
		Context.getInstance().getDaoCases();
		Context.getInstance().closeEmf();

	}
}
