package plateau;

import javax.persistence.Entity;

@Entity
public class CasePrince extends Cases {

	
	
	
	public CasePrince() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CasePrince(int id, String nom) {
		super(id, nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effetCase() {
		// avance de 1 à 3 cases
		
	}

}
