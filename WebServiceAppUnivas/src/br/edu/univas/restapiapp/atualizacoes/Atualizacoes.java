package br.edu.univas.restapiapp.atualizacoes;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.univas.restapiapp.model.Atualizacao;
import br.edu.univas.restapiapp.model.Usuario;
import br.edu.univas.restapiapp.util.JpaUtil;

public class Atualizacoes {

	public Atualizacoes() {

	}

	public List<Usuario> buscaAtualizaoEventos() {
		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("rodando buscaAtualizaoEventos()");
		System.out.println("=========================================");
		System.out.println("=========================================");
		/* Faz a busca da ultima atualização */
		Date ultimaAtualizacao = this.buscaUltimaVarredura();

		EntityManager em = JpaUtil.getEntityManager();

		try {
			String jpql = "select distinct u from Aluno a inner join a.eventos e inner join a.usuario u where e.dataLancamento >= :ultimaAtualizacao";
			TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);

			query.setParameter("ultimaAtualizacao", ultimaAtualizacao);
			List<Usuario> eventos = query.getResultList();
			return eventos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			em.close();
		}
	}

	private Date buscaUltimaVarredura() {
		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("rodando buscaUltimaVarredura()");
		System.out.println("=========================================");
		System.out.println("=========================================");
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

	public void updateTimeStampUltimaAtualização(Date agora) {
		EntityManager em = JpaUtil.getEntityManager();
		Atualizacao at = em.find(Atualizacao.class, 1L);
		at.setData(agora);
		em.getTransaction().begin();
		em.persist(at);
		em.getTransaction().commit();
		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("Atualizando ultima atualização para -" + agora);
		System.out.println("=========================================");
		System.out.println("=========================================");
	}
}
