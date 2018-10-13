package dao;

import apoio.HibernateUtil;
import entidades.Arquivo;
import java.util.ArrayList;

public class ArquivoDao extends Dao {

    public Arquivo buscarPorId(int idConta) {
        Arquivo arquivo = new Arquivo();
        sessao = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = sessao.createQuery("from Arquivo where IdContaPagar = '" + idConta + "'");
        ArrayList<Arquivo> resultado = new ArrayList<Arquivo>();
        resultado = (ArrayList<Arquivo>) q.list();
        arquivo = resultado.get(0);
        return arquivo;
    }
    
    public Boolean possuiAnexo(int idConta) {
        Boolean retorno = false;
        try {
            org.hibernate.Query q = sessao.createQuery("from Arquivo where idContaPagar = '" + idConta + "'");
            ArrayList<Arquivo> resultado1 = (ArrayList<Arquivo>) q.list();
            if (resultado1.size() > 0) {
                retorno = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
}
