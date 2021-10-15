package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Joueur extends Compte{

	private String pseudo;

	private String level="noob";

	private int life=3;




	@OneToOne
	private Historique historique;


	//	@OneToMany (mappedBy = "j")
	//	private List<Partie> listePartie;





	public Joueur(String login, String password, String nom, String prenom, String mail, String pseudo,
			String level, int life) {
		super(login, password, nom, prenom, mail);
		this.pseudo = pseudo;
		this.level = level;
		this.life = life;
	}





	public Joueur(String pseudo) {
		super();
		this.pseudo = pseudo;
	}





	public Joueur() {
		super();

	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}






	public Historique getHistorique() {
		return historique;
	}





	public void setHistorique(Historique historique) {
		this.historique = historique;
	}





	@Override
	public String toString() {
		return "Joueur [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", mail=" + mail + ", pseudo=" + pseudo + ", level=" + level + ", life=" + life
				+ ", historique=" + historique + "]";
	}





	









}
