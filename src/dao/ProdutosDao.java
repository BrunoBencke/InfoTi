package dao;

import apoio.CombosDAO;
import apoio.HibernateUtil;
import entidades.Cliente;
import entidades.MarcaProduto;
import entidades.Produto;
import entidades.ProdutoVenda;
import entidades.Venda;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class ProdutosDao extends Dao {

   ArrayList<Produto> resultado;
    
    public Produto procurarPorId(Integer id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Produto");
            resultado = (ArrayList<Produto>) q.list();
            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Produto u = resultado.get(i);
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
    
    public String retornaMarcaProduto(int codigo) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = sessao.createQuery("from MarcaProduto where idmarcaProduto = '" + codigo + "'");
        List lista = q.list();
        MarcaProduto marcaProduto = (MarcaProduto) lista.get(0);
        String retorno = marcaProduto.getNome();
        return retorno;
    }
    
    public MarcaProduto retornaObjetoMarcaProduto(int codigo) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = sessao.createQuery("from MarcaProduto where idmarcaProduto = '" + codigo + "'");
        List lista = q.list();
        MarcaProduto marcaProduto = (MarcaProduto) lista.get(0);
        return marcaProduto;
    }
    
    public Produto retornaExistente(String nome) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Produto where nome = '" + nome + "'");
            resultado = (ArrayList<Produto>) q.list();
            Produto u = resultado.get(0);
            return u;
        } catch (Exception e) {
            //System.out.println("Erro ao Localizar Objeto!" + e.toString());
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public void populaProduto(JTable tabela) {
        //List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Produto");
            ArrayList<Produto> resultado = new ArrayList<Produto>();
            resultado = (ArrayList<Produto>) q.list();
            
            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[7];

            cabecalho[0] = "Id";
            cabecalho[1] = "Nome";
            cabecalho[2] = "Marca";
            cabecalho[3] = "Valor";
            cabecalho[4] = "Estoque";
            cabecalho[5] = "Descrição";
            cabecalho[6] = "Situação";

            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][7];

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Produto m = resultado.get(i);
                dadosTabela[lin][0] = m.getIdproduto();
                dadosTabela[lin][1] = m.getNome();
                dadosTabela[lin][2] = retornaMarcaProduto(m.getIdmarcaProduto().getIdmarcaProduto());
                dadosTabela[lin][3] = m.getValor();
                dadosTabela[lin][4] = m.getEstoque();
                dadosTabela[lin][5] = m.getDescricao();
                if (resultado.get(i).getSituacao()) {
                    dadosTabela[lin][6] = "Ativo";
                } else {
                    dadosTabela[lin][6] = "Inativo";
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
        }
    }
    
    public void populaProdutosVenda(JTable tabela, Venda v) {
        //List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from ProdutoVenda where idVenda = '" + v.getIdvenda() + "'");
            ArrayList<ProdutoVenda> resultado = new ArrayList<ProdutoVenda>();
            resultado = (ArrayList<ProdutoVenda>) q.list();

            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[5];

            cabecalho[0] = "Id";
            cabecalho[1] = "Nome";
            cabecalho[2] = "Quantidade";
            cabecalho[3] = "Valor Unitario";
            cabecalho[4] = "Valor Total";

            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][5];

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                ProdutoVenda m = resultado.get(i);
                Produto p = procurarPorId(m.getIdproduto().getIdproduto());
                dadosTabela[lin][0] = m.getIdprodutovenda();
                dadosTabela[lin][1] = p.getNome();
                dadosTabela[lin][2] = m.getQuantidade();
                dadosTabela[lin][3] = m.getValorUnitario();
                dadosTabela[lin][4] = 0.0;
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
        }
    }
}
