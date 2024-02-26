package modelo.entidad;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class PerfilEstudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String expediente;
	
	@OneToOne(mappedBy = "perfilEstudiante")
	@JoinColumn(name = "fk_id_estudiante", referencedColumnName = "id")
	private Estudiante estudiante;

	public PerfilEstudiante(Integer id, String expediente, Estudiante estudiante) {
		super();
		this.id = id;
		this.expediente = expediente;
		this.estudiante = estudiante;
	}

	public PerfilEstudiante() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "PerfilEstudiante [id=" + id + ", expediente=" + expediente + ", estudiante=" + estudiante + "]";
	}
	
	
	


}
