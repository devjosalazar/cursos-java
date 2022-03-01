package co.edu.cue.webapp.banco.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory entityManagerFactory = builEntityManagerFactory();

    private static EntityManagerFactory builEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("localDataBase");
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

}
