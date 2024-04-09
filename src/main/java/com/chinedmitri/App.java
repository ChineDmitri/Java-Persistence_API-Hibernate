package com.chinedmitri;

import com.chinedmitri.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * Hello world!
 */
public class App {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");

    public static void main(String[] args) {
        System.out.println("Start app");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Message msg1 = new Message();
        msg1.setText("Hello JPA et Hibernate");

        em.persist(msg1);
        em.getTransaction().commit();
        em.close();


        System.out.println(msg1.getText());
    }
}
