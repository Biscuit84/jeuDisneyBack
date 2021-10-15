package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import IDAO.IDAOCarte;
import model.Carte;
import util.Context;

public class DAOCarte implements IDAOCarte{

	@Override
	public Carte findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Carte objet = em.find(Carte.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Carte> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Carte a",Carte.class);
		List<Carte> Cartes = requete.getResultList();
		em.close();
		return Cartes;
	}


	@Override
	public Carte save(Carte o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Carte o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
