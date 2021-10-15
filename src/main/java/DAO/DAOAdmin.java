package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import IDAO.IDAOAdmin;
import model.Admin;
import util.Context;

public class DAOAdmin implements IDAOAdmin{

	@Override
	public Admin findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Admin admin = em.find(Admin.class, id);
		em.close();
		return admin;
	}

	@Override
	public List<Admin> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Admin a",Admin.class);
		List<Admin> Admins = requete.getResultList();
		em.close();
		return Admins;
	}


	@Override
	public Admin save(Admin o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Admin o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
