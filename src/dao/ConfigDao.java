package dao;

import apoio.HibernateUtil;
import entidades.Config;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ConfigDao{

    Session sessao = HibernateUtil.getSessionFactory().openSession();
    
    public boolean status_auditoria() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createQuery("from Config");
            List lista = q.list();
            Config a = (Config) lista.get(0);
            if (a.getAuditoria() == 1) {
                return true;
            } else if (a.getAuditoria() == 0) {
                return false;
            }            
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }       
        return false;
    }
}
