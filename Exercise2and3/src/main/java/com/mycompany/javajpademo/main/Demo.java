
package com.mycompany.javajpademo.main;

import com.mycompany.javajpademo.entity.HelloWorld;
import com.mycompany.javajpademo.entity.UserCompositeKey;
import com.mycompany.javajpademo.entity.UserProfile;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.metamodel.model.domain.spi.SingularPersistentAttribute;

/**
 *
 * @author sakina
 */
public class Demo {

    private static Scanner sin = new Scanner(System.in);

    private static EntityManager entityManager;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        entityManager = emf.createEntityManager();

        //storing data in table
        entityManager.getTransaction().begin();
        HelloWorld helloWorld = new HelloWorld();

        helloWorld.setMessage("music is life");

        entityManager.persist(helloWorld);
        
        entityManager.flush();
        entityManager.getTransaction().commit();

        //retrieve data'
        Query query = entityManager.createQuery("SELECT m FROM HelloWorld m", HelloWorld.class);
        List<HelloWorld> message = query.getResultList();

        for (HelloWorld m : message) {
            System.out.println("MESSAGE:" + m);
        }

        saveData();

        entityManager.close();
    }

    private static void saveData() {
        String name = new String();
        String email = new String();
        Long phone;

        //save data to user profile
        System.out.println("ENTER USERNAME :");
        name = sin.next();
        System.out.println("ENTER USER EMAIL :");
        email = sin.next();
        System.out.println("ENTER USER CONTACT :");
        phone = sin.nextLong();
        
        entityManager.getTransaction().begin();
     
        UserProfile user = new UserProfile();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        
        entityManager.persist(user);
        entityManager.flush();
        entityManager.getTransaction().commit();
        
    }

}
