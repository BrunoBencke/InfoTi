package dao;

import apoio.HibernateUtil;
import entidades.Config;
import java.util.List;

public class ConfigDao extends Dao{

    public boolean status_auditoria() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = sessao.createQuery("from Config");
        List lista = q.list();
        Config a = (Config) lista.get(0);
        if (a.getAuditoria() == 1) {
            return true;
        } else if (a.getAuditoria() == 0) {
            return false;
        }
        return false;
        }
            
            
}
