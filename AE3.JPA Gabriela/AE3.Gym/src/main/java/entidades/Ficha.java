package entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ficha")
public class Ficha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String direccion;
	private int edad;
	
	@Temporal(TemporalType.DATE)
	private Date FechaInicio;
	
	@OneToOne 
	
	// Mediante @JoinColumn establecemos que la FK estar� en esta tabla (socios).
	// Le podemos dar el nombre de la columna y a que columna de la tabla
	// socio estamos referenciando, que normalmente es la Primary Key (PK)
	@JoinColumn(name = "fk_id_socio", referencedColumnName = "id")
	private Socio socio;
	
	public Ficha() {
		super();
	}
	
	
	public Ficha(Integer id, String direccion, int edad, Date fechaInicio, Socio socio) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.edad = edad;
		FechaInicio = fechaInicio;
		this.socio = socio;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	public Date getFechaInicio() {
		return FechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Ficha [id=" + id + ", direccion=" + direccion + ", edad=" + edad + ", FechaInicio=" + FechaInicio
				+ ", socio=" + socio + "]";
	}
	
	

}
