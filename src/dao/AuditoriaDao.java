package dao;

import apoio.HibernateUtil;
import entidades.Arquivada;
import entidades.Auditoria;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.transform.Transformers;

public class AuditoriaDao extends Dao {
    
    UsuarioDao uDao = new UsuarioDao();
    Dao dao = new Dao();
    
    public void arquivarAuditoria(JTable tblAuditoria, String dataInicial, String dataFinal) {
         try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createSQLQuery("SELECT * FROM Auditoria WHERE data >= '" + dataInicial + "' AND data <= '"+ dataFinal+"'");
            //q.setResultTransformer(Transformers.aliasToBean(Auditoria.class));

            List<Object[]> objs = q.list();
            //List<Auditoria> relList = new ArrayList<Auditoria>();
            for (Object[] o : objs) {
                Object[] aux = o;
                Auditoria r = new Auditoria();
                r.setIdauditoria((Integer) aux[0]);
                Usuario u = uDao.procurarPorId((Integer)aux[1]);
                r.setIdusuario(u) ;
                r.setData((String) aux[2]);
                r.setHora((String) aux[3]);
                r.setDadoAnterior((String) aux[4]);
                r.setDadoNovo((String) aux[5]);
                r.setOperacao((String) aux[6]);
                Arquivada arq = new Arquivada();
                arq.setIdauditoria(r.getIdauditoria());
                arq.setIdusuario(r.getIdusuario());
                arq.setData(r.getData());
                arq.setHora(r.getHora());
                arq.setDadoAnterior(r.getDadoAnterior());
                arq.setDadoNovo(r.getDadoNovo());
                arq.setOperacao(r.getOperacao());
                dao.salvar_semAuditoria(arq);
                dao.excluirSemAuditoria(r);
            }
            } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    

    public void populaAuditoriaData(JTable tblAuditoria, String dataInicial, String dataFinal) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createSQLQuery("SELECT * FROM Auditoria WHERE data >= '" + dataInicial + "' AND data <= '"+ dataFinal+"'");
            //q.setResultTransformer(Transformers.aliasToBean(Auditoria.class));
            ArrayList<Auditoria> resultado = new ArrayList<Auditoria>();
            resultado = (ArrayList<Auditoria>) q.list();

            List<Object[]> objs = q.list();
            List<Auditoria> relList = new ArrayList<Auditoria>();
            for (Object[] o : objs) {
                Object[] aux = o;
                Auditoria r = new Auditoria();
                r.setIdauditoria((Integer) aux[0]);
                Usuario u = uDao.procurarPorId((Integer)aux[1]);
                r.setIdusuario(u) ;
                r.setData((String) aux[2]);
                r.setHora((String) aux[3]);
                r.setDadoAnterior((String) aux[4]);
                r.setDadoNovo((String) aux[5]);
                r.setOperacao((String) aux[6]);
                relList.add(r);
            }
            
            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[6];

            cabecalho[0] = "Usuário";
            cabecalho[1] = "Data";
            cabecalho[2] = "Hora";
            cabecalho[3] = "Antigo";
            cabecalho[4] = "Novo";
            cabecalho[5] = "Operação";

            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][6];

            int lin = 0;
            for (int i = 0; i < relList.size(); i++) {
                Auditoria u = relList.get(i);
                dadosTabela[lin][0] = u.getIdusuario().getNome();
                dadosTabela[lin][1] = u.getData();
                dadosTabela[lin][2] = u.getHora();
                dadosTabela[lin][3] = u.getDadoAnterior();
                dadosTabela[lin][4] = u.getDadoNovo();
                dadosTabela[lin][5] = u.getOperacao();
                lin++;
            }

            // configuracoes adicionais no componente tabela
            tblAuditoria.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

            // permite seleção de apenas uma linha da tabela
            tblAuditoria.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < tblAuditoria.getColumnCount(); i++) {
                column = tblAuditoria.getColumnModel().getColumn(i);
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

    public void populaAuditoria(JTable tblAuditoria) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createQuery("from Auditoria");
            ArrayList<Auditoria> resultado = new ArrayList<Auditoria>();
            resultado = (ArrayList<Auditoria>) q.list();

            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[6];

            cabecalho[0] = "Usuário";
            cabecalho[1] = "Data";
            cabecalho[2] = "Hora";
            cabecalho[3] = "Antigo";
            cabecalho[4] = "Novo";
            cabecalho[5] = "Operação";

            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][6];

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Auditoria u = resultado.get(i);
                dadosTabela[lin][0] = u.getIdusuario().getNome();
                dadosTabela[lin][1] = u.getData();
                dadosTabela[lin][2] = u.getHora();
                dadosTabela[lin][3] = u.getDadoAnterior();
                dadosTabela[lin][4] = u.getDadoNovo();
                dadosTabela[lin][5] = u.getOperacao();
                lin++;
            }

            // configuracoes adicionais no componente tabela
            tblAuditoria.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

            // permite seleção de apenas uma linha da tabela
            tblAuditoria.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < tblAuditoria.getColumnCount(); i++) {
                column = tblAuditoria.getColumnModel().getColumn(i);
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
