package br.edu.univas.restapiappunivas.resources;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import br.edu.univas.restapiappunivas.entities.StudentDisciplines;
import br.edu.univas.restapiappunivas.entities.StudentEvents;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class StudentsProvider implements ContextResolver<JAXBContext> {
	private JAXBContext context;

	@SuppressWarnings("rawtypes")
	private Class[] types = { StudentDisciplines.class, StudentEvents.class };

	public StudentsProvider() throws Exception {
		this.context = new JSONJAXBContext(JSONConfiguration.mapped()
				.arrays("student").build(), types);
	}

	@SuppressWarnings("rawtypes")
	public JAXBContext getContext(Class objectType) {
		for (Class type : types) {
			if (type == objectType) {
				return context;
			}
		}
		return null;
	}
}