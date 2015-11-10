package br.edu.univas.restapiapp.atualizacoes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.edu.univas.restapiapp.gcm.EnviarMensagemGCM;
import br.edu.univas.restapiapp.model.Usuario;

public class ListenerAtualizacoesGCM implements ServletContextListener {

	public static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd_HH:mm:ss");

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		System.out.println("*********ServletContextListener Iniciado*********");

		int delay = 1000;
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				Date agora = new Date();

				System.out.println("=========================================");
				System.out.println("=========================================");
				System.out.println("Este rotina roda a cada 6 segundos..."
						+ sdf.format(agora));
				System.out.println("=========================================");
				System.out.println("=========================================");
				try {
					Atualizacoes at = new Atualizacoes();
					List<Usuario> usuarios = at.buscaAtualizaoEventos();
					if (usuarios.size() > 0) {
						@SuppressWarnings("unused")
						EnviarMensagemGCM gcm = new EnviarMensagemGCM(usuarios);
						System.out
								.println("=========================================");
						System.out
								.println("=========================================");
						System.out.println("Simulado com sucesso  ao GCM!");
						System.out
								.println("=========================================");
						System.out
								.println("=========================================");
					} else {
						System.out.println("Nada a enviar ao GCM!");
					}

					at.updateTimeStampUltimaAtualização(agora);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("=========================================");
				System.out.println("=========================================");
				System.out.println("\n\n");
			}
		}, delay, 5000);
		servletContext.setAttribute("timer", timer);
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		Timer timer = (Timer) servletContext.getAttribute("timer");

		if (timer != null)
			timer.cancel();

		servletContext.removeAttribute("timer");
		System.out.println("ServletContextListener Finalizado");

	}

}
