package plateau;

import java.util.Random;

public class CaseMechant extends Case {

	public CaseMechant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseMechant(int id, String nom) {
		super(id, nom);
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Override
	public String toString() {
		return "CaseMechant [id=" + id + ", nom=" + nom + "]";
	}

	
	@Override
	public void effetCase() {
	//  tirage d'un chiffre al�atoire entre -3 et -1, sans 0
	// recule 
		
		
		int number =0;
		while (number==0) {
			Random r = new Random();
			number = r.nextInt(2 - 0) - 3;
		}
		
		
	}



	
	
}
