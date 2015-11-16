package br.edu.univas.restapiappunivas.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import br.edu.univas.restapiappunivas.entities.StudentEvent;
import br.edu.univas.restapiappunivas.entities.StudentEvents;
import br.edu.univas.restapiappunivas.model.EventType;
import br.edu.univas.restapiappunivas.util.JpaUtil;

public class StudentEventsCtrl {

	@SuppressWarnings("unchecked")
	public StudentEvents getEventsByStudentRegistration(Long studentRegistration) {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "select distinct e.idEvent, e.effectiveDate, e.value, e.note,";
		jpql += " e.description, e.eventType, d.idDiscipline, d.idExternal from Discipline d ";
		jpql += " right outer join d.events e right outer join e.student a where a.registration = :registration ";

		try {
			Query query = em.createQuery(jpql);
			query.setParameter("registration", studentRegistration);

			List<Object[]> resultSet = query.getResultList();
			List<StudentEvent> studentEvents = new ArrayList<StudentEvent>();

			for (Object[] obj : resultSet) {
				StudentEvent ae = new StudentEvent();
				ae.setIdEvento((Long) obj[0]);
				ae.setDataEfetiva((Date) obj[1]);
				ae.setValor((int) obj[2]);
				ae.setNota((int) obj[3]);
				ae.setDescricao((String) obj[4]);
				ae.setTipoEvento((EventType) obj[5]);
				ae.setIdDisciplina((Long) obj[6]);
				ae.setIdDbExterno((Long) obj[7]);

				studentEvents.add(ae);
			}

			StudentEvents students = new StudentEvents();
			students.setEventos(studentEvents);
			return students;
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		} finally {
			em.close();
		}
	}
}