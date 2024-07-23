package org.example;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;

public class HibernateConfig {
    private static SessionFactory sessionFactory = null;
    public static SessionFactory getsessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Student.class).addAnnotatedClass(Courses.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
