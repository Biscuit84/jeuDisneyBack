package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import IDAO.IDAOCases;
import plateau.Cases;
import util.Context;

public class DAOCases implements IDAOCases{

	@Override
	public Cases findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Cases objet = em.find(Cases.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Cases> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Case a",Cases.class);
		List<Cases> Cases = requete.getResultList();
		em.close();
		return Cases;
	}


	@Override
	public Cases save(Cases o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Cases o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
