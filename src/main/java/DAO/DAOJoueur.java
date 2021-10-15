package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import IDAO.IDAOJoueur;
import model.Joueur;
import model.PersoObtenu;
import util.Context;

public class DAOJoueur implements IDAOJoueur{

	@Override
	public Joueur findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Joueur joueur = em.find(Joueur.class, id);
		em.close();
		return joueur;
	}

	@Override
	public List<Joueur> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Joueur j",Joueur.class);
		List<Joueur> Joueurs = requete.getResultList();
		em.close();
		return Joueurs;
	}


	@Override
	public Joueur save(Joueur o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Joueur o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}




	public  List<PersoObtenu> listePersonnagesJoueur (int id) {


		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT p from PersoObtenu p where p.joueur.id=:id",PersoObtenu.class);
		q.setParameter("id",id);
		List<PersoObtenu> persos = q.getResultList();

		em.close();
		return persos;

	}
}
