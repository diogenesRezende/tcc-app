package br.edu.univas.restapiappunivas.gcm;

import java.util.List;

import br.edu.univas.restapiappunivas.entities.EventsGCM;
import br.edu.univas.restapiappunivas.entities.EventsUserGCM;

public class SendMenssageGCM {

	private static String API_KEY_GCM = "AIzaSyC58w1R-0DzfpTzZx3e4WUKSXwE_VoDvqU";

	public void sendMessageGCM(List<EventsUserGCM> eventsGCM) {

		System.out.println("Enviando para o GCM!");

		for (EventsUserGCM eventGCM : eventsGCM) {

			ContentMenssageGCM content = createContent(eventGCM);

			if (!content.getRegistration_ids().equals(null)) {
				PostToGCM.post(API_KEY_GCM, content);
			} else {
				System.out.println("Nenhum usuario registrado!");
			}
		}
	}

	private ContentMenssageGCM createContent(EventsUserGCM eventGCM) {

		ContentMenssageGCM c = new ContentMenssageGCM();

		EventsGCM ev = new EventsGCM();

		ev.setValor(eventGCM.getValor());
		ev.setNota(eventGCM.getNota());
		ev.setTipoEvento(eventGCM.getTipoEvento());
		ev.setId_evento(eventGCM.getId_evento());
		ev.setData(eventGCM.getData());
		ev.setId_disciplina(eventGCM.getId_disciplina());
		ev.setDescricao(eventGCM.getDescricao());
		ev.setId_externo_disciplina(eventGCM.getId_externo_disciplina());

		c.createData(ev);
		System.out.println(eventGCM.getIdGCM());
		c.addRegId(eventGCM.getIdGCM());
		return c;
	}
}
