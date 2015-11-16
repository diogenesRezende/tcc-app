package br.edu.univas.restapiappunivas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "disciplines")
public class Discipline {

	@Id
	@SequenceGenerator(name = "id_discipline", sequenceName = "seq_id_discipline", allocationSize = 1)
	@GeneratedValue(generator = "id_discipline", strategy = GenerationType.IDENTITY)
	@Column(name = "id_discipline", nullable = false)
	private Long idDiscipline;

	@Column(name = "id_external", nullable = false)
	private Long idExternal;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 100)
	private String description;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_discpline")
	private List<Event> events;

	public Long getIdDiscipline() {
		return idDiscipline;
	}

	public void setIdDiscipline(Long idDiscipline) {
		this.idDiscipline = idDiscipline;
	}

	public Long getIdExternal() {
		return idExternal;
	}

	public void setIdExternal(Long idExternal) {
		this.idExternal = idExternal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDiscipline == null) ? 0 : idDiscipline.hashCode());
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
		Discipline other = (Discipline) obj;
		if (idDiscipline == null) {
			if (other.idDiscipline != null)
				return false;
		} else if (!idDiscipline.equals(other.idDiscipline))
			return false;
		return true;
	}

}
