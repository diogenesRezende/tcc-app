package br.edu.univas.restapiapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import br.edu.univas.restapiapp.entities.AlunoDisciplinas;
import br.edu.univas.restapiapp.model.Disciplina;
import br.edu.univas.restapiapp.util.JpaUtil;

public class AlunoDisciplinasCtrl {
	
	public AlunoDisciplinas getDisciplinaByMtricula(Long idAluno) {
		EntityManager em = JpaUtil.getEntityManager();

		String jpql = "select distinct d.idDisciplina, d.idDbExterno, d.nome from Periodo p ";
		jpql += "inner join p.disciplinas d inner join p.alunos a where a.idDbExterno=:id";

		try {
			Query query = em.createQuery(jpql);
			query.setParameter("id", idAluno);
			@SuppressWarnings("unchecked")
			List<Object[]> resultSet = query.getResultList();
			List<Disciplina> disciplinas = new ArrayList<Disciplina>();
			for (Object[] obj : resultSet) {
				Disciplina d = new Disciplina();
				d.setIdDisciplina((Long) obj[0]);
				d.setIdDbExterno((Long) obj[1]);
				d.setNome((String) obj[2]);
				disciplinas.add(d);
			}
			AlunoDisciplinas alunoDisciplinas = new AlunoDisciplinas();
			alunoDisciplinas.setDisciplinas(disciplinas);
			return alunoDisciplinas;
		} catch (Exception e) {
			throw new WebApplicationException(Status.NOT_FOUND);
		} finally {
			em.close();
		}

	}
}
