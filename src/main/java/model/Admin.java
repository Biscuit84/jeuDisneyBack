package model;

public class Admin extends Compte {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String login, String password, String nom, String prenom, String mail) {
		super(id, login, password, nom, prenom, mail);
		// TODO Auto-generated constructor stub
	}

	public Admin(String login, String password, String nom, String prenom, String mail) {
		super(login, password, nom, prenom, mail);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", mail=" + mail + "]";
	}

	
	
	
}
