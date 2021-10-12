package plateau;

public abstract class Case {

	protected int id;
	protected String nom;
//	private String effet;
	
	
	public Case(int id, String nom) {
		
		this.id = id;
		this.nom = nom;
	}
	
	
	
	
	public Case() {
		
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




	@Override
	public String toString() {
		return "Case [id=" + id + ", nom=" + nom + "]";
	}




	public abstract void effetCase();



	
	
}
