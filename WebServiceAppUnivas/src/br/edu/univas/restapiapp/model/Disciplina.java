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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "disciplinas")
public class Disciplina {

	@Id
	@SequenceGenerator(name = "id_disciplina", sequenceName = "seq_id_disciplina", allocationSize = 1)
	@GeneratedValue(generator = "id_disciplina", strategy = GenerationType.IDENTITY)
	@Column(name = "id_disciplina", nullable = false)
	@XmlElement(name = "id")
	private Long idDisciplina;

	@Column(name = "id_externo", nullable = false)
	@XmlElement
	private Long idDbExterno;

	@Column(length = 100, nullable = false)
	@XmlElement
	private String nome;

	@Column(length = 100)
	@XmlElement
	private String descricao;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_discplina")
	private List<Evento> eventos;

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		result = prime * result
				+ ((idDisciplina == null) ? 0 : idDisciplina.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (idDisciplina == null) {
			if (other.idDisciplina != null)
				return false;
		} else if (!idDisciplina.equals(other.idDisciplina))
			return false;
		return true;
	}

}
