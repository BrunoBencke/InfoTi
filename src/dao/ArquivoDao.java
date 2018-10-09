package dao;

import apoio.HibernateUtil;
import entidades.Arquivo;

public class ArquivoDao extends Dao {

    public Arquivo buscarPorId(int idConta) {
        Arquivo arquivo = new Arquivo();
        sessao = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = sessao.createQuery("from Arquivo where IdContaPagar = '" + idConta + "'");
        arquivo = (Arquivo) q.list();
        return arquivo;
    }


    
//    public Boolean inserir(Arquivo arquivo) {
//        Boolean retorno = false;
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            org.hibernate.Query q = sessao.createSQLQuery("INSERT INTO arquivo values "+arquivo.getArquivo());
//            retorno = true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return retorno;
//    }
}
