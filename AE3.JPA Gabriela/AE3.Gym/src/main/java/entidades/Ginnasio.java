package entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gym")
public class Ginnasio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, direccion;
	
	
	@OneToMany(mappedBy="gym", cascade=CascadeType.PERSIST)
	private List<Socio> socio;
	

	@OneToMany(mappedBy = "ginnasio", cascade=CascadeType.PERSIST)
	private List<Monitor> monitor;
	
	public Ginnasio() {
		super();
	}
	
	
	public Ginnasio(Integer id, String nombre, String direccion, List<Socio> socio, List<Monitor> monitor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.socio = socio;
		this.monitor = monitor;
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
	public List<Monitor> getMonitor() {
		return monitor;
	}
	public void setMonitor(List<Monitor> monitor) {
		this.monitor = monitor;
	}
	
	
	
	
}
