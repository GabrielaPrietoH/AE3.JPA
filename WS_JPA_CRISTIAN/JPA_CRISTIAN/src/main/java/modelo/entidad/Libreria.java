package modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;


@Entity
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, nombreDueño, direccion;
	
	//Libro
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="libros_librerias",
			   joinColumns= {@JoinColumn(name="fk_id_libreria", referencedColumnName="id") }, 
			   inverseJoinColumns= { @JoinColumn(name="fk_id_libro", referencedColumnName="id")}) 
	private List<Libro> libro;

	public Libreria() {
		super();
	}

	public Libreria(Integer id, String nombre, String nombreDueño, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreDueño = nombreDueño;
		this.direccion = direccion;
		
	}

	public Integer getId() {
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

	public List<Libro> getLibros() {
		return libro;
	}

	public void setLibros(List<Libro> libros) {
		this.libro = libros;
	}
	
	
}
