package br.edu.univas.restapiapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "eventos")
public class Evento {

	@Id
	@SequenceGenerator(name = "id_evento", sequenceName = "seq_id_evento", allocationSize = 1)
	@GeneratedValue(generator = "id_evento", strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento", nullable = false)
	@XmlElement(name = "id")
	private Long idEvento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_lancamento", nullable = false)
	@XmlElement
	private Date dataLancamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_efetiva", nullable = false)
	@XmlElement
	private Date dataEfetiva;

	@XmlElement
	private int valor;

	@XmlElement
	@Column(nullable = true)
	private int nota;

	@XmlElement
	@Column(length = 100)
	private String descricao;

	@Column(name = "tipo_evento", nullable = false)
	@Enumerated(EnumType.STRING)
	@XmlElement
	private TipoEvento tipoEvento;

	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Date getDataEfetiva() {
		return dataEfetiva;
	}

	public void setDataEfetiva(Date dataEfetiva) {
		this.dataEfetiva = dataEfetiva;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idEvento == null) ? 0 : idEvento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (idEvento == null) {
			if (other.idEvento != null)
				return false;
		} else if (!idEvento.equals(other.idEvento))
			return false;
		return true;
	}
}
