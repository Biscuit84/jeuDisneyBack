package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import IDAO.IDAOHistorique;
import model.Historique;
import util.Context;

public class DAOHistorique implements IDAOHistorique{

	@Override
	public Historique findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Historique objet = em.find(Historique.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Historique> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Historique a",Historique.class);
		List<Historique> Historiques = requete.getResultList();
		em.close();
		return Historiques;
	}


	@Override
	public Historique save(Historique o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Historique o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
