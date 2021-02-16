package service;

import model.Dept;
import model.Emp;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class HibernateUtil {

    private SessionFactory sessionFactory;

    private String ORACLE_PROPERTIES = "src/main/resources/oracleHibernatedb.properties";//todo probar ruta desde resources

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    /**
     * La clase, al instanciarse, carga un objeto de la clase SessionFactory que se podrá utilizar para crear sesiones
     * de hibernate
     */
    public HibernateUtil() {
        Configuration configuration;
        Properties properties;
        configuration = new Configuration();

        properties = loadProperties(ORACLE_PROPERTIES);

        configuration.addAnnotatedClass(Emp.class);
        configuration.addAnnotatedClass(Dept.class);


        configuration.setProperties(properties);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();


        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    /**
     * Carga un fichero properties
     *
     * @param propertiesSourcePath
     * @return
     */
    public Properties loadProperties(String propertiesSourcePath) {
        Properties properties = null;
        FileReader fileReader;

        try {
            properties = new Properties();
            fileReader = new FileReader(propertiesSourcePath);
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
