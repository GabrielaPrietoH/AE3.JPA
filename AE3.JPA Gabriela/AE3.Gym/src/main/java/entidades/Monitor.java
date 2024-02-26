package entidades;

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

@Table(name = "monitores")
public class Monitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, apellidos, direccion;
	

	@ManyToMany(mappedBy="monitor", cascade=CascadeType.PERSIST) 
	private List<Socio> socio;
	
	@ManyToOne
	// En una relacion de "uno a muchos", la FK siempre esta en el lado de "Muchos", en una
	// relacion de "uno a uno" podemos poner la FK donde queramos.
	// Por lo tanto la @JoinColumn siempre estar� en este lado en este tipo de relaciones

	@JoinColumn(name = "fk_gym_id" , referencedColumnName="id")
	private Ginnasio ginnasio;
	
	
	public Monitor() {
		super();
	}
	
	
	public Monitor(Integer id, String nombre, String apellidos, String direccion, List<Socio> socio,
			Ginnasio ginnasio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.socio = socio;
		this.ginnasio = ginnasio;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public List<Socio> getSocio() {
		return socio;
	}
	public void setSocio(List<Socio> socio) {
		this.socio = socio;
	}
	@Override
	public String toString() {
		return "Monitor [num=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", socio=" + socio + "]";
	}
	public Ginnasio getGinnasio() {
		return ginnasio;
	}
	public void setGinnasio(Ginnasio ginnasio) {
		this.ginnasio = ginnasio;
	}
	
	
	
}
