package br.edu.univas.restapiappunivas.updates;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.univas.restapiappunivas.entities.EventsUserGCM;
import br.edu.univas.restapiappunivas.gcm.SendMenssageGCM;
import br.edu.univas.restapiappunivas.model.Atualizacao;
import br.edu.univas.restapiappunivas.model.TipoEvento;
import br.edu.univas.restapiappunivas.util.JpaUtil;



public class Updates {

	public Updates() {

	}

	public void start() {

		List<EventsUserGCM> eventsGcm = this.updatesEvents();
		if (eventsGcm.size() > 0) {
			SendMenssageGCM gcm = new SendMenssageGCM();
			gcm.sendMessageGCM(eventsGcm);
			System.out.println("Successfully sent to the GCM!");
		} else {
			System.out.println("Nothing to send to GCM!");
		}
		this.lastUpdate(new Date());
	}

	public List<EventsUserGCM> updatesEvents() {

		Date lastUpdate = this.searchLastSweep();

		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "select distinct ";
		jpql += " u.idGCM, e.valor, e.nota, e.tipoEvento, e.idEvento, ";
		jpql += "e.dataEfetiva, d.idDisciplina, e.descricao,  d.idDbExterno from Disciplina d ";
		jpql += " right outer join d.eventos e right outer join e.aluno a right outer join a.usuario u ";
		jpql += "where e.dataLancamento >= :ultimaAtualizacao";

		try {
			Query query = em.createQuery(jpql);
			query.setParameter("ultimaAtualizacao", lastUpdate);

			@SuppressWarnings("unchecked")
			List<Object[]> resultSet = query.getResultList();
			List<EventsUserGCM> userEvents = new ArrayList<EventsUserGCM>();

			for (Object[] obj : resultSet) {
				EventsUserGCM user = new EventsUserGCM();

				user.setIdGCM((String) obj[0]);
				user.setValor((int) obj[1]);
				user.setNota((int) obj[2]);
				user.setTipoEvento((TipoEvento) obj[3]);
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
		System.out.println("rodando buscaUltimaVarredura()");
		EntityManager em = JpaUtil.getEntityManager();
		try {
			String jpql = "from Atualizacao a order by a.data desc";
			TypedQuery<Atualizacao> query = em.createQuery(jpql,
					Atualizacao.class);
			Atualizacao atualizacao = query.getResultList().get(0);
			return atualizacao.getData();
		} catch (Exception e) {

			throw new RuntimeException();
		} finally {
			em.close();
		}
	}

	public void lastUpdate(Date now) {
		EntityManager em = JpaUtil.getEntityManager();
		Atualizacao update = em.find(Atualizacao.class, 1L);
		update.setData(now);
		em.getTransaction().begin();
		em.persist(update);
		em.getTransaction().commit();
		System.out.println("Atualizando ultima atualização para - " + now);
		em.close();
	}
}
