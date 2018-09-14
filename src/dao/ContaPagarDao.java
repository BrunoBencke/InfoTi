package dao;

import apoio.ArquivoLog;
import apoio.HibernateUtil;
import entidades.ContaPagar;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContaPagarDao extends Dao {

    ArquivoLog arquivoLog = new ArquivoLog();

    Dao d = new Dao();

    public ContaPagar procurarPorId(Integer id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        //T object = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from ContaPagar");
            //q.setResultTransformer(Transformers.aliasToBean(Usuario.class));
            //ArrayList<Usuario> resultado = new ArrayList<Usuario>();
            //resultado = (ArrayList<Usuario>) q.list();
            ArrayList<ContaPagar> resultado = (ArrayList<ContaPagar>) q.list();

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                ContaPagar u = resultado.get(i);
                if (Objects.equals(u.getIdcontaPagar(), id)) {
                    return u;
                }
                lin++;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao Localizar Objeto!" + e.toString());
            arquivoLog.gravaErro(e.toString());
        } finally {
            sessao.close();
        }
        return null;
    }

    public void populaContaPagar(JTable tabela) {
        //List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from ContaPagar");
            ArrayList<ContaPagar> resultado = new ArrayList<ContaPagar>();
            resultado = (ArrayList<ContaPagar>) q.list();

            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[7];

            cabecalho[0] = "Id";
            cabecalho[1] = "Nome";
            cabecalho[2] = "Valor";
            cabecalho[3] = "Valor Pago";
            cabecalho[4] = "Data Vencimento";
            cabecalho[5] = "Data Pagamento";
            cabecalho[6] = "Situação";

            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][7];

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                ContaPagar m = resultado.get(i);
                dadosTabela[lin][0] = m.getIdcontaPagar();
                dadosTabela[lin][1] = m.getNome();
                dadosTabela[lin][2] = m.getValor();
                dadosTabela[lin][3] = m.getValorpago();
                dadosTabela[lin][4] = m.getDataVencimento();
                dadosTabela[lin][5] = m.getDataPagamento();
                if (resultado.get(i).getSituacao()) {
                    dadosTabela[lin][6] = "Aberta";
                } else {
                    dadosTabela[lin][6] = "Fechada";
                }
                lin++;
            }

            // configuracoes adicionais no componente tabela
            tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

            // permite seleção de apenas uma linha da tabela
            tabela.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < tabela.getColumnCount(); i++) {
                column = tabela.getColumnModel().getColumn(i);
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
            arquivoLog.gravaErro(he.toString());

        }
    }

    public Query pagamentoQuitar(int id, String data) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createSQLQuery("Update conta_pagar SET data_pagamento = '" + data + "', situacao = 'false' WHERE idconta_pagar = " + id);
            ArrayList<ContaPagar> resultado = new ArrayList<ContaPagar>();
            resultado = (ArrayList<ContaPagar>) q.list();

            sessao.getTransaction().commit();
            sessao.saveOrUpdate(q);

            
            return q;
        } catch (Exception e) {

            System.out.println("Erro ao Localizar Objeto!" + e.toString());
            arquivoLog.gravaErro(e.toString());

        } finally {
            sessao.close();
        }
        
        return null;
    }

}
