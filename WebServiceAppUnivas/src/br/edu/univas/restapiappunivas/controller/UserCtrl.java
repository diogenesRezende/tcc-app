package br.edu.univas.restapiappunivas.controller;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.univas.restapiappunivas.model.User;
import br.edu.univas.restapiappunivas.util.JpaUtil;

public class UserCtrl {
	public void receiveGCMId(User user) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			String jpql = "select u from User u where u.username=:user";
			TypedQuery<User> query = em.createQuery(jpql, User.class)
					.setParameter("user", user.getUsername());
			User userNew = query.getSingleResult();
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
