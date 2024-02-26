package vista;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;

import modelo.entidad.Articulo;
import modelo.entidad.ListaArticulos;


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
			Articulo a1 = new Articulo(1,"Boligrafo", "Azul", 130.0, 1.0);
			Articulo a2 = new Articulo(2,"Lapiz", "M2", 160.0, 0.50);
			Articulo a3 = new Articulo(3,"Goma", "Milan", 400.0, 0.70);
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
