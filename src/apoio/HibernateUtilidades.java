package apoio;


import javax.persistence.EntityManager;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class HibernateUtilidades {

    private static SessionFactory sessionFactory;
    protected EntityManager entityManager;

    private static SessionFactory getSessionFactory() throws MappingException {
        if (sessionFactory == null) {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
