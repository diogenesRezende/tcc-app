package br.edu.univas.restapiapp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.univas.restapiapp.controller.AlunoDisciplinasCtrl;
import br.edu.univas.restapiapp.controller.AlunoEventosCtrl;
import br.edu.univas.restapiapp.entities.AlunoDisciplinas;
import br.edu.univas.restapiapp.entities.AlunoEventos;

@Path("/alunos")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AlunosResource {

	/*
	 * Busca os ultimos eventos relacionados ao aluno
	 */
	@GET
	@Path("eventos/{id}")
	public AlunoEventos getEventosByIdAluno(@PathParam("id") String id) {

		System.out.println("id aluno " + id);
		Long idAluno = Long.parseLong(id);
		AlunoEventosCtrl ctrl = new AlunoEventosCtrl();
		return ctrl.getEventosByMatricula(idAluno);
	}

	/*
	 * Busca as disciplinas cursadas pelo aluno
	 */
	@GET
	@Path("disciplinas/{id}")
	public AlunoDisciplinas getDisciplinasByIdAluno(@PathParam("id") String id) {

		System.out.println("id aluno " + id);
		Long idAluno = Long.parseLong(id);
		AlunoDisciplinasCtrl ctrl = new AlunoDisciplinasCtrl();
		return ctrl.getDisciplinaByMtricula(idAluno);
	}

}
