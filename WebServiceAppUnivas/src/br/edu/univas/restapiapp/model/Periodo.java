package br.edu.univas.restapiapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "periodo")
@XmlRootElement
public class Periodo {

	@Id
	@SequenceGenerator(name = "id_periodo", sequenceName = "seq_id_periodo", allocationSize = 1)
	@GeneratedValue(generator = "id_periodo", strategy = GenerationType.IDENTITY)
	@Column(name = "id_periodo", nullable = false)
	@XmlElement(name = "id")
	private Long idPeriodo;

	@XmlElement
	private Integer numero;

	@Temporal(TemporalType.DATE)
	@XmlElement
	private Date ano;

	@OneToMany
	@JoinColumn(name = "id_periodo")
	private List<Aluno> alunos;

	@OneToMany
	@JoinColumn(name = "id_periodo")
	private List<Disciplina> disciplinas;

	public Long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPeriodo == null) ? 0 : idPeriodo.hashCode());
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
		Periodo other = (Periodo) obj;
		if (idPeriodo == null) {
			if (other.idPeriodo != null)
				return false;
		} else if (!idPeriodo.equals(other.idPeriodo))
			return false;
		return true;
	}

}
