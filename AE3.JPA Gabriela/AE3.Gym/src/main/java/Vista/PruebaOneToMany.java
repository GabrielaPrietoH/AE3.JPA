package Vista;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import entidades.Ginnasio;
import entidades.Socio;

public class PruebaOneToMany {

private static EntityManager em;

	public static void main(String[] args) {
		
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("ginnasio");
		em = factoria.createEntityManager();
		
		EntityTransaction et = em.getTransaction();

		Ginnasio g = new Ginnasio(null, "Fullfitnes", "Calle Aquiles, 13", null, null);
	
	
	//A�adimos los socios asociados al ginnasio, no nos olvidamos de cruzar las
	//referencias para hacerlo bidireccional
	List<Socio> socios = new ArrayList<>();
	Socio s1 = new Socio(null, "Juan", "Gonzales", null, g, null);
	Socio s2 = new Socio(null, "Marta", "Perez", null, g, null);
	Socio s3 = new Socio(null, "Lucia", "Gimenez", null, g, null);
	Socio s4 = new Socio(null, "Maria", "Pintare", null, g, null);
	Socio s5 = new Socio(null, "Pedro", "Trujillo", null, g, null);
	
	
	//hacemos bidrecionalidad del cliente con sus pedidos
	g.setSocio(socios);		
	
	System.out.println("==============================================");
	em = factoria.createEntityManager();
	em.getTransaction().begin();
	
	//Como tenemos cascades en los dos extremos da igual el objeto
	//que escojamos para hacer el persist...	
	
	em.persist(g); 
	System.out.println(" ----- Dando de alta al socio en el ginnasio ----- ");
			
	
	em.getTransaction().commit(); 
	System.out.println(" ----- Ginnasio dado de alta ----- ");
	em.close();		
	
	
	System.out.println("Id del ginnasio: " + g.getId());
			
	//Acceso a objetos en realacions one to many y one to one
	System.out.println("==============================================");
	em = factoria.createEntityManager();

	System.out.println("Nombre: " + s1.getNombre());
	System.out.println("Apellido: " + s1.getApellidos());
	System.out.println("Ginnasio: " + g.getNombre());

	em.close();
	
	for(Socio sAux: g.getSocio()){
		System.out.println(sAux.getNombre());
	}
	
	factoria.close();
}
}
