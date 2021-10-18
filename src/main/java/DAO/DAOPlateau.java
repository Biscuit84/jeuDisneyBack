package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import IDAO.IDAOPlateau;
import model.PersoObtenu;
import plateau.CasesPlateau;
import plateau.Plateau;
import util.Context;

public class DAOPlateau implements IDAOPlateau{

	@Override
	public Plateau findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Plateau objet = em.find(Plateau.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Plateau> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Plateau a",Plateau.class);
		List<Plateau> Plateaux = requete.getResultList();
		em.close();
		return Plateaux;
	}


	@Override
	public Plateau save(Plateau o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Plateau o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}



	public  List<CasesPlateau> listeCasesPlateau (int id) {

		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT p from CasesPlateau p where p.plateau.id=:id",CasesPlateau.class);
		q.setParameter("id",id);
		List<CasesPlateau> cases = q.getResultList();

		em.close();
		return cases;

	}
	
	
	
	
}
