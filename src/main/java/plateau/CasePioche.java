package plateau;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import model.Carte;

@Entity
public class CasePioche extends Cases {

	@OneToMany
	private List<Carte> cartes;
	
	
	
	public CasePioche(String nom, List<Carte> cartes) {
		super(nom);
		this.cartes = cartes;
	}

	public CasePioche() {
		super();
		
	}

	public CasePioche(String nom) {
		super( nom);
		
	}

	
	
	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	@Override
	public void effetCase() {
		// TODO Auto-generated method stub
		
	}

}
