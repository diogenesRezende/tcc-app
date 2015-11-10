package br.edu.univas.restapiapp.gcm;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class POST2GCM {

	public static void post(String apiKey, ConteudoMensagemGCM content) {

		/* String projectNumberOfUnivasAppGcm = "49731260058"; */
		try {

			// 1. URL para envio das mensagens
			URL url = new URL("https://android.googleapis.com/gcm/send");

			// 2. Abre a conexão com o serviços a google
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// 3. Especifica o metodo de envio
			conn.setRequestMethod("POST");

			// 4. Faz set dos headers necessários para a conexão
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "key=" + apiKey);

			conn.setDoOutput(true);

			// 5. Add JSON data into POST request body

			// `5.1 Use Jackson object mapper to convert Contnet object into
			// JSON
			ObjectMapper mapper = new ObjectMapper();

			// 5.2 Get connection output stream
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());

			// 5.3 Copy Content "JSON" into
			mapper.writeValue(wr, content);

			// 5.4 Send the request
			wr.flush();

			// 5.5 close
			wr.close();

			// 6. Get the response
			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// 7. Print result
			System.out.println(response.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
