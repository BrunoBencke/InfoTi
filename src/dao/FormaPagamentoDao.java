package dao;

import apoio.HibernateUtil;
import entidades.FormaPagamento;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormaPagamentoDao extends Dao {

    public FormaPagamento procurarPorId(Integer id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        //T object = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from FormaPagamento");
            //q.setResultTransformer(Transformers.aliasToBean(Usuario.class));
            //ArrayList<Usuario> resultado = new ArrayList<Usuario>();
            //resultado = (ArrayList<Usuario>) q.list();
            ArrayList<FormaPagamento> resultado = (ArrayList<FormaPagamento>) q.list();

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                FormaPagamento u = resultado.get(i);
                if (Objects.equals(u.getIdformaPagamento(), id)) {
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

    public void populaFormaPagamento(JTable tabela) {
        //List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from FormaPagamento");
            ArrayList<FormaPagamento> resultado = new ArrayList<FormaPagamento>();
            resultado = (ArrayList<FormaPagamento>) q.list();

            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[2];

            cabecalho[0] = "Id";
            cabecalho[1] = "Nome";
            
            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][2];

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                FormaPagamento m = resultado.get(i);
                dadosTabela[lin][0] = m.getIdformaPagamento();
                dadosTabela[lin][1] = m.getDescricao();
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
        }
    }

}
