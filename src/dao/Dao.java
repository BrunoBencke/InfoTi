package dao;

import apoio.Calendario;
import apoio.HibernateUtil;
import entidades.Auditoria;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static telas.JfrPrincipal.user;

public class Dao<T> {

    Session sessao = HibernateUtil.getSessionFactory().openSession();
    ConfigDao config = new ConfigDao();
    Auditoria auditoria = new Auditoria();
    Calendario calendario = new Calendario();

    private EntityTransaction getTransacao(EntityManager session) {
        EntityTransaction transaction = session.getTransaction();
        return transaction;
    }

    public T salvar(T object) {  
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = sessao.beginTransaction();            
            if (config.status_auditoria()) {
                auditoria.setDadoAnterior("Novo Cadastro");
                auditoria.setDadoNovo(object.toString());
                auditoria.setData(calendario.obterDataAtualDMA());
                auditoria.setHora(calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Insert");                
                sessao.save(auditoria);
            }
            sessao.save(object);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public T atualizar(T object, String dado_anterior) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {            
            Transaction t = sessao.beginTransaction();
            if (config.status_auditoria()) {
                auditoria.setDadoAnterior(dado_anterior);
                auditoria.setDadoNovo(object.toString());
                auditoria.setData(calendario.obterDataAtualDMA());
                auditoria.setHora(calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Update");
                sessao.save(auditoria);
            }
            sessao.update(object);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public T excluir(T object, String dado_anterior) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = sessao.beginTransaction();
            if (config.status_auditoria()) {
                auditoria.setDadoAnterior(dado_anterior);
                auditoria.setDadoNovo("Delete");
                auditoria.setData(calendario.obterDataAtualDMA());
                auditoria.setHora(calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Delete");
                sessao.save(auditoria);
            }
            sessao.delete(object);
            t.commit();
            return object;
        } catch (Exception e) {
            System.out.println("Erro ao Excluir Registro!" + e.toString());
        } finally {
            sessao.close();
        }
        return null;
    }

    /**
     * Retorna a lista de itens salvo no banco de dados de acordo com a Entidade
     * passada como parâmetro.
     *
     * @param classe : Entidade que deverá buscar no banco de dados.
     * @return List contendo todos os objetos encontrados da entidade passada
     * como parâmetro.
     */
//    public List<T> listar(Class classe) {
//        EntityManager session = hibernate.getEntityManager();
//        try {
//            Query query = session.createQuery("SELECT e FROM "
//                    + classe.getSimpleName().toString() + " e");
//            return (List<T>) query.getResultList();
//        } catch (Exception e) {
//            System.out.println("Erro ao inserir os dados!" + e.toString());
//        } finally {
//            session.close();
//        }
//    }
    public String data_sistema(String data) throws ParseException {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String result = out.format(in.parse(data.toString()));
        return result;
    }
}
