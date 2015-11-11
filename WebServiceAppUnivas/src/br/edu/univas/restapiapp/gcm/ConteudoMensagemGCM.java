package br.edu.univas.restapiapp.gcm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.edu.univas.restapiapp.model.Evento;

public class ConteudoMensagemGCM implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> registration_ids;
	private Map<String, Evento> data;

	public void addRegId(String regId) {
		if (registration_ids == null)
			registration_ids = new LinkedList<String>();
		registration_ids.add(regId);
	}

	public void createData(String title, Evento evento) {
		if (data == null)
			data = new HashMap<String, Evento>();

		data.put("evento", evento);

	}

	public List<String> getRegistration_ids() {
		return registration_ids;
	}

	public void setRegistration_ids(List<String> registration_ids) {
		this.registration_ids = registration_ids;
	}

	public Map<String, Evento> getData() {
		return data;
	}

	public void setData(Map<String, Evento> data) {
		this.data = data;
	}

	
}
