package presentacion;







import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidad.Autor;
import entidad.Editorial;
import entidad.Libreria;
import entidad.Libro;
import negocio.GestorLibrerias;


public class VistaUsuario {

	private static EntityManager em;
	
	public static void main(String[] args) {

		GestorLibrerias gl = new GestorLibrerias();
		
		System.out.println(gl.abrirConexion());
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("librerias");
		em = factoria.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		//Libro N:1 autor N:1 editorial 1:N libreria
		//Asignamos al libro a la libreria y persistimos el resto de entidades.
		//Al ser en cascada las librerias se integraran a los libros.
		
		
		
		Autor a1 = new Autor(null, "Stephen", "King",new Date(1947-9-21),null);
		Autor a2 = new Autor(null, "Isabel", "Allende",new Date(1942-8-02), null);
		Autor a3 = new Autor(null, "Joël", "Dicker",new Date(1985-6-16), null );
		
		et.begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		System.out.println("=============================================================================");
		System.out.println(" ----- Dando de alta los autores ----- ");
		System.out.println("=============================================================================");
		et.commit();
		
		
		Editorial e1 = new Editorial(null, "Afaguara", "Calle Paseo de la Castellana, 771. Madrid", null);
		Editorial e2 = new Editorial(null, "L’Age d’Homme", "la rue du Simplon, 132. Suiza", null);
		et.begin();
		em.persist(e1);
		em.persist(e2);
		System.out.println("=============================================================================");
		System.out.println(" ----- Dando de alta las editoriales ----- ");
		System.out.println("=============================================================================");
		et.commit();
		
		
		
		
		List<Libro> libros = new ArrayList<>();
				
		Libro l1 = new Libro(null,"El viento conoce mi nombre",21.75, a2, e1, null);
		Libro l2 = new Libro(null,"Largo pétalo de mar",19.90, a2, e1, null);
		Libro l3 = new Libro(null,"Más allá del invierno",9.95, a2, e1, null);
		Libro l4 = new Libro(null,"El caso Alaska Sanders",21.75, a3, e1, null);
		Libro l5 = new Libro(null,"El enigma de la habitación 622",21.75, a3, e2, null);
		Libro l6 = new Libro(null,"La desaparición de Stephanie Mailer",9.95, a3, e2, null);
		Libro l7 = new Libro(null,"El Instituto",19.90, a1, e2, null);
		Libro l8 = new Libro(null,"La sangre manda",9.95, a1, e2, null);
			
		libros.add(l1);
		libros.add(l2);
		libros.add(l3);
		libros.add(l4);
		libros.add(l5);
		libros.add(l6);
		libros.add(l7);
		libros.add(l8);
		
	
		et.begin();
		em.persist(l1);
		em.persist(l2);
		em.persist(l3);
		em.persist(l4);
		em.persist(l5);
		em.persist(l6);
		em.persist(l7);
		em.persist(l8);
		System.out.println("=============================================================================");
		System.out.println(" ----- Dando de alta los libros ----- ");
		System.out.println("=============================================================================");
		et.commit();
		
		Libreria li = new Libreria(null,"Mi Librito","Jose Manuel Lopez","Calle Francisco 32. Murcia", null);
		Libreria li2 = new Libreria(null,"La Casita del Libro","Maria Jesus Ruiz","Calle Juan 33. Santa Cruz de Tenerife", null);
		List<Libro> libreria1 = new ArrayList<>();
		libreria1.add(l1);
		libreria1.add(l2);
		libreria1.add(l3);
		libreria1.add(l4);
		li.setLibros(libreria1);
		
		List<Libro> libreria2 = new ArrayList<>();
		libreria2.add(l5);
		libreria2.add(l6);
		libreria2.add(l7);
		libreria2.add(l8);
		libreria2.add(l1);
		libreria2.add(l4);
		li2.setLibros(libreria2);
		
		et.begin();
		em.persist(li);
		em.persist(li2);
		System.out.println("=============================================================================");
		System.out.println(" ----- Dando de alta las librerias ----- ");
		System.out.println("=============================================================================");
		et.commit();
		
	
		System.out.println("=============================================================================");
		System.out.println(" ----- QUERYS ----- ");
       //Mostrar todos los libros dados de alta, con su editorial y su autor 
				//para hacer la consulta debemos de usar JPQL
						Query query = 
							em.createQuery("Select l FROM Libro l");
								try {
									//para hacer la consulta debemos de usar JPQL
								List<Libro> listaLibros = query.getResultList();
		System.out.println("=============================================================================");
	    System.out.println(" --- Mostrar todos los libros dados de alta, con su editorial y su autor --- ");
									for(Libro l : listaLibros) {
										System.out.println("Libro: " + l.getTitulo() +
												", autor: " + l.getAutor().getNombre() + " " +
												 l.getAutor().getApellidos() + " " +
												", editorial: " + l.getEditorial().getNombre());
									}
								}catch(Exception e) {
									System.out.println(e);
								}
		System.out.println("=============================================================================");	
		//Mostrar todos los autores dados de alta, con sus libros asociados 
								
						Query query2 = 
							em.createQuery("Select l FROM Libro l");
								try {
										//para hacer la consulta debemos de usar JPQL
										List<Libro> listaAutores = query2.getResultList();
		System.out.println("=============================================================================");	
	    System.out.println(" --- Mostrar todos los autores dados de alta, con sus libros asociados --- ");
										for(Libro l : listaAutores) {
											System.out.println(
													"Autor: " + l.getAutor().getNombre() + " " +
													 l.getAutor().getApellidos() + " " +
													"Libro: " + l.getTitulo());
										}
									
								}catch(Exception e) {
										System.out.println(e);
								}
		 System.out.println("=============================================================================");	
		 //Mostrar todas las librerías, con solamente sus libros asociados
								
						Query query3 = 
							em.createQuery("SELECT l.nombre, lib.titulo FROM Libreria l JOIN l.libros lib");
								try {
										//para hacer la consulta debemos de usar JPQL
									List<Object[]>  listaLibrerias = query3.getResultList();
										System.out.println(listaLibrerias);
		System.out.println("=============================================================================");	
		System.out.println(" --- Mostrar todas las librerías, con solamente sus libros asociados --- ");								
										for(Object[] l : listaLibrerias) {
											System.out.println("Librería: " + l[0] + " " + 
													", Libro: " + l[1]);
										}
									}catch(Exception e) {
											System.out.println(e);
									}
					

		System.out.println("=============================================================================");
		//Mostrar todos los libros dados de alta, y en la librería en la que están 
				
						Query query4 = 
							em.createQuery("SELECT li.nombre, lib.titulo FROM Libreria li JOIN li.libros lib");
								try {
									   //para hacer la consulta debemos de usar JPQL
									List<Object[]>  listaLibrosEnLibreria = query4.getResultList();
		System.out.println("=============================================================================");
		System.out.println(" --- Mostrar todos los libros dados de alta, y en la librería en la que están --- ");
									for(Object[] l : listaLibrosEnLibreria) {
										System.out.println("Libro: " + l[1] +
												", Libreria: " + l[0]);
									}
								}catch(Exception e) {
									System.out.println(e);
							}
		System.out.println("=============================================================================");						
		System.out.println(gl.cerrarConexion());
		
	}

}
