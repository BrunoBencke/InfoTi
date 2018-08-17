package dao;

import apoio.CombosDAO;
import apoio.HibernateUtil;
import entidades.MarcaProduto;
import entidades.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class ProdutosDao extends Dao {

    public void populaProduto(JTable tabela) {
        //List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createSQLQuery("SELECT p.idProduto,p.nome,mp.nome AS MarcaProduto,p.valor,p.estoque,p.descricao,p.situacao FROM Marca_Produto mp, Produto p WHERE p.idMarca_Produto = mp.idMarca_produto ORDER BY p.nome");
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

            System.out.println("passsou2");
            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][7];

            System.out.println("passsou2");

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Produto m = resultado.get(i);
                dadosTabela[lin][0] = m.getIdproduto();
                dadosTabela[lin][1] = m.getNome();
                dadosTabela[lin][2] = m.getIdmarcaProduto();
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

}
