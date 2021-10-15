package plateau;

import java.util.Random;

import javax.persistence.Entity;

@Entity
public class CaseMechant extends Cases {

	public CaseMechant() {
		super();
		
	}

	public CaseMechant(String nom) {
		super( nom);
		
	}

	
	
	
	@Override
	public String toString() {
		return "CaseMechant [id=" + id + ", nom=" + nom + "]";
	}

	
@Override
	public void effetCase() {
//	//  tirage d'un chiffre aléatoire entre -3 et -1, sans 0
//	// recule 
//		
//		
//		int number =0;
//		while (number==0) {
//			Random r = new Random();
//			number = r.nextInt(2 - 0) - 3;
		}
		
		
	}



	
	

