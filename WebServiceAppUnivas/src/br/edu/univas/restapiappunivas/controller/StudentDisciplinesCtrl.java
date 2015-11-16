package br.edu.univas.restapiappunivas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import br.edu.univas.restapiappunivas.entities.StudentDisciplines;
import br.edu.univas.restapiappunivas.model.Disciplina;
import br.edu.univas.restapiappunivas.util.JpaUtil;

public class StudentDisciplinesCtrl {

	public StudentDisciplines getDisciplinesByStudentRegistration(
			Long studentRegistration) {
		EntityManager em = JpaUtil.getEntityManager();

		String jpql = "select distinct d.idDisciplina, d.idDbExterno, d.nome from Periodo p ";
		jpql += "inner join p.disciplinas d inner join p.alunos a where a.idDbExterno=:id";

		try {
			Query query = em.createQuery(jpql);
			query.setParameter("id", studentRegistration);
			@SuppressWarnings("unchecked")
			List<Object[]> resultSet = query.getResultList();
			List<Disciplina> disciplines = new ArrayList<Disciplina>();
			for (Object[] obj : resultSet) {
				Disciplina d = new Disciplina();
				d.setIdDisciplina((Long) obj[0]);
				d.setIdDbExterno((Long) obj[1]);
				d.setNome((String) obj[2]);
				disciplines.add(d);
			}
			StudentDisciplines studentDisciplines = new StudentDisciplines();
			studentDisciplines.setDisciplinas(disciplines);
			return studentDisciplines;
		} catch (Exception e) {
			throw new WebApplicationException(Status.NOT_FOUND);
		} finally {
			em.close();
		}
	}
}
