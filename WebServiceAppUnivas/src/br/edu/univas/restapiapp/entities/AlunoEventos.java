package br.edu.univas.restapiapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AlunoEventos {

	@XmlElement
	private List<AlunoEvento> eventos = new ArrayList<AlunoEvento>();

	public List<AlunoEvento> getEventos() {
		return eventos;
	}

	public void setEventos(List<AlunoEvento> eventos) {
		this.eventos = eventos;
	}

}
