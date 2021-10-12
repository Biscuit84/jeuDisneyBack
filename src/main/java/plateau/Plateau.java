package plateau;



public class Plateau   {

	private int id;
	private String nom;
	private int nbCases;
	
	
	public Plateau(int id, String nom, int nbCases) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbCases = nbCases;
	}


	public Plateau() {
		super();
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
