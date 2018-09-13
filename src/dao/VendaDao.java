package dao;

import apoio.ArquivoLog;
import apoio.HibernateUtil;
import entidades.ProdutoVenda;
import entidades.Venda;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;

public class VendaDao extends Dao {
    
    ArrayList<Venda> resultado;    
    
    public boolean vendaSemProdutos(Integer id) {
        ArquivoLog arquivoLog = new ArquivoLog();
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from ProdutoVenda where idVenda = '" + id + "'");
            ArrayList<ProdutoVenda> resultado = new ArrayList<ProdutoVenda>();
            resultado = (ArrayList<ProdutoVenda>) q.list();
            if (resultado.isEmpty()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            arquivoLog.gravaErro(e.toString());
        } finally {
            sessao.close();
        }
        return false;
    }

    public Venda procurarPorId(Integer id) {
        ArquivoLog arquivoLog =  new ArquivoLog();
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Venda");
            resultado = (ArrayList<Venda>) q.list();
            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Venda u = resultado.get(i);
                if (Objects.equals(u.getIdvenda(), id)) {
                    return u;
                }
                lin++;
            }
            return null;
        } catch (Exception e) {
            arquivoLog.gravaErro(e.toString());
        } finally {
            sessao.close();
        }
        return null;
    }

    public void populaVendas(JTable tblVendas) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createQuery("from Venda");
            ArrayList<Venda> resultado = new ArrayList<Venda>();
            resultado = (ArrayList<Venda>) q.list();

            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[4];

            cabecalho[0] = "Código";
            cabecalho[1] = "Nome";
            cabecalho[2] = "Telefone";
            cabecalho[3] = "Endereço";

            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][4];

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Venda u = resultado.get(i);
                dadosTabela[lin][0] = u.getIdvenda();
                dadosTabela[lin][1] = u.getIdcliente().getNome();
                dadosTabela[lin][2] = u.getIdcliente().getTelefone();
                dadosTabela[lin][3] = u.getIdcliente().getIdendereco().getRua() + u.getIdcliente().getIdendereco().getNumero();
                lin++;
            }

            // configuracoes adicionais no componente tabela
            tblVendas.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

            // permite seleção de apenas uma linha da tabela
            tblVendas.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < tblVendas.getColumnCount(); i++) {
                column = tblVendas.getColumnModel().getColumn(i);
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
