package br.edu.univas.restapiapp.resources;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import br.edu.univas.restapiapp.entities.AlunoDisciplinas;
import br.edu.univas.restapiapp.entities.AlunoEventos;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

//http://tugdualgrall.blogspot.com.br/2011/09/jax-rs-jersey-and-single-element-arrays.html

@Provider
public class AlunosProvider implements ContextResolver<JAXBContext> {
	private JAXBContext context;

	@SuppressWarnings("rawtypes")
	private Class[] types = { AlunoDisciplinas.class, AlunoEventos.class };

	public AlunosProvider() throws Exception {
		this.context = new JSONJAXBContext(JSONConfiguration.mapped()
				.arrays("aluno").build(), types);
	}

	@SuppressWarnings("rawtypes")
	public JAXBContext getContext( Class objectType) {
		for (Class type : types) {
			if (type == objectType) {
				return context;
			}
		}
		return null;
	}
}

// http://stackoverflow.com/questions/1145476/how-do-i-marshal-nested-lists-as-json-using-jersey-i-get-an-array-of-nulls-or-a
// este não funcionou

// @Provider
// public class AnuncioProvider implements ContextResolver<JAXBContext> {
// private JAXBContext context;
// private Set<Class<?>> types;
//
// // Only parent classes are required here. Nested classes are implicit.
// protected Class<?>[] classTypes = new Class[] { Anuncios.class, Anuncio.class
// };
//
// protected Set<String> jsonArray = new HashSet<String>(2) {
// {
// add("anuncios");
// add("anuncio");
// }
// };
//
// public AnuncioProvider() throws Exception {
// Map<String, Object> props = new HashMap<String, Object>();
// props.put(JSONJAXBContext.JSON_NOTATION,
// JSONJAXBContext.JSONNotation.MAPPED);
// props.put(JSONJAXBContext.JSON_ROOT_UNWRAPPING, Boolean.TRUE);
// props.put(JSONJAXBContext.JSON_ARRAYS, jsonArray);
// this.types = new HashSet<Class<?>>(Arrays.asList(classTypes));
// this.context = new JSONJAXBContext(classTypes, props);
// }
//
// public JAXBContext getContext(Class<?> objectType) {
// return (types.contains(objectType)) ? context : null;
// }
// }
// http://stackoverflow.com/questions/13575280/jersey-json-array-with-1-element-is-serialized-as-object
// https://github.com/jasonray/jersey-starterkit/wiki/Serializing-a-POJO-to-xml-or-json-using-JAXB
