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
    public void saveEmp(String hibernateConfigResource, Emp emp) {
        SessionFactory sessionFactory;
        Session session;
        Transaction transaction;

        sessionFactory = new Configuration().configure(hibernateConfigResource).buildSessionFactory();

        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();

        session.save(emp);

        transaction.commit();
        session.close();
    }

    @Override
    public void saveDept(String hibernateConfigResource, Dept dept) {
        SessionFactory sessionFactory;
        Session session;
        Transaction transaction;

        sessionFactory = new Configuration().configure(hibernateConfigResource).buildSessionFactory();

        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();

        session.save(dept);

        transaction.commit();
        session.close();

    }

    @Override
    public List<Dept> getAllDept(String hibernateConfigResource) {
        SessionFactory sessionFactory;
        Session session;
        Transaction transaction;
        List<Dept> deptList;

        sessionFactory = new Configuration().configure(hibernateConfigResource).buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Dept d");
        deptList = query.list();
        transaction.commit();

        session.close();
        sessionFactory.close();

        return deptList;
    }
}
