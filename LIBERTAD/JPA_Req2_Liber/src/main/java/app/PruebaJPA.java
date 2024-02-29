package app;

import dao.GenericDAO;
import entidad.Cliente;
import entidad.Direccion;
import entidad.Empleado;
import entidad.Proyecto;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class PruebaJPA {
    public static void main(String[] args) {
        // Crear instancias de entidades
        Direccion direccion1 = new Direccion("Calle1", "Ciudad1", "Pais1");
        Cliente cliente1 = new Cliente("Cliente1", direccion1);
        Proyecto proyecto1 = new Proyecto("Proyecto1", LocalDate.now(), LocalDate.now().plusMonths(3));
        Empleado empleado1 = new Empleado("Empleado1", "Cargo1");

        // Asignar relaciones
        cliente1.setDireccion(direccion1);
        proyecto1.setCliente(cliente1);
        empleado1.setDireccion(direccion1);
        empleado1.getProyectos().add(proyecto1);

        // Utilizar el GenericDAO para realizar operaciones CRUD
        GenericDAO genericDAO = new GenericDAO();

        // Persistir datos
        genericDAO.guardar(direccion1);
        genericDAO.guardar(cliente1);
        genericDAO.guardar(proyecto1);
        genericDAO.guardar(empleado1);

        // Consultas
        EntityManager entityManager = genericDAO.getEntityManagerFactory().createEntityManager();

        // Consulta para Cliente
        List<Cliente> clientes = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("Proyecto(s): " + cliente.getProyectos());
        }

        // Consulta para Direccion
        List<Direccion> direcciones = entityManager.createQuery("SELECT d FROM Direccion d", Direccion.class).getResultList();
        for (Direccion direccion : direcciones) {
            System.out.println("Dirección: " + direccion.getCalle() + ", " + direccion.getCiudad() + ", " + direccion.getPais());
            System.out.println("Empleado: " + direccion.getEmpleado());
        }

        // Consulta para Empleado
        List<Empleado> empleados = entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
        for (Empleado empleado : empleados) {
            System.out.println("Empleado: " + empleado.getNombre());
            System.out.println("Cargo: " + empleado.getCargo());
            System.out.println("Proyecto(s): " + empleado.getProyectos());
        }

        // Consulta para Proyecto
        List<Proyecto> proyectos = entityManager.createQuery("SELECT p FROM Proyecto p", Proyecto.class).getResultList();
        for (Proyecto proyecto : proyectos) {
            System.out.println("Proyecto: " + proyecto.getNombre());
            System.out.println("Cliente: " + proyecto.getCliente().getNombre());
            System.out.println("Empleado(s): " + proyecto.getEmpleados());
        }

        // Cerrar EntityManager
        entityManager.close();
        genericDAO.closeEntityManagerFactory();
    }
}