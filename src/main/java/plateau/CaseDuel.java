package plateau;

import javax.persistence.Entity;

@Entity
public class CaseDuel extends Cases {

	
	
	
	public CaseDuel() {
		super();
		
	}

	public CaseDuel(int id, String nom) {
		super(id, nom);
		
	}

	@Override
	public void effetCase() {
		
		
	}

}
