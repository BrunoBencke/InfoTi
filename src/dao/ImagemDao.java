package dao;

import apoio.HibernateUtil;
import entidades.Arquivo;
import org.hibernate.HibernateException;


public class ImagemDao extends Dao {

//    public Boolean salvar(Arquivo exemplo) {
//        Boolean retorno = false;
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            org.hibernate.Query q = null;            
//            q.setBinary(1, exemplo.getArquivo());
//            sessao.createSQLQuery("INSERT INTO Arquivo (arquivo) values (?)");
//            retorno = true;
//        } catch (HibernateException he) {
//            he.printStackTrace();
//        }
//        return retorno;
//    }
}
