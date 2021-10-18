package plateau;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plateau   {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "VARCHAR(50)")
	private String nom;
	@Column(name="nombre_de_cases")
	private int nbCases;
	
	@OneToMany(mappedBy = "plateau")
	private List<CasesPlateau> cases;
	
	
	public Plateau(String nom, int nbCases) {
		this.nom = nom;
		this.nbCases = nbCases;
	}


	public Plateau() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getNbCases() {
		return nbCases;
	}


	public void setNbCases(int nbCases) {
		this.nbCases = nbCases;
	}


	@Override
	public String toString() {
		return "Plateau [id=" + id + ", nom=" + nom + ", nbCases=" + nbCases + "]";
	}
	
	
}
