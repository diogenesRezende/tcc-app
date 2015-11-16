package br.edu.univas.restapiappunivas.updates;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class UpdatesGCMListener implements ServletContextListener {

	public static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd_HH:mm:ss");

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		System.out.println("*********|| ServletContextListener Started! ||*********");

		int delay = 1000;
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				Date agora = new Date();
				System.out.println("Started every 6 seconds ..."
						+ sdf.format(agora));
				try {
					Updates updates = new Updates();
					updates.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("=========================================");
				System.out.println("\n\n");
			}
		}, delay, 30000);
		servletContext.setAttribute("timer", timer);
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		Timer timer = (Timer) servletContext.getAttribute("timer");

		if (timer != null)
			timer.cancel();

		servletContext.removeAttribute("timer");
		System.out.println("*********|| ServletContextListener Finished! ||*********");

	}

}
