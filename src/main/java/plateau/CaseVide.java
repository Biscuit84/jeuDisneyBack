package plateau;

import javax.persistence.Entity;

@Entity
public class CaseVide extends Cases {

	
	
	
	public CaseVide() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseVide(String nom) {
		super( nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effetCase() {
		// aucun effet
		
	}

}
