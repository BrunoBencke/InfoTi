package dao;

import apoio.Calendario;
import apoio.HibernateUtil;
import entidades.Auditoria;
import entidades.Config;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static telas.JfrPrincipal.user;

public class ConfigDao{

    Session sessao = HibernateUtil.getSessionFactory().openSession();
    Auditoria auditoria = new Auditoria(); 
    Calendario calendario = new Calendario();    
    
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

    public void setar_status_auditoria(int status) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Config");
            List lista = q.list();
            Config a = (Config) lista.get(0);
            if (status == 1) {
                a.setAuditoria(1);
                auditoria.setDadoAnterior("Auditoria Desligada");
                auditoria.setDadoNovo("Auditoria Ligada");
                auditoria.setData(calendario.obterDataAtualDMA());
                auditoria.setHora(calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Update");
                sessao.save(auditoria);
                sessao.saveOrUpdate(a);
            } else if (status == 0) {
                a.setAuditoria(0);
                auditoria.setDadoAnterior("Auditoria Ligada");
                auditoria.setDadoNovo("Auditoria Desligada");
                auditoria.setData(calendario.obterDataAtualDMA());
                auditoria.setHora(calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Update");
                sessao.save(auditoria);
                sessao.saveOrUpdate(a);
            }
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
