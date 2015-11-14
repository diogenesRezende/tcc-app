package br.edu.univas.restapiapp.gcm;

import java.util.List;

import br.edu.univas.restapiapp.entities.EventsGCM;
import br.edu.univas.restapiapp.entities.EventsUserGCM;

/**
 * Hello world!
 *
 */

public class EnviarMensagemGCM {

	private static String API_KEY_GCM = "AIzaSyC58w1R-0DzfpTzZx3e4WUKSXwE_VoDvqU";

	public void sendMessageGCM(List<EventsUserGCM> eventsGCM) {

		System.out.println("Enviando para o GCM!");

		for (EventsUserGCM eventGCM : eventsGCM) {

			// new Thread() {

			// public void run() {
			ContentMenssageGCM content = createContent(eventGCM);

			if (!content.equals(null)) {
				POST2GCM.post(API_KEY_GCM, content);
			} else {
				System.out.println("Nenhum usuario registrado!");
			}
			// }

			// }.start();

		}
	}

	private ContentMenssageGCM createContent(EventsUserGCM eventGCM) {

		ContentMenssageGCM c = new ContentMenssageGCM();

		// for (Usuario usuario : usuarios) {
		// if (usuario.getIdGCM() == null) {
		// System.out.println("Usuario -" + usuario.getUsername()
		// + " não possui id do gcm cadastrado");
		// } else {
		// c.addRegId(usuario.getIdGCM());
		// System.out.println("Usuario - " + usuario.getUsername()
		// + " adicionada ao lote de envio!");
		// }
		//
		// }
		// if (c.getRegistration_ids().size() == 0) {
		// return null;
		// } else {
		EventsGCM ev = new EventsGCM();

		ev.setValor(eventGCM.getValor());
		ev.setNota(eventGCM.getNota());
		ev.setTipoEvento(eventGCM.getTipoEvento());
		ev.setId_evento(eventGCM.getId_evento());
		ev.setData(eventGCM.getData());
		ev.setId_disciplina(eventGCM.getId_disciplina());
		ev.setDescricao(eventGCM.getDescricao());
		ev.setId_externo_disciplina(eventGCM.getId_externo_disciplina());

		c.createData("Univas APP", ev);
		// c.addRegId("APA91bFQnhOkVyLbkbuqJJ4R7F6AvzT_YgzyG_54WiGoSRXaF05iBHq3pvbhfOpu4lUxRbDVfzYTRR5YEV2BIAT6uX_HYNUCbN1lltBWYCPQjiKb2UkLVlYIytKn2XGCG9k6oRJGIS8x");
		// c.addRegId("APA91bG1xfKvvn7RtfQrQmfKj4mf-Wtw25dTvzeZqmd0MPMqZzXXDu1uIezP_-wqz6VkAjEQo8odr3mQHUjnU_HGaDIBwphEhs6xPHEqHexDPHqYTMXQYn07LsDtoNpKKy_Y0153vy4x");
		System.out.println(eventGCM.getIdGCM());
		c.addRegId(eventGCM.getIdGCM());
		return c;
		// }
	}
}
