package br.edu.univas.restapiappunivas.model;

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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "periods")
@XmlRootElement
public class Period {

	@Id
	@SequenceGenerator(name = "id_period", sequenceName = "seq_id_period", allocationSize = 1)
	@GeneratedValue(generator = "id_period", strategy = GenerationType.IDENTITY)
	@Column(name = "id_period", nullable = false)
	private Long idPeriod;

	private Integer number;

	@Temporal(TemporalType.DATE)
	private Date year;

	@OneToMany
	@JoinColumn(name = "id_period")
	private List<Student> students;

	@OneToMany
	@JoinColumn(name = "id_period")
	private List<Discipline> disciplines;

	public Long getIdPeriod() {
		return idPeriod;
	}

	public void setIdPeriod(Long idPeriod) {
		this.idPeriod = idPeriod;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPeriod == null) ? 0 : idPeriod.hashCode());
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
		Period other = (Period) obj;
		if (idPeriod == null) {
			if (other.idPeriod != null)
				return false;
		} else if (!idPeriod.equals(other.idPeriod))
			return false;
		return true;
	}

}
