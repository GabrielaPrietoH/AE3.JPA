package entidad;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity

@Table(name = "librerias")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, nombreDueño, direccion;
	
	//Solo hacemos cascade cuando damos de alta
		@ManyToMany(cascade=CascadeType.PERSIST)
		//En este caso @JoinTable daremos instrucciones para crear la tabla intermedia
		//que JPA creara para hacer la realcion "Many to Many" 
		//Usa los siguientes parametros
		//1. name -> El nombre de la tabla intermedia
		//2. joinColumns -> las columnas FK y PK que aporta esta entidad (COMERCIAL)
		//3. inverseJoinColumns -> las columnas FK y PK que me aporta la otra Entidad (CLIENTE)
		@JoinTable(name="librerias_libros",
				   joinColumns= { @JoinColumn(name="fk_id_librerias", referencedColumnName="id") }, //FK que aporta Libros
				   inverseJoinColumns= { @JoinColumn(name="fk_id_libros", referencedColumnName="id")}) //FKs que aportan el resto de entidades
		private List<Libro> libros;
		
		
	public Libreria() {
		super();
		
	}




	public Libreria(Integer id, String nombre, String nombreDueño, String direccion, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreDueño = nombreDueño;
		this.direccion = direccion;
		this.libros = libros;
	}





	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreDueño() {
		return nombreDueño;
	}

	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}


	public List<Libro> getLibros() {
		return libros;
	}



	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombreDueño=" + nombreDueño + ", direccion=" + direccion
				+ ", libros=" + libros + "]";
	}



	
	

	
	
	
}
