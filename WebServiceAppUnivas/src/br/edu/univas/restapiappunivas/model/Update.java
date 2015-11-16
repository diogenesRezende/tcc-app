package br.edu.univas.restapiappunivas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "updates")
public class Update {

	@Id
	@SequenceGenerator(name = "id_update", sequenceName = "seq_id_update", allocationSize = 1)
	@GeneratedValue(generator = "id_update", strategy = GenerationType.IDENTITY)
	@Column(name = "id_update", nullable = false)
	private Long idUpdate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update", nullable = false)
	private Date lastUpdate;

	public Long getIdUpdate() {
		return idUpdate;
	}

	public void setIdUpdate(Long idUpdate) {
		this.idUpdate = idUpdate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idUpdate == null) ? 0 : idUpdate.hashCode());
		result = prime * result
				+ ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
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
		Update other = (Update) obj;
		if (idUpdate == null) {
			if (other.idUpdate != null)
				return false;
		} else if (!idUpdate.equals(other.idUpdate))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}

}
