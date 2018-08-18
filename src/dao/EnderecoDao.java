package dao;

import apoio.HibernateUtil;
import entidades.Estado;
import entidades.Municipio;
import java.util.List;
import org.hibernate.transform.Transformers;

public class EnderecoDao extends Dao{

//    public void popularEstados(JComboBox combo) {
//        sessao = HibernateUtil.getSessionFactory().openSession();
//        combo.setMaximumRowCount(15);
//        try {
//            org.hibernate.Query q = sessao.createSQLQuery("SELECT * FROM Estado ORDER BY Uf");
//            q.setResultTransformer(Transformers.aliasToBean(Estado.class));
//            ArrayList<Estado> resultado = (ArrayList<Estado>) q.list();
//            for (int i = 0; i < resultado.size(); i++) {
//                Estado e = resultado.get(i);
//                combo.addItem(e.getUf());
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao Popular Estados!" + e.toString());
//        }
//    }
//
//    public void popularCidades(JComboBox combo, String criterio) {
//        sessao = HibernateUtil.getSessionFactory().openSession();
//        combo.setMaximumRowCount(15);
//        try {
//            org.hibernate.Query q = sessao.createSQLQuery("SELECT * FROM Municipio WHERE Uf = '" + criterio + "' ORDER BY Nome");
//            q.setResultTransformer(Transformers.aliasToBean(Municipio.class));
//            ArrayList<Municipio> resultado = (ArrayList<Municipio>) q.list();
//            for (int i = 0; i < resultado.size(); i++) {
//                Municipio e = resultado.get(i);
//                combo.addItem(e.getNome());
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao Popular Cidades!" + e.toString());
//        }
//    }
    
    public Estado retornaObjetoUf(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Estado where idEstado = '" + id + "'");
            Estado uf = (Estado) q;
            return uf;
        } catch (Exception e) {
            System.out.println("Erro ao Localizar Uf!" + e.toString());
        }
        return null;
    }
    
    public Municipio retornaObjetoMunicipio(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Municipio where idMunicipio = '" + id + "'");
            List lista = q.list();
            Municipio cidade = (Municipio) lista.get(0);
            System.out.println("nome "+cidade.getNome()+" codigo cidade "+cidade.getId());
            return cidade;
        } catch (Exception e) {
            System.out.println("Erro ao Localizar Cidade!" + e.toString());
        }
        return null;
    }
}
