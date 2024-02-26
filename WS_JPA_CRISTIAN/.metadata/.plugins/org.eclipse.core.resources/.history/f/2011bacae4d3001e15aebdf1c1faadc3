package modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private double precio;
	
	//Profesor
	@ManyToOne
	@JoinColumn(name="fk_id_profesor", referencedColumnName="id")
	private Profesor profesor;
	
	//Academia
	@ManyToOne
	@JoinColumn(name="fk_id_academia", referencedColumnName="id")
	private Academia academia;
	
	//Estudiante
	@ManyToMany(mappedBy="estudiante", cascade=CascadeType.PERSIST) 
	private List<Estudiante> estudiante;

	public Curso(Integer id, String titulo, double precio, Profesor profesor, Academia academia) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.profesor = profesor;
		this.academia = academia;
	}

	public Curso() {
		super();
	}

	public Integer getId() {
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

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Academia getAcademia() {
		return academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

	public List<Estudiante> getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(List<Estudiante> estudiante) {
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", profesor=" + profesor
				+ ", academia=" + academia + ", estudiante=" + estudiante + "]";
	}
	
	

}
