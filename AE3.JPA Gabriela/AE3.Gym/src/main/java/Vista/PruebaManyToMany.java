package Vista;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entidades.Ficha;
import entidades.Ginnasio;
import entidades.Monitor;
import entidades.Socio;

public class PruebaManyToMany {

	private static EntityManager em;
	
public static void main(String[] args) {
	
	EntityManagerFactory factoria = Persistence.createEntityManagerFactory("ginnasio");
	em = factoria.createEntityManager();
	
	EntityTransaction et = em.getTransaction();
		//Creamos los objetos
	
	Ginnasio g = new Ginnasio(null, "Fullfitnes", "Calle Aquiles, 13", null, null);
	Ficha f = new Ficha(null, "Calle Juan Carlos, 13", 29,new Date(2021-9-21), null);
	
	Socio s1 = new Socio(null, "Juan", "Gonzales", null, null, null);
	Socio s2 = new Socio(null, "Marta", "Perez", null, null, null);
	Socio s3 = new Socio(null, "Lucia", "Gimenez", null, null, null);
		
	Monitor Carlos = new Monitor(null, "Carlos", "Herrera", "Calle 4 de Marzo, 3", null, null);
	Monitor Lorena = new Monitor(null, "Lorena", "Garcia", "Avenida Juan 23, 45", null, null);
				

		
		//Asignamos al socio 1  su lista de monitores
		List<Monitor> monitoresDeS1 = new ArrayList<Monitor>();
		monitoresDeS1.add(Carlos);		
		s1.setMonitor(monitoresDeS1);

		//Asignamos al socio 2  su lista de monitores
		List<Monitor> monitoresDeS2 = new ArrayList<Monitor>();
		monitoresDeS2.add(Carlos);
		monitoresDeS2.add(Lorena);		
		s2.setMonitor(monitoresDeS2);
		
		//Asignamos al socio 3  su lista de monitores
		List<Monitor> monitorDeS3 = new ArrayList<Monitor>();
		monitorDeS3.add(Lorena);		
		s3.setMonitor(monitorDeS3);
				
		//Bidireccion
		//Asignammos monitores a clientes
	
		List<Socio> SociosCarlos = new ArrayList<Socio>();
		SociosCarlos.add(s1);
		SociosCarlos.add(s2);		
		Carlos.setSocio(SociosCarlos);
		
		
		List<Socio> SociosLorena = new ArrayList<Socio>();
		SociosLorena.add(s3);		
		Lorena.setSocio(SociosLorena);		
		
		//Persistimos los objetos
		EntityManager em = factoria.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(s2);
		em.persist(g);
		em.persist(f);
		em.getTransaction().commit();
		em.close();
		factoria.close();		
	}	
}
