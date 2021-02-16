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



    @Override
    public List<Emp> getAllEmp(String hibernateConfigResource) {
        Session session;
        SessionFactory sessionFactory;

        Transaction transaction;
        List<Emp> empList;
        HibernateUtil hibernateUtil;

        hibernateUtil = new HibernateUtil();
        sessionFactory = hibernateUtil.getSessionFactory();
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
    public List<Dept> getAllDept(String hibernateConfigResource) {
        HibernateUtil hibernateUtil;
        SessionFactory sessionFactory;
        Session session;
        Transaction transaction;
        List<Dept> deptList;

        hibernateUtil = new HibernateUtil();
        sessionFactory = hibernateUtil.getSessionFactory();
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
