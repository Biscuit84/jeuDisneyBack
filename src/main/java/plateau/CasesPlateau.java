package plateau;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CasesPlateau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCasePlateau;
	private Plateau plateau;
	private Case uneCase;
	private int ordreCase;
	//private String effet;
	
	
	public CasesPlateau(Plateau plateau, Case uneCase, int ordreCase) {
		this.plateau = plateau;
		this.uneCase = uneCase;
		this.ordreCase = ordreCase;
	}
	public CasesPlateau() {
		super();
	}

	
	public int getIdCasePlateau() {
		return idCasePlateau;
	}
	public void setIdCasePlateau(int idCasePlateau) {
		this.idCasePlateau = idCasePlateau;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	public Case getUneCase() {
		return uneCase;
	}
	public void setUneCase(Case uneCase) {
		this.uneCase = uneCase;
	}
	public int getOrdreCase() {
		return ordreCase;
	}
	public void setOrdreCase(int ordreCase) {
		this.ordreCase = ordreCase;
	}
	
	@Override
	public String toString() {
		return "CasesPlateau [idCasePlateau=" + idCasePlateau + ", plateau=" + plateau + ", uneCase=" + uneCase
				+ ", ordreCase=" + ordreCase + "]";
	}

	
	
	
	
	
	
}
