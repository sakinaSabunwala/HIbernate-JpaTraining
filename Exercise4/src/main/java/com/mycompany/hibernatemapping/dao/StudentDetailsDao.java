package com.mycompany.hibernatemapping.dao;

import com.mycompany.hibernatemapping.entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sakina
 */
public class StudentDetailsDao {

    private static EntityManager entityManager;

    public void saveDetails(Student student) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        
//        entityManager.flush();
        entityManager.getTransaction().commit();

        entityManager.close();

    }

//    public List<Student> getMessages() {
//        try (Session session = HibernetUtils.getSessionFactory().openSession()) {
//            return session.createQuery("from student", Student.class).list();
//        }
//    }

}
