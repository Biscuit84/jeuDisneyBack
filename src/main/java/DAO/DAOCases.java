package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import IDAO.IDAOCases;
import plateau.Case;
import util.Context;

public class DAOCases implements IDAOCases{

	@Override
	public Case findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Case objet = em.find(Case.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Case> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Case a",Case.class);
		List<Case> Case = requete.getResultList();
		em.close();
		return Case;
	}


	@Override
	public Case save(Case o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Case o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
