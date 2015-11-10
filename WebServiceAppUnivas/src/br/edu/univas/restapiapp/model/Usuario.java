package br.edu.univas.restapiapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario {

	@Id
	@SequenceGenerator(name = "id_usuario", sequenceName = "seq_id_usuario", allocationSize = 1)
	@GeneratedValue(generator = "id_usuario", strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false)
	@XmlElement(name = "id_usuario")
	private Long idUsuario;

	@Column(length = 100, nullable = false)
	@XmlElement
	private String username;

	@Column(length = 100, nullable = false)
	@XmlElement
	private String password;

	@Column(length = 200)
	@XmlElement
	private String idGCM;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdGCM() {
		return idGCM;
	}

	public void setIdGCM(String idGCM) {
		this.idGCM = idGCM;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

}
