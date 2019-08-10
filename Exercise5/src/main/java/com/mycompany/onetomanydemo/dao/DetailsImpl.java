package com.mycompany.onetomanydemo.dao;

import java.sql.Driver;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author sakina
 */
public class DetailsImpl {

    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());

    private static EntityManager entityManager;
    private static EntityManagerFactory emf;
    static EntityTransaction entityTransaction;

    public DetailsImpl() {
        emf = Persistence.createEntityManagerFactory("entityManager");
        entityManager = emf.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
    }

    public List<? extends Object> getAll(String entityClass) {
        List<? extends Object> objects = null;
        objects = entityManager.createQuery("Select a From " + entityClass + " a")
                .getResultList();
        System.out.println("OBJECTS ::" + objects);
        return objects;

    }

    public void save(Object object) {
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    public void delete(String entityClass, int rowId) {
       try {
           String str = "DELETE FROM " + entityClass + " a WHERE a.id = " + rowId;
           Query query = entityManager
                   .createQuery(str);
           int deletionCount = query.executeUpdate();
           if (deletionCount > 0) {
               LOGGER.info("Entry deleted.");
           } else {
               LOGGER.info("Entry not found.");
           }
           entityManager.getTransaction().commit();
       } catch (Exception ex) {
           LOGGER.info("Class not found.");
       }
   }

    public Object findByUniqueColumnValue(String entityClass, String column, String columnValue) throws ClassNotFoundException {
        TypedQuery<? extends Object> query = entityManager.createQuery(
                "SELECT c FROM " + entityClass + " c WHERE c." + column + "name = :name", Class.forName(entityClass));
        return query.setParameter(column, columnValue).getSingleResult();
    }

    public void update(Object object) {
        
        System.out.println("OBJECT ::" + object);
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }
}
