package plateau;

import javax.persistence.Entity;

@Entity
public class CaseVide extends Cases {

	
	
	
	public CaseVide() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseVide(int id, String nom) {
		super(id, nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effetCase() {
		// aucun effet
		
	}

}
