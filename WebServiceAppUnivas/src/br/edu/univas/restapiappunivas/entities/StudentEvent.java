package br.edu.univas.restapiappunivas.entities;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import br.edu.univas.restapiappunivas.model.EventType;

public class StudentEvent {

	@XmlElement(name = "id_evento")
	private Long idEvento;

	@XmlElement(name = "data")
	private Date dataEfetiva;

	@XmlElement(name = "valor")
	private int valor;

	@XmlElement(name = "nota")
	private int nota;

	@XmlElement(name = "descricao")
	private String descricao;

	@XmlElement(name = "tipo_evento")
	private EventType tipoEvento;

	@XmlElement(name = "id_disciplina")
	private Long idDisciplina;

	@XmlElement(name = "id_externo_disciplina")
	private Long idDbExterno;

	@XmlElement(name = "id_aluno")
	private Long idAluno;

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
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

	public EventType getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(EventType tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

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

}
