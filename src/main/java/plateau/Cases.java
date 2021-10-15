package plateau;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_case")
public abstract  class Cases {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	protected int id;
	protected String nom;
//	private String effet;
	
	
	public Cases(String nom) {
		
	
		this.nom = nom;
	}
	
	public Cases(int id,String nom) {
		
		this.id=id;
		this.nom = nom;
	}
	
	
	public Cases() {
		
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
