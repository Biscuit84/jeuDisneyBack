package IDAO;

import java.util.List;

import model.Joueur;
import model.PersoObtenu;

public interface IDAOJoueur extends IDAO<Joueur,Integer> {
	public  List<PersoObtenu> listePersonnagesJoueur (int id) ;
}
