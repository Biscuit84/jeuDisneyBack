package IDAO;

import java.util.List;

import plateau.CasesPlateau;
import plateau.Plateau;

public interface IDAOPlateau extends IDAO<Plateau,Integer> {

	public List<CasesPlateau> listeCasesPlateau (int id);

}
