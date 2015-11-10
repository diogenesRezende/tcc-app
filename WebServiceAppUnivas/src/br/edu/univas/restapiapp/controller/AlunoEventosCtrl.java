package br.edu.univas.restapiapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import br.edu.univas.restapiapp.entities.AlunoEvento;
import br.edu.univas.restapiapp.entities.AlunoEventos;
import br.edu.univas.restapiapp.model.TipoEvento;
import br.edu.univas.restapiapp.util.JpaUtil;

public class AlunoEventosCtrl {

	@SuppressWarnings("unchecked")
	public AlunoEventos getEventosByMatricula(Long idAluno) {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "select distinct e.idEvento, e.dataEfetiva, e.valor, e.nota,";
		jpql += " e.descricao, e.tipoEvento, d.idDisciplina, d.idDbExterno from Disciplina d ";
		jpql += " right outer join d.eventos e right outer join e.aluno a where a.idDbExterno = :id ";

		/*
		 * select e.*,d.id_externo from eventos e left outer join disciplinas d
		 * on d.id_disciplina=e.id_discplina where e.id_aluno=(select id_aluno
		 * from alunos where id_externo = 98004096)
		 */

		try {
			Query query = em.createQuery(jpql);
			query.setParameter("id", idAluno);

			List<Object[]> resultSet = query.getResultList();
			List<AlunoEvento> alunoEventos = new ArrayList<AlunoEvento>();

			for (Object[] obj : resultSet) {
				AlunoEvento ae = new AlunoEvento();
				ae.setIdEvento((Long) obj[0]);
				ae.setDataEfetiva((Date) obj[1]);
				ae.setValor((int) obj[2]);
				ae.setNota((int) obj[3]);
				ae.setDescricao((String) obj[4]);
				ae.setTipoEvento((TipoEvento) obj[5]);
				ae.setIdDisciplina((Long) obj[6]);
				ae.setIdDbExterno((Long) obj[7]);
				// ae.setIdAluno((Long) obj[8]);

				alunoEventos.add(ae);
			}

			AlunoEventos alunos = new AlunoEventos();
			alunos.setEventos(alunoEventos);
			// alunos.setEventos(aluno);
			return alunos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		} finally {
			em.close();
		}
	}
}
