package dao;
import apoio.Calendario;
import apoio.HibernateUtil;
import apoio.Formatacao;
import apoio.TextAreaCellRenderer;
import entidades.Auditoria;
import entidades.Config;
import entidades.Versoes;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
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
            
            //muda cor do cabeçalho da tabela
//            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
//            headerRenderer.setBackground(Color.LIGHT_GRAY);
//
//            for (int i = 0; i < tblVersoes.getModel().getColumnCount(); i++) {
//                tblVersoes.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
//            }

            //dimensiona tamanho das colunas da tabela
            tblVersoes.getColumnModel().getColumn(0).setMaxWidth(1500);
            tblVersoes.getColumnModel().getColumn(1).setMaxWidth(100);
            tblVersoes.getColumnModel().getColumn(2).setMaxWidth(300); 
            
            //seta quebra de linha na coluna 1 da tabela
            TableColumn col = tblVersoes.getColumnModel().getColumn(0);  
            col.setCellRenderer(new TextAreaCellRenderer());
            
            tblVersoes.setSelectionMode(0);
            tblVersoes.setRowHeight(50);
            
            //centraliza conteudo das colunas
            DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer() {
            public void setValue(Object value) {
                setHorizontalAlignment(JLabel.CENTER);
                super.setValue(value);
            }
            };            
            tblVersoes.getColumn("Versão").setCellRenderer(centralizar);
            tblVersoes.getColumn("Data").setCellRenderer(centralizar);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
}
