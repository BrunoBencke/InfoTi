package dao;

import apoio.Calendario;
import apoio.HibernateUtil;
import apoio.Formatacao;
import entidades.Auditoria;
import entidades.Config;
import entidades.Versoes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static telas.JfrLogin.user;

public class ConfigDao{

    Session sessao = HibernateUtil.getSessionFactory().openSession();
    Auditoria auditoria = new Auditoria(); 
    Calendario calendario = new Calendario();
    Formatacao formatacao = new Formatacao();
    
    public boolean status_auditoria() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createQuery("from Config where idConfig = '" + user.getIdconfig().getIdconfig() + "'");
            List lista = q.list();
            Config a = (Config) lista.get(0);
            if (a.getAuditoria() == 1) {
                return true;
            } else if (a.getAuditoria() == 0) {
                return false;
            }            
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }       
        return false;
    }

    public boolean status_exibir_versoes() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createQuery("from Config where idConfig = '" + user.getIdconfig().getIdconfig() + "'");
            List lista = q.list();
            Config a = (Config) lista.get(0);
            if (a.getExibirVersoes() == 1) {
                return true;
            } else if (a.getExibirVersoes() == 0) {
                return false;
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return false;
    }

    public void setar_status_auditoria(int status) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Config where idConfig = '" + user.getIdconfig().getIdconfig() + "'");
            List lista = q.list();
            Config a = (Config) lista.get(0);
            if (status == 1) {
                a.setAuditoria(1);
                auditoria.setDadoAnterior("Auditoria Desligada");
                auditoria.setDadoNovo("Auditoria Ligada");
                auditoria.setData(calendario.obterDataAtualDMA());
                auditoria.setHora(calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Update");
                sessao.save(auditoria);
                sessao.saveOrUpdate(a);
            } else if (status == 0) {
                a.setAuditoria(0);
                auditoria.setDadoAnterior("Auditoria Ligada");
                auditoria.setDadoNovo("Auditoria Desligada");
                auditoria.setData(calendario.obterDataAtualDMA());
                auditoria.setHora(calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Update");
                sessao.save(auditoria);
                sessao.saveOrUpdate(a);
            }
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void setar_status_exibir_versoes(int status) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Config where idConfig = '" + user.getIdconfig().getIdconfig() + "'");
            List lista = q.list();
            Config a = (Config) lista.get(0);
            if (status == 1) {
                a.setExibirVersoes(1);
                auditoria.setDadoAnterior("Exibir Releases Desligado");
                auditoria.setDadoNovo("Exibir Releases Ligado");
                auditoria.setData(calendario.obterDataAtualDMA());
                auditoria.setHora(calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Update");
                sessao.save(auditoria);
                sessao.saveOrUpdate(a);
            } else if (status == 0) {
                a.setExibirVersoes(0);
                auditoria.setDadoAnterior("Exibir Releases Ligado");
                auditoria.setDadoNovo("Exibir Releases Desligado");
                auditoria.setData(calendario.obterDataAtualDMA());
                auditoria.setHora(calendario.obterHoraAtual());
                auditoria.setIdusuario(user);
                auditoria.setOperacao("Update");
                sessao.save(auditoria);
                sessao.saveOrUpdate(a);
            }
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void populaVersoes(JTable tblVersoes) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createQuery("from Versoes");
            ArrayList<Versoes> resultado = new ArrayList<Versoes>();
            resultado = (ArrayList<Versoes>) q.list();

            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[3];

            cabecalho[0] = "Descrição";
            cabecalho[1] = "Versão";
            cabecalho[2] = "Data";

            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][3];

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Versoes u = resultado.get(i);
                dadosTabela[lin][0] = u.getDescricao();
                dadosTabela[lin][1] = u.getVersao();
                dadosTabela[lin][2] = formatacao.getDataHoraBanco(u.getData());
                lin++;
            }

            // configuracoes adicionais no componente tabela
            tblVersoes.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

            // permite seleção de apenas uma linha da tabela
            tblVersoes.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < tblVersoes.getColumnCount(); i++) {
                column = tblVersoes.getColumnModel().getColumn(i);
                switch (i) {
                    case 0:
                        column.setPreferredWidth(17);
                        break;
                    case 1:
                        column.setPreferredWidth(140);
                        break;
                }
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
}
