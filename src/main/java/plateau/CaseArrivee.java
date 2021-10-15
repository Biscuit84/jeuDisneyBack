package plateau;

import javax.persistence.Entity;

@Entity
public class CaseArrivee extends Cases {

	
	
	
	public CaseArrivee() {
		super();
		
	}

	public CaseArrivee(int id, String nom) {
		super(id, nom);
		
	}

	@Override
	public void effetCase() {
		
		
	}

}
