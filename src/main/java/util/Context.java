package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.DAOBoutique;
import DAO.DAOCarte;
import DAO.DAOCases;
import DAO.DAOCasesPlateau;
import DAO.DAOCompte;
import DAO.DAOHistorique;
import DAO.DAOPersonnage;
import DAO.DAOPlateau;
import IDAO.IDAOBoutique;
import IDAO.IDAOCarte;
import IDAO.IDAOCases;
import IDAO.IDAOCasesPlateau;
import IDAO.IDAOCompte;
import IDAO.IDAOHistorique;
import IDAO.IDAOPersonnage;
import IDAO.IDAOPlateau;


public class Context {



	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("baseJeuDisney");
	private IDAOBoutique daoBoutique = new DAOBoutique();
	private IDAOCarte daoCarte = new DAOCarte();
	private IDAOCases daoCases = new DAOCases();
	private IDAOCasesPlateau daoCasesPlateau = new DAOCasesPlateau();
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOHistorique daoHistorique = new DAOHistorique();
	private IDAOPersonnage daoPersonnage = new DAOPersonnage();
	private IDAOPlateau daoPlateau = new DAOPlateau();
	
	
	
	//SINGLETON
	private static Context _instance;
	
	
	private Context() {}
	
	
	
	public static Context getInstance() 
	{
		if(_instance==null)
		{_instance=new Context();}
		
		return _instance;
	}
	//FIN SINGLETON



	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void closeEmf() 
	{
		this.emf.close();
	}



	public IDAOBoutique getDaoBoutique() {
		return daoBoutique;
	}



	public IDAOCarte getDaoCarte() {
		return daoCarte;
	}



	public IDAOCases getDaoCases() {
		return daoCases;
	}



	public IDAOCasesPlateau getDaoCasesPlateau() {
		return daoCasesPlateau;
	}



	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}



	public IDAOHistorique getDaoHistorique() {
		return daoHistorique;
	}



	public IDAOPersonnage getDaoPersonnage() {
		return daoPersonnage;
	}



	public IDAOPlateau getDaoPlateau() {
		return daoPlateau;
	}



	
	
	
	
	
}
