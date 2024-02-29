package vista;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;

import modelo.entidad.Articulo;
import modelo.entidad.ListaArticulos;

/**
 * Clase Main que transforma un objeto en un fichero
 * de formato XML
 */
public class Main {
	
	
	public static void main(String[] args) {
		
		JAXBContext contexto;
		
		try {
			
			contexto = JAXBContext.newInstance(Articulo.class);
			contexto = JAXBContext.newInstance(ListaArticulos.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			List<Articulo> listaArticulos = new ArrayList<>();
			Articulo a1 = new Articulo(1,"Mesa", "Con cuatro patas", 13.0, 250.0);
			Articulo a2 = new Articulo(1,"Silla", "Estilo moderno", 16.0, 65.0);
			Articulo a3 = new Articulo(1,"Lámpara", "Con luz cálida", 40.0, 46.0);
			listaArticulos.add(a1);
			listaArticulos.add(a2);
			listaArticulos.add(a3);
			
			//Clase con las anotaciones pertienentes para que JAXB lea el Array
			ListaArticulos lA= new ListaArticulos();
			lA.setArticulos(listaArticulos);
							
			
			m.marshal(lA, System.out);
			
			m.marshal(lA, new File("articulos.xml"));
			
		} catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
