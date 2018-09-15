package dao;

import apoio.HibernateUtil;
import entidades.Permissao;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Objects;

public class PermissaoDao extends Dao{
        
    ArrayList<Permissao> resultado;
    
    public Permissao retornaPermissao(Usuario c){
        Permissao perm = new Permissao();
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Permissao where idUsuario = '" + c.getIdusuario() + "'");
            resultado = (ArrayList<Permissao>) q.list();
            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Permissao u = resultado.get(i);
                if (Objects.equals(u.getIdusuario().getIdusuario(), c.getIdusuario())) {
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
}
