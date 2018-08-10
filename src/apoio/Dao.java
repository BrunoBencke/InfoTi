package apoio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Dao<T> {

//    HibernateUtil hibernate = new HibernateUtil();
//
//    private EntityTransaction getTransacao(EntityManager session) {
//        EntityTransaction transaction = session.getTransaction();
//        return transaction;
//    }
//
//    /* Salva o objeto no banco de dados */
//
//    public T salvar(T object) {
//        EntityTransaction transaction = null;
//        EntityManager session = hibernate.getEntityManager();        
//        try {
//            transaction = getTransacao(session);
//            transaction.begin();
//            session.persist(object);
//            transaction.commit();
//            return object;
//        } catch (Exception e) {
//            //transaction.rollback();
//            System.out.println("Erro ao inserir os dados!" + e.toString());
//        }
////        } finally {
////            session.close();
////        }
//        return null;
//    }
//
//    /* Faz a busca no banco pelo ID da entidade */
//
//    public T procurarPorId(Class classe, Integer id) {
//        EntityManager session = hibernate.getEntityManager();
//        T object = null;
//        try {
//            object = (T) session.find(classe, id);
//            return object;
//        } catch (Exception e) {
//            System.out.println("Erro ao inserir os dados!" + e.toString());
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    /*Atualiza o objeto no banco de dados.     */
//
//    public T atualizar(T object) {
//        EntityTransaction transaction = null;
//        EntityManager session = hibernate.getEntityManager();
//        try {
//            transaction = getTransacao(session);
//            transaction.begin();
//            session.merge(object);
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
//
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
