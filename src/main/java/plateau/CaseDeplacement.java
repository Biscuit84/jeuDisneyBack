package plateau;

import java.util.Random;

public class CaseDeplacement extends Case {

	
	
	
	
	public CaseDeplacement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseDeplacement(int id, String nom) {
		super(id, nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effetCase() {
	//  tirage d'un chiffre aléatoire entre -3 et -1, sans 0
	// avance ou recule 
		
		int number =0;
		while (number==0) {
			Random r = new Random();
			number = r.nextInt(7 - 0) - 3;
		}
		
		
		
	}

}
