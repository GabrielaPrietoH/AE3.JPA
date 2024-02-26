package entidad;


import java.util.Date;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, apellidos;
	
	@Temporal(TemporalType.DATE)
	private Date FechaNacimiento;
	

	@OneToMany(mappedBy = "autor") 
	// Indicamos que es una relación uno a muchos y el atributo que la mapea en la clase Libro
	private List<Libro> libros;
	

	public Autor() {
		super();
		
	}


	
	public Autor(Integer id, String nombre, String apellidos, Date fechaNacimiento, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		FechaNacimiento = fechaNacimiento;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	
	

	public List<Libro> getLibros() {
		return libros;
	}



	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}



	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", FechaNacimiento="
				+ FechaNacimiento + ", libros=" + libros + "]";
	}




	
	
	
}
