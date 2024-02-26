package entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "socios")
public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, apellidos;
	
	
	//Solo hacemos cascade cuando damos de alta
	@ManyToMany(cascade=CascadeType.PERSIST)
	//En este caso @JoinTable daremos instrucciones para crear la tabla intermedia
	//que JPA creara para hacer la realcion "Many to Many" 

	@JoinTable(name="socios_monitores",
			   joinColumns= { @JoinColumn(name="fk_id_socios", referencedColumnName="id") }, 
			   inverseJoinColumns= { @JoinColumn(name="fk_id_monitores", referencedColumnName="id")}) 
	private List<Monitor> monitor;
	
	@ManyToOne
	// En una relacion de "uno a muchos", la FK siempre esta en el lado de "Muchos", en una
	// relacion de "uno a uno" podemos poner la FK donde queramos.
	// Por lo tanto la @JoinColumn siempre estar� en este lado en este tipo de relaciones
	@JoinColumn(name="fk_id_gym", referencedColumnName="id")
	private Ginnasio gym;
	
	// Relacion de "uno a uno" (Socio - Ficha).
		//--------------------------------------
		// Siempre tenemos dos tipos de relaciones, unidireccional y bidireccional:
		// 	a) Unidireccional -> Solo una de las clases tiene una referencia sobre la otra
		// 	b) Bidireccional -> Las dos clases tienen referencias una con la otra. Este tipo
		//	es el que veremos en estos ejemplos
		
		
	@OneToOne(mappedBy = "socio", cascade=CascadeType.PERSIST)
	private Ficha ficha;
	
	
	public Socio() {
		super();
	}
	
	
	public Socio(Integer id, String nombre, String apellidos, List<Monitor> monitor, Ginnasio gym, Ficha ficha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.monitor = monitor;
		this.gym = gym;
		this.ficha = ficha;
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<Monitor> getMonitor() {
		return monitor;
	}
	public void setMonitor(List<Monitor> monitor) {
		this.monitor = monitor;
	}
	public Ginnasio getGym() {
		return gym;
	}
	public void setGym(Ginnasio gym) {
		this.gym = gym;
	}
	
	public Ficha getFicha() {
		return ficha;
	}
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	@Override
	public String toString() {
		return "Socio [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", monitor=" + monitor + ", gym="
				+ gym + ", ficha=" + ficha + "]";
	}

	
	
}
