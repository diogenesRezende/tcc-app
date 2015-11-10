package br.edu.univas.restapiapp.resources;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import br.edu.univas.restapiapp.model.Usuario;
import br.edu.univas.restapiapp.util.JpaUtil;

@Path("/usuarios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UsuarioResource {
	@POST
	@Path("/usuario")
	public void receiveGoogleId(Usuario user) {
		EntityManager em = JpaUtil.getEntityManager();

		try {

			String jpql = "select u from Usuario u where u.username=:id";
			TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class)
					.setParameter("id", user.getUsername());
			Usuario userNew = query.getSingleResult();

			// if (userNew.getIdGCM().isEmpty()) {
			userNew.setIdGCM(user.getIdGCM());
			// // } else {
			// throw new WebApplicationException(Status.CONFLICT);
			// // }
			em.getTransaction().begin();
			em.persist(userNew);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		} finally {
			em.close();
		}

		// System.out.println("nadadadadadda" + user.getIdGCM());
		// System.out.println("nadadadadadda" + user.getPassword());
		// System.out.println("nadadadadadda" + user.getUsername());
		// System.out.println("nadadadadadda" + user.getIdUsuario());
		throw new WebApplicationException(Status.CREATED);

	}
}
