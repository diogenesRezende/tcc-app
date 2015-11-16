package br.edu.univas.restapiappunivas.controller;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.univas.restapiappunivas.model.Usuario;
import br.edu.univas.restapiappunivas.util.JpaUtil;

public class UserCtrl {
	public void receiveGCMId(Usuario user) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			String jpql = "select u from Usuario u where u.username=:id";
			TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class)
					.setParameter("id", user.getUsername());
			Usuario userNew = query.getSingleResult();
			userNew.setIdGCM(user.getIdGCM());
			em.getTransaction().begin();
			em.persist(userNew);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
