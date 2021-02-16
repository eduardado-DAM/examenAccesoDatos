package service;

import model.Dept;
import model.Emp;

import javax.persistence.*;

public class ObjectDBService implements ObjectService {


    @Override
    public void saveDept(Dept dept) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("src/main/resources/db/empresa.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(dept);


        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    @Override
    public void saveEmp(Emp emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("src/main/resources/db/empresa.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(emp);


        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
