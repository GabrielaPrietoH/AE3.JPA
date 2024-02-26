package entidad;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "libros")
public class Libro {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private double precio;
	
	 @ManyToOne // Indicamos que es una relación muchos a uno
	 @JoinColumn(name = "fk_id_autor", referencedColumnName = "id") 
	// Indicamos el nombre y las propiedades de la columna de la clave foránea
	private Autor autor;
	
	@ManyToOne 
	// En una relacion de "uno a muchos", la FK siempre esta en el lado de "Muchos", en una
	// relacion de "uno a uno" podemos poner la FK donde queramos.
	// Por lo tanto la @JoinColumn siempre estar� en este lado en este tipo de relaciones
	@JoinColumn(name="fk_id_editorial", referencedColumnName="id")
	private Editorial editorial;
	
	@ManyToMany(mappedBy="libros", cascade=CascadeType.PERSIST) 
	private List<Libreria> librerias;
	
	
	

	public Libro() {
		super();
		
	}


	
	public List<Libreria> getLibrerias() {
		return librerias;
	}



	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}



	public Libro(Integer id, String titulo, double precio, Autor autor, Editorial editorial, List<Libreria> librerias) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.autor = autor;
		this.editorial = editorial;
		this.librerias = librerias;
	}


	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	public List<Libreria> getLibros() {
		return librerias;
	}


	public void setLibros(List<Libreria> librrerias, List<Libreria> librerias) {
		this.librerias = librerias;
	}



	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", autor=" + autor + ", editorial="
				+ editorial + ", librerias=" + librerias + "]";
	}


	



}
