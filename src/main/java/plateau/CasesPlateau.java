package plateau;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import model.Personnage;

@Entity
public class CasesPlateau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCasePlateau;
	@ManyToOne
	private Plateau plateau;
	@OneToOne
	private Cases uneCase;
	
	@OneToMany(mappedBy = "position")
	private List<Personnage> joueurs;
	
	private int ordreCase;
	//private String effet;
	
	
	public CasesPlateau(Plateau plateau, Cases uneCase, int ordreCase) {
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
	public Cases getUneCase() {
		return uneCase;
	}
	public void setUneCase(Cases uneCase) {
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
