package br.edu.univas.restapiappunivas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import br.edu.univas.restapiappunivas.entities.StudentDisciplines;
import br.edu.univas.restapiappunivas.model.Discipline;
import br.edu.univas.restapiappunivas.util.JpaUtil;

public class StudentDisciplinesCtrl {

	public StudentDisciplines getDisciplinesByStudentRegistration(
			Long studentRegistration) {
		EntityManager em = JpaUtil.getEntityManager();

		String jpql = "select distinct d.idDiscipline, d.idExternal, d.name from Period p ";
		jpql += "inner join p.disciplines d inner join p.students a where a.registration=:registration";

		try {
			Query query = em.createQuery(jpql);
			query.setParameter("registration", studentRegistration);
			@SuppressWarnings("unchecked")
			List<Object[]> resultSet = query.getResultList();
			List<Discipline> disciplines = new ArrayList<Discipline>();
			for (Object[] obj : resultSet) {
				Discipline d = new Discipline();
				d.setIdDiscipline((Long) obj[0]);
				d.setIdExternal((Long) obj[1]);
				d.setName((String) obj[2]);
				disciplines.add(d);
			}
			StudentDisciplines studentDisciplines = new StudentDisciplines();
			studentDisciplines.setDisciplinas(disciplines);
			return studentDisciplines;
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		} finally {
			em.close();
		}
	}
}
