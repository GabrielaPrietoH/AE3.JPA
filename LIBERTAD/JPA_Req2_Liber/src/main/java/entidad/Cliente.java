package entidad;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")  
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne
    @JoinColumn(name = "direccion_id") 
    private Direccion direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Proyecto> proyectos;

    // Constructor por defecto
    public Cliente() {
    }

    // Constructor con parámetros para crear instancias con nombre y dirección
    public Cliente(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    // toString
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", proyectos=" + proyectos +
                '}';
    }
}