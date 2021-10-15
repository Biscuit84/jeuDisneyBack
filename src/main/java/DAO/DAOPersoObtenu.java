package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import IDAO.IDAOPersoObtenu;
import model.PersoObtenu;
import util.Context;

public class DAOPersoObtenu implements IDAOPersoObtenu{

	@Override
	public PersoObtenu findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		PersoObtenu objet = em.find(PersoObtenu.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<PersoObtenu> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from PersoObtenu p",PersoObtenu.class);
		List<PersoObtenu> persoObtenu = requete.getResultList();
		em.close();
		return persoObtenu;
	}


	@Override
	public PersoObtenu save(PersoObtenu o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(PersoObtenu o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	
}
