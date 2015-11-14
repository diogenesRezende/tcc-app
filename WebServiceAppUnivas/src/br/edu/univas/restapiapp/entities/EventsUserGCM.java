package br.edu.univas.restapiapp.entities;

import java.util.Date;

import br.edu.univas.restapiapp.model.TipoEvento;

public class EventsUserGCM {

	private String idGCM;

	private int valor;

	private int nota;

	private TipoEvento tipoEvento;

	private Long id_evento;

	private Date data;

	private Long id_disciplina;

	private String descricao;

	private Long id_externo_disciplina;

	public String getIdGCM() {
		return idGCM;
	}

	public void setIdGCM(String idGCM) {
		this.idGCM = idGCM;
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

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Long getId_evento() {
		return id_evento;
	}

	public void setId_evento(Long id_evento) {
		this.id_evento = id_evento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(Long id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId_externo_disciplina() {
		return id_externo_disciplina;
	}

	public void setId_externo_disciplina(Long id_externo_disciplina) {
		this.id_externo_disciplina = id_externo_disciplina;
	}

	
}
