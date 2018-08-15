package dao;

import apoio.HibernateUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Dao<T> {

    Session sessao = HibernateUtil.getSessionFactory().openSession();

    private EntityTransaction getTransacao(EntityManager session) {
        EntityTransaction transaction = session.getTransaction();
        return transaction;
    }

    public T salvar(T object) {  
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = sessao.beginTransaction();
            sessao.save(object);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public T atualizar(T object) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {            
            Transaction t = sessao.beginTransaction();
            sessao.update(object);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public T excluir(T object) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = sessao.beginTransaction();
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
}
