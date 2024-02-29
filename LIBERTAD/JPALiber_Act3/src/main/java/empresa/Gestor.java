package empresa;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class Gestor {

    private static final String PERSISTENCE_UNIT_NAME = "LiberAct3_JPA";

    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();

            persistData(em);

            queryAndPrintLibros(em);
            queryAndPrintAutores(em);
            queryAndPrintLibrerias(em);
            queryAndPrintLibroLibreria(em);

            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void persistData(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();

            // Alta de 3 autores
            LocalDate fechaNacimiento1 = LocalDate.of(1800, 5, 15);
            Autor a1 = new Autor(null, "William", "Shakespeare", Date.from(fechaNacimiento1.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            LocalDate fechaNacimiento2 = LocalDate.of(1811, 6, 12);
            Autor a2 = new Autor(null, "Charles", "Dickens", Date.from(fechaNacimiento2.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            LocalDate fechaNacimiento3 = LocalDate.of(1775, 1, 23);
            Autor a3 = new Autor(null, "Jane", "Austen", Date.from(fechaNacimiento3.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            em.persist(a1);
            em.persist(a2);
            em.persist(a3);

            // Alta de 2 editoriales
            Editorial e1 = new Editorial(null, "Editorial Fantástica", "Calle Imaginación, 42");
            Editorial e2 = new Editorial(null, "Editorial Aventura", "Calle Misterio, 13");

            em.persist(e1);
            em.persist(e2);

            // Alta de 8 libros
            Libro l1 = new Libro(null, "Romeo and Juliet", 24.0, a1, e1);
            Libro l2 = new Libro(null, "Great Expectations", 15.0, a2, e2);
            Libro l3 = new Libro(null, "Pride and Prejudice", 18.0, a3, e1);
            Libro l4 = new Libro(null, "Hamlet", 23.0, a1, e2);
            Libro l5 = new Libro(null, "Oliver Twist", 12.0, a2, e1);
            Libro l6 = new Libro(null, "Sense and Sensibility", 20.0, a3, e2);
            Libro l7 = new Libro(null, "Macbeth", 30.0, a1, e1);
            Libro l8 = new Libro(null, "Emma", 13.0, a3, e2);

            em.persist(l1);
            em.persist(l2);
            em.persist(l3);
            em.persist(l4);
            em.persist(l5);
            em.persist(l6);
            em.persist(l7);
            em.persist(l8);

            // Alta de 2 librerías con libros asociados
            List<Libro> librosLibreria1 = new ArrayList<>();
            librosLibreria1.add(l1);
            librosLibreria1.add(l2);
            librosLibreria1.add(l3);
            librosLibreria1.add(l4);

            Libreria libreria1 = new Libreria(null, "Libros y Sueños", "Grupo Imaginativo", "Calle Fantasía, 7");
            libreria1.setLibros(librosLibreria1);

            em.persist(libreria1);

            List<Libro> librosLibreria2 = new ArrayList<>();
            librosLibreria2.add(l5);
            librosLibreria2.add(l6);
            librosLibreria2.add(l7);
            librosLibreria2.add(l8);

            Libreria libreria2 = new Libreria(null, "Viaje Literario", "Grupo Aventurero", "Calle Aventura, 21");
            libreria2.setLibros(librosLibreria2);

            em.persist(libreria2);

            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    private static void queryAndPrintLibros(EntityManager em) {
        Query query = em.createQuery("Select l FROM Libro l");
        List<Libro> listadoLibros = query.getResultList();

        System.out.println("\nListado de libros, con autor y editorial: ");

        for (Libro l : listadoLibros) {
            System.out.println("Libro: " + l.getTitulo() +
                    ", autor: " + l.getAutor().getNombre() + " " + l.getAutor().getApellidos() +
                    ", precio: " + l.getPrecio() +
                    ", editorial: " + l.getEditorial().getNombre());
        }
    }

    private static void queryAndPrintAutores(EntityManager em) {
        Query query1 = em.createQuery("SELECT a.nombre, a.apellidos, l.titulo FROM Autor a JOIN a.libros l");
        List<Object[]> listadoAutores = query1.getResultList();
        System.out.println("\nListado de Autores con sus libros: ");

        for (Object[] a : listadoAutores) {
            System.out.println("Autor: " + a[0] + " " + a[1] +
                    ", título: " + a[2]);
        }
    }

    private static void queryAndPrintLibrerias(EntityManager em) {
        Query query2 = em.createQuery("SELECT l.nombre, lib.titulo FROM Libreria l JOIN l.libros lib");
        List<Object[]> listadoLibrerias = query2.getResultList();
        System.out.println("\nListado de Librerías con sus libros: ");

        for (Object[] l : listadoLibrerias) {
            System.out.println("Librería: " + l[0] + " " +
                    ", título del libro: " + l[1]);
        }
    }

    private static void queryAndPrintLibroLibreria(EntityManager em) {
        Query query3 = em.createQuery("SELECT l.titulo, lib.nombre FROM Libro l JOIN l.libreria lib");
        List<Object[]> listadoLibroLibreria = query3.getResultList();
        System.out.println("\nListado de libros y en qué librería están: ");

        for (Object[] l : listadoLibroLibreria) {
            System.out.println("Libro: " + l[0] + ", librería: " + l[1]);
        }
    }
}