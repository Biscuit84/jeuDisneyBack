package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import IDAO.IDAOBoutique;
import model.Boutique;
import util.Context;

public class DAOBoutique implements IDAOBoutique{

	@Override
	public Boutique findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Boutique objet = em.find(Boutique.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Boutique> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Boutique a",Boutique.class);
		List<Boutique> Boutique = requete.getResultList();
		em.close();
		return Boutique;
	}


	@Override
	public Boutique save(Boutique o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Boutique o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
