package service;

import model.Dept;
import model.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HiberService implements IHyberService {

    public static final String HIBERNATE_CONFIG_ORACLE = "hibernateOracle.cfg.xml";
    public static final String HIBERNATE_CONFIG_MARIADB = "hibernateMariaDB.cfg.xml";



    /*public List<PlanetaEntity> getAllPlanets() {
        List<PlanetaEntity> planetaEntityList;
        Session session;
        Transaction transaction;


        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from PlanetaEntity p"); //Cuidado, importar de org.hibernate.query
        planetaEntityList = query.list();
        transaction.commit();

        session.close();
        sessionFactory.close();

        return planetaEntityList;
    }*/


    @Override
    public List<Emp> getAllEmp(String hibernateConfigResource) {
        SessionFactory sessionFactory;
        Session session;
        Transaction transaction;
        List<Emp> empList;

        sessionFactory = new Configuration().configure(hibernateConfigResource).buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Emp e");
        empList = query.list();
        transaction.commit();

        session.close();
        sessionFactory.close();

        return empList;
    }

    @Override
    public void saveEmpInMariaDB() {
        SessionFactory sessionFactory;
        Session session;
        Transaction transaction;

        sessionFactory = new Configuration().configure("src/main/resources/hibernateOracle.cfg.xml").buildSessionFactory();

        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();

        /*session.save(planeta);*/

        transaction.commit();
        session.close();
    }

    @Override
    public List<Dept> getAllDept() {
        return null;
    }
}
