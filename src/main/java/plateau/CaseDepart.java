package plateau;

import javax.persistence.Entity;

@Entity
public class CaseDepart extends Case{

	
	
	
	public CaseDepart() {
		super();
	
	}

	public CaseDepart(int id, String nom) {
		super(id, nom);
		
	}

	@Override
	public void effetCase() {
		
		
	}

}
