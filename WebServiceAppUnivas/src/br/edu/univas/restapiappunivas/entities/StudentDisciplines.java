package br.edu.univas.restapiappunivas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.edu.univas.restapiappunivas.model.Discipline;

@XmlRootElement
public class StudentDisciplines {

	@XmlElement
	private List<Discipline> disciplinas = new ArrayList<Discipline>();

	public List<Discipline> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Discipline> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
