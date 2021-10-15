package plateau;

import javax.persistence.Entity;

@Entity
public class CasePrince extends Cases {

	
	
	
	public CasePrince() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CasePrince( String nom) {
		super( nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effetCase() {
		// avance de 1 à 3 cases
		
	}

}
