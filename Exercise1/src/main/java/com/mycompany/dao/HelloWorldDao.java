/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.config.HibernetUtils;
import com.mycompany.model.HelloWorld;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sakina
 */
public class HelloWorldDao {
    
     public void saveMessage(HelloWorld helloWorld) {
        Transaction transaction = null;
        try (Session session = HibernetUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(helloWorld);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
     
     public List < HelloWorld > getMessages() {
        try (Session session = HibernetUtils.getSessionFactory().openSession()) {
            return session.createQuery("from HelloWorld", HelloWorld.class).list();
        }
    }
}
