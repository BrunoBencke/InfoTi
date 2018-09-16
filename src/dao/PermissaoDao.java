package dao;

import apoio.HibernateUtil;
import entidades.Botao;
import entidades.Permissao;
import entidades.Tela;
import entidades.TelaBotao;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JDialog;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import static telas.JfrPrincipal.user;

public class PermissaoDao extends Dao{
        
    ArrayList<Permissao> resultado;
    ArrayList<JButton> botoes; 
    Permissao permissao = new Permissao();
    
    public ArrayList<Permissao> retornaPermissao(Usuario c){
        Permissao perm = new Permissao();
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Permissao where idUsuario = '" + c.getIdusuario() + "'");
            resultado = (ArrayList<Permissao>) q.list();
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro ao Localizar Objeto!" + e.toString());
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public void aplicaPermissao(JDialog tela, ArrayList<Permissao> permissao, ArrayList<JButton> botoes) {
//        if (permissao.getIdpermissao() == null) {
//            setPermissaoDefault(user);
//        }
        for (int i = 0; i < permissao.size(); i++) {
            Permissao u = permissao.get(i);
            if ((u.getIdbotao().getIdbotao() == 1)) {
                if (u.getSituacao() == true) {
                    botoes.get(0).setEnabled(true);
                } else {
                    botoes.get(0).setEnabled(false);
                }
            }
            if ((u.getIdbotao().getIdbotao() == 2)) {
                if (u.getSituacao() == true) {
                    botoes.get(1).setEnabled(true);
                } else {
                    botoes.get(1).setEnabled(false);
                }
            }
            if ((u.getIdbotao().getIdbotao() == 3)) {
                if (u.getSituacao() == true) {
                    botoes.get(2).setEnabled(true);
                } else {
                    botoes.get(2).setEnabled(false);
                }
            }
            if ((u.getIdbotao().getIdbotao() == 4)) {
                if (u.getSituacao() == true) {
                    botoes.get(3).setEnabled(true);
                } else {
                    botoes.get(3).setEnabled(false);
                }
            }
        }
    }

    public void setPermissaoDefault(Usuario usuario){
        try {
            Transaction t = sessao.beginTransaction();
            if (config.status_auditoria()) {
                auditoria.setDadoAnterior("Setadas Permissões Default");
                auditoria.setDadoNovo("Para o Usuário: "+usuario.toString());
                auditoria.setDataHora(calendario.obterDataAtualDMA() + " " + calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Insert");
                sessao.save(auditoria);
            }
            org.hibernate.Query q = sessao.createQuery("from Botao");
            ArrayList<Botao> botoes = new ArrayList<Botao>();
            botoes = (ArrayList<Botao>) q.list();
            org.hibernate.Query q1 = sessao.createQuery("from Tela");
            ArrayList<Tela> telas = new ArrayList<Tela>();
            telas = (ArrayList<Tela>) q1.list();

            for (int i = 0; i < botoes.size(); i++) {
                for (int j = 0; j < telas.size(); j++) {
                    TelaBotao telabotao = new TelaBotao();
                    permissao = new Permissao();
                    telabotao.setIdbotao(botoes.get(i));
                    telabotao.setIdtela(telas.get(j));
                    sessao.saveOrUpdate(telabotao);
                    permissao.setIdbotao(botoes.get(i));
                    permissao.setIdtela(telas.get(j));
                    permissao.setIdtelabotao(telabotao);
                    permissao.setIdusuario(usuario);
                    permissao.setSituacao(false);
                    sessao.save(permissao);
                }
            }
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
}
