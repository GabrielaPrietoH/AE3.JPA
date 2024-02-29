package entidad;

import javax.persistence.*;

@Entity
@Table(name = "direccion") 
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String ciudad;
    private String pais;

    @OneToOne(mappedBy = "direccion")
    private Empleado empleado;

    // Constructor por defecto
    public Direccion() {
    }

    // Constructor con parámetros
    public Direccion(String calle, String ciudad, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    // toString
    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}