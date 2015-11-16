package br.edu.univas.restapiappunivas.updates;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.univas.restapiappunivas.entities.EventsUserGCM;
import br.edu.univas.restapiappunivas.gcm.SendMenssageGCM;
import br.edu.univas.restapiappunivas.model.EventType;
import br.edu.univas.restapiappunivas.model.Update;
import br.edu.univas.restapiappunivas.util.JpaUtil;

public class Updates {

	public Updates() {

	}

	public void start() {

		List<EventsUserGCM> eventsGcm = this.updatesEvents();
		if (eventsGcm.size() > 0) {
			SendMenssageGCM gcm = new SendMenssageGCM();
			gcm.sendMessageGCM(eventsGcm);
			System.out.println("====|| Successfully sent to the GCM! ||=====");
		} else {
			System.out.println("=====|| Nothing to send to GCM! ||=====");
		}
		this.lastUpdate(new Date());
	}

	public List<EventsUserGCM> updatesEvents() {

		Date lastUpdate = this.searchLastSweep();

		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "select distinct ";
		jpql += " u.idGCM, e.value, e.note, e.eventType, e.idEvent, ";
		jpql += "e.effectiveDate, d.idDiscipline, e.description,  d.idExternal from Discipline d ";
		jpql += " right outer join d.events e right outer join e.student a right outer join a.user u ";
		jpql += "where e.releaseDate >= :lastUpdate";

		try {
			Query query = em.createQuery(jpql);
			query.setParameter("lastUpdate", lastUpdate);

			@SuppressWarnings("unchecked")
			List<Object[]> resultSet = query.getResultList();
			List<EventsUserGCM> userEvents = new ArrayList<EventsUserGCM>();

			for (Object[] obj : resultSet) {
				EventsUserGCM user = new EventsUserGCM();

				user.setIdGCM((String) obj[0]);
				user.setValor((int) obj[1]);
				user.setNota((int) obj[2]);
				user.setTipoEvento((EventType) obj[3]);
				user.setId_evento((Long) obj[4]);
				user.setData((Date) obj[5]);
				user.setId_disciplina((Long) obj[6]);
				user.setDescricao((String) obj[7]);
				user.setId_externo_disciplina((Long) obj[8]);
				userEvents.add(user);
			}
			return userEvents;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			em.close();
		}
	}

	private Date searchLastSweep() {
		System.out.println("=====|| Start search for new events ||=====");
		EntityManager em = JpaUtil.getEntityManager();
		try {
			String jpql = "from Update a order by a.lastUpdate desc";
			TypedQuery<Update> query = em.createQuery(jpql, Update.class);
			Update update = query.getResultList().get(0);
			return update.getLastUpdate();
		} catch (Exception e) {

			throw new RuntimeException();
		} finally {
			em.close();
		}
	}

	public void lastUpdate(Date now) {
		System.out.println("Updating lastUpdate to = " + now);
		EntityManager em = JpaUtil.getEntityManager();
		Update update = em.find(Update.class, 1L);
		update.setLastUpdate(now);
		em.getTransaction().begin();
		em.persist(update);
		em.getTransaction().commit();
		em.close();
	}
}
