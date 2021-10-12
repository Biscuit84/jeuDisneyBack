package plateau;

public class CasesPlateau {

	private int idPlateau;
	private int idCase;
	private int ordreCase;
	//private String effet;
	
	
	public CasesPlateau(int idPlateau, int idCase, int ordreCase) {
		super();
		this.idPlateau = idPlateau;
		this.idCase = idCase;
		this.ordreCase = ordreCase;
	}
	public CasesPlateau() {
		super();
	}
	public int getIdPlateau() {
		return idPlateau;
	}
	public void setIdPlateau(int idPlateau) {
		this.idPlateau = idPlateau;
	}
	public int getIdCase() {
		return idCase;
	}
	public void setIdCase(int idCase) {
		this.idCase = idCase;
	}
	public int getOrdreCase() {
		return ordreCase;
	}
	public void setOrdreCase(int ordreCase) {
		this.ordreCase = ordreCase;
	}
	
	@Override
	public String toString() {
		return "CasesPlateau [idPlateau=" + idPlateau + ", idCase=" + idCase + ", ordreCase=" + ordreCase + "]";
	}
	
	
	
	
	
}
