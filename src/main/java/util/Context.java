package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOAchat;
import dao.IDAOClient;
import dao.IDAOFournisseur;
import dao.IDAOPersonne;
import dao.IDAOProduit;
import dao.jpa.DAOAchat;
import dao.jpa.DAOClient;
import dao.jpa.DAOFournisseur;
import dao.jpa.DAOPersonne;
import dao.jpa.DAOProduit;


public class Context {



	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("baseJeuDisney");
	
	
	

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

	
	
	
	
}
