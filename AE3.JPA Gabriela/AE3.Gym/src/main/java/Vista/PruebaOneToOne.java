package Vista;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entidades.Ficha;
import entidades.Socio;

 
  
public class PruebaOneToOne {

private static EntityManager em;
	
	public static void main(String[] args) {

	EntityManagerFactory factoria = Persistence.createEntityManagerFactory("ginnasio");
	em = factoria.createEntityManager();
	
	EntityTransaction et = em.getTransaction();
	Socio s = new Socio(null, "Juan", "Gonzales", null, null, null);
	Ficha f = new Ficha(null, "Calle Juan Carlos, 13", 29,new Date(2021-9-21), null);
	
	
	s.setFicha(f);
	f.setSocio(s);
			
	System.out.println("==============================================");
	em = factoria.createEntityManager();
	em.getTransaction().begin();
	
	
	// Si NO hubiera un CASCADE.ALL o un CASCADE.PERSIST, esta persistencia fallar�a.
	em.persist(s); 
	em.getTransaction().commit(); 
	em.close();		
			
	em = factoria.createEntityManager();
	em.getTransaction().begin();

	//Creamos el socio
	Socio s1 = new Socio(null, "Lorena", "Gomez", null, null, null);
	em.persist(s1);
	em.getTransaction().commit(); 
	

	//Creamos la ficha
	em.getTransaction().begin();
	Ficha f2 = new Ficha(null, "Calle Luis Casal, 25", 42,new Date(2023-5-11), null);
	
	
	s1 = em.find(Socio.class, 2);
	
	//le asignamos a la ficha el socio previamente creado
	f2.setSocio(s1);
	//persistimos
	em.persist(f2);
	
	em.getTransaction().commit(); 
	em.close();				

	//cerramos el entitymanager
	factoria.close();
	
	}
}
