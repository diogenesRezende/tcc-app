package br.edu.univas.restapiappunivas.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.univas.restapiappunivas.controller.StudentDisciplinesCtrl;
import br.edu.univas.restapiappunivas.controller.StudentEventsCtrl;
import br.edu.univas.restapiappunivas.entities.StudentDisciplines;
import br.edu.univas.restapiappunivas.entities.StudentEvents;

@Path("/students")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class StudentsResource {

	@GET
	@Path("events/{studentRegistration}")
	public StudentEvents getEventsByStudentRegistration(
			@PathParam("studentRegistration") String studentRegistration) {

		System.out.println("Registration - " + studentRegistration);
		Long studentRegistrationLong = Long.parseLong(studentRegistration);
		StudentEventsCtrl ctrl = new StudentEventsCtrl();
		return ctrl.getEventsByStudentRegistration(studentRegistrationLong);
	}

	@GET
	@Path("disciplines/{studentRegistration}")
	public StudentDisciplines getDisciplinesByStudentRegistration(
			@PathParam("studentRegistration") String studentRegistration) {

		System.out.println("Registration - " + studentRegistration);
		Long studentRegistrationLong = Long.parseLong(studentRegistration);
		StudentDisciplinesCtrl ctrl = new StudentDisciplinesCtrl();
		return ctrl
				.getDisciplinesByStudentRegistration(studentRegistrationLong);
	}

}
