package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import IDAO.IDAOPersonnage;
import model.Personnage;
import util.Context;

public class DAOPersonnage implements IDAOPersonnage{

	@Override
	public Personnage findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Personnage objet = em.find(Personnage.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Personnage> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Personnage a",Personnage.class);
		List<Personnage> Personnages = requete.getResultList();
		em.close();
		return Personnages;
	}


	@Override
	public Personnage save(Personnage o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Personnage o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
