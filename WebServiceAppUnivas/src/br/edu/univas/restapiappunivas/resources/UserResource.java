package br.edu.univas.restapiappunivas.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import br.edu.univas.restapiappunivas.controller.UserCtrl;
import br.edu.univas.restapiappunivas.model.User;

@Path("/users")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserResource {
	@POST
	@Path("/user")
	public Status receiveGoogleId(User user) {
		System.err.println("||************|| " + user.getUsername());
		System.err.println("||************|| " + user.getIdGCM());
		UserCtrl ctrl = new UserCtrl();
		try {
			ctrl.receiveGCMId(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return Status.CREATED;
	}
}
