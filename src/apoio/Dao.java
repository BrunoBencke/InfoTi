package apoio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

public class Dao<T> {

    Session sessao = HibernateUtil.getSessionFactory().openSession();

    private EntityTransaction getTransacao(EntityManager session) {
        EntityTransaction transaction = session.getTransaction();
        return transaction;
    }

    public T salvar(T object) {        
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

    /* Faz a busca no banco pelo ID da entidade */

    public T procurarPorId(Class classe, Integer id) {
        Transaction t = sessao.beginTransaction();
        T object = null;
        try {            
//            org.hibernate.Query q = sessao.createQuery("from "+classe);
//            q.setResultTransformer(Transformers.aliasToBean(classe.getClass().class));
//            ArrayList<Usuario> resultado = new ArrayList<Usuario>();
//            resultado = (ArrayList<Usuario>) q.list();            
//            
//            Object[][] dadosTabela = null;
//            Object[] cabecalho = new Object[2];
//        
//            cabecalho[0] = "Id";
//            cabecalho[1] = "Login";
//
//            // cria matriz de acordo com nº de registros da tabela
//            dadosTabela = new Object[resultado.size()][2];
//
//            int lin = 0;
//            for (int i = 0; i < resultado.size(); i++) {
//                Usuario u = resultado.get(i);
//                dadosTabela[lin][0] = u.getIdusuario();
//                dadosTabela[lin][1] = u.getNome();
//                lin++;
//            }
//            
//            
//            
//            
//            
//            
            return object;
        } catch (Exception e) {
            System.out.println("Erro ao Localizar Objeto!" + e.toString());
        } finally {
            sessao.close();
        }
        return null;
    }

    /*Atualiza o objeto no banco de dados.     */

    public T atualizar(T object) {
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

//    /*Remove a Entidade do banco de dados.*/
//
//    public T excluir(T object) {
//        EntityTransaction transaction = null;
//        EntityManager session = hibernate.getEntityManager();
//        try {
//            transaction.begin();
//            session.remove(object);
//            transaction.commit();
//            return object;
//        } catch (Exception e) {
//            transaction.rollback();
//            System.out.println("Erro ao inserir os dados!" + e.toString());
//        } finally {
//            session.close();
//        }
//        return null;
//    }    
        
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
