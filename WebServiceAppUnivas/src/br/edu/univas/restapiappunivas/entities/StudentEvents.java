package br.edu.univas.restapiappunivas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentEvents {

	@XmlElement
	private List<StudentEvent> eventos = new ArrayList<StudentEvent>();

	public List<StudentEvent> getEventos() {
		return eventos;
	}

	public void setEventos(List<StudentEvent> eventos) {
		this.eventos = eventos;
	}

}
