package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import IDAO.IDAOCasesPlateau;
import plateau.CasesPlateau;
import util.Context;

public class DAOCasesPlateau implements IDAOCasesPlateau{

	@Override
	public CasesPlateau findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		CasesPlateau objet = em.find(CasesPlateau.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<CasesPlateau> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from CasesPlateau a",CasesPlateau.class);
		List<CasesPlateau> CasesPlateaux = requete.getResultList();
		em.close();
		return CasesPlateaux;
	}


	@Override
	public CasesPlateau save(CasesPlateau o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(CasesPlateau o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
