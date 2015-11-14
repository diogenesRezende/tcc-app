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
	
	public static void post(String apiKey, ContentMenssageGCM content) {

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

//public class POST2GCM {
//	public static void main(String args[]) {
//
//		new Thread() {
//
//			public void run() {
//
//				try {
//					// Please add here your project API key:
//					// "Key for browser apps (with referers)".
//					// If you added
//					// "API key Key for server apps (with IP locking)" or
//					// "Key for Android apps (with certificates)" here
//					// then you may get error responses.
//					Sender sender = new Sender(
//							"AIzaSyC58w1R-0DzfpTzZx3e4WUKSXwE_VoDvqU");
//
//					HashMap<String, String> values = new HashMap<String, String>();
//						values.put("Nome", "Diógenes");
//						values.put("Nome1", "Diógenes1");
//						values.put("Nome2", "Diógenes2");
//						
//					// use this to send message with payload data
//					Message message = new Message.Builder()
//							.collapseKey("message").timeToLive(3)
//							.delayWhileIdle(true).addData("nada", "nada")
//							.setData(values)							
////							.addData("tudo", "tudo").addData("tudo1", "tudo1")
//							.build();
//
//					// Use this code to send notification message to a single
//					// device
//					Result result = sender
//							.send(message,
//									"APA91bG1xfKvvn7RtfQrQmfKj4mf-Wtw25dTvzeZqmd0MPMqZzXXDu1uIezP_-wqz6VkAjEQo8odr3mQHUjnU_HGaDIBwphEhs6xPHEqHexDPHqYTMXQYn07LsDtoNpKKy_Y0153vy4x",
//									1);
//					System.out.println("Message Result: " + result.toString());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}.start();
//	}
//}



