package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

import util.JPAUtil;

public class GenericDAO {

    public void guardar(Object entidad) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(entidad);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public <T> T obtener(Class<T> claseEntidad, Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        T entidad = null;
        try {
            entidad = entityManager.find(claseEntidad, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return entidad;
    }

    public <T> List<T> obtenerPorConsulta(String consulta, Class<T> claseEntidad, Map<String, Object> parametros) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<T> resultados = null;

        try {
            Query query = entityManager.createQuery(consulta, claseEntidad);
            if (parametros != null) {
                for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }
            resultados = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return resultados;
    }
}