package dao;

import apoio.HibernateUtil;
import entidades.ProdutoVenda;
import java.util.ArrayList;
import java.util.Objects;

public class ProdutoVendaDao extends Dao {

    ArrayList<ProdutoVenda> resultado;

    public ProdutoVenda procurarPorId(Integer id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from ProdutoVenda");
            resultado = (ArrayList<ProdutoVenda>) q.list();
            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                ProdutoVenda u = resultado.get(i);
                if (Objects.equals(u.getIdproduto(), id)) {
                    return u;
                }
                lin++;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao Localizar Objeto!" + e.toString());
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public boolean excluirPorId(Integer id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from ProdutoVenda where idProdutoVenda = '" + id + "'");
            resultado = (ArrayList<ProdutoVenda>) q.list();
            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                ProdutoVenda u = resultado.get(i);
                if (Objects.equals(u.getIdprodutovenda(), id)) {
                    excluir(u, u.toString());
                    return true;
                }
                lin++;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Erro ao Localizar Objeto!" + e.toString());
        }
        return false;
    }
}
