package br.edu.univas.restapiapp.gcm;

import java.util.List;

import br.edu.univas.restapiapp.model.Usuario;

/**
 * Hello world!
 *
 */

public class EnviarMensagemGCM {
	public EnviarMensagemGCM(List<Usuario> usuarios) {
		System.out.println("Enviando para o GCM!");

		String apiKey = "AIzaSyC58w1R-0DzfpTzZx3e4WUKSXwE_VoDvqU";
		ConteudoMensagemGCM content = createContent(usuarios);

		if (!content.equals(null)) {
			POST2GCM.post(apiKey, content);
		} else {
			System.out.println("Nenhum usuario registrado!");
		}
	}

	private ConteudoMensagemGCM createContent(List<Usuario> usuarios) {

		ConteudoMensagemGCM c = new ConteudoMensagemGCM();

		for (Usuario usuario : usuarios) {
			if (usuario.getIdGCM() == null) {
				System.out.println("Usuario -" + usuario.getUsername()
						+ " não possui id do gcm cadastrado");
			} else {
				c.addRegId(usuario.getIdGCM());
				System.out.println("Usuario - " + usuario.getUsername()
						+ " adicionada ao lote de envio!");
			}

		}
		if (c.getRegistration_ids().size() == 0) {
			return null;
		} else {
			c.createData("Univas APP", "Novas informações!");
			// c.addRegId("APA91bFQnhOkVyLbkbuqJJ4R7F6AvzT_YgzyG_54WiGoSRXaF05iBHq3pvbhfOpu4lUxRbDVfzYTRR5YEV2BIAT6uX_HYNUCbN1lltBWYCPQjiKb2UkLVlYIytKn2XGCG9k6oRJGIS8x");
			// c.addRegId("APA91bG1xfKvvn7RtfQrQmfKj4mf-Wtw25dTvzeZqmd0MPMqZzXXDu1uIezP_-wqz6VkAjEQo8odr3mQHUjnU_HGaDIBwphEhs6xPHEqHexDPHqYTMXQYn07LsDtoNpKKy_Y0153vy4x");
			return c;
		}
	}
}
