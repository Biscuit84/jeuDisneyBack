package model;

import java.util.List;

public class Joueur extends Compte{

	private String pseudo;
	private String level="noob";
	private int life=3;
	private List<Historique> listeHistorique;
	private List<Partie> listePartie;


	public Joueur(int id, String login, String password, String nom, String prenom, String mail, String pseudo,
			String level, int life, List<Historique> listeHistorique, List<Partie> listePartie) {
		super(id, login, password, nom, prenom, mail);
		this.pseudo = pseudo;
		this.level = level;
		this.life = life;
		this.listeHistorique=listeHistorique;
		this.listePartie=listePartie;
	}

	public Joueur(String login, String password, String nom, String prenom, String mail, String pseudo,
			String level, int life) {
		super(login, password, nom, prenom, mail);
		this.pseudo = pseudo;
		this.level = level;
		this.life = life;
	}




	public Joueur(String login, String password, String nom, String prenom, String pseudo,String mail) {
		super(login, password, nom, prenom, mail);
		this.pseudo = pseudo;
		// TODO Auto-generated constructor stub
	}
	
	public Joueur(int id,String login, String password, String nom, String prenom, String pseudo,String mail) {
		super(id,login, password, nom, prenom, mail);
		this.pseudo = pseudo;
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
	
	
	

	public List<Historique> getListeHistorique() {
		return listeHistorique;
	}

	public void setListeHistorique(List<Historique> listeHistorique) {
		this.listeHistorique = listeHistorique;
	}

	
	
	
	public List<Partie> getListePartie() {
		return listePartie;
	}

	public void setListePartie(List<Partie> listePartie) {
		this.listePartie = listePartie;
	}

	@Override
	public String toString() {
		return "Joueur [pseudo=" + pseudo + ", level=" + level + ", life=" + life + ", id=" + id + ", login=" + login
				+ ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + "]";
	}











}
