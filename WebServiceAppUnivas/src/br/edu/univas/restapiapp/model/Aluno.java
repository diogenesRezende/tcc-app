package br.edu.univas.restapiapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "alunos")
public class Aluno {

	@Id
	@SequenceGenerator(name = "id_aluno", sequenceName = "seq_id_aluno", allocationSize = 1)
	@GeneratedValue(generator = "id_aluno", strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno", nullable = false)
	@XmlElement(name = "id")
	private Long idAluno;

	@Column(name = "id_externo", nullable = false)
	@XmlElement(name = "id_externo")
	private Long idDbExterno;

	@Column(length = 100, nullable = false)
	@XmlElement(name="nome")
	private String nome;

	@Column(length = 100, nullable = false)
	@XmlElement(name="email")
	private String email;

	@OneToMany(mappedBy="aluno", fetch = FetchType.EAGER)
	private List<Evento> eventos;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Long getIdDbExterno() {
		return idDbExterno;
	}

	public void setIdDbExterno(Long idDbExterno) {
		this.idDbExterno = idDbExterno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
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
		Aluno other = (Aluno) obj;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		return true;
	}

}
