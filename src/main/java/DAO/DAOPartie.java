package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import IDAO.IDAOPartie;
import model.Partie;
import util.Context;

public class DAOPartie implements IDAOPartie {

	@Override
	public Partie findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Partie objet = em.find(Partie.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Partie> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Partie p",Partie.class);
		List<Partie> parties = requete.getResultList();
		em.close();
		return parties;
	}


	@Override
	public Partie save(Partie o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Partie o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
}
