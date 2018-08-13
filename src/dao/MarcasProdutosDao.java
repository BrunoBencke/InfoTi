package dao;

import apoio.HibernateUtil;
import entidades.MarcaProduto;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MarcasProdutosDao extends Dao{
    
    
    public MarcaProduto procurarPorId(Integer id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        //T object = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from MarcaProduto");
            //q.setResultTransformer(Transformers.aliasToBean(Usuario.class));
            //ArrayList<Usuario> resultado = new ArrayList<Usuario>();
            //resultado = (ArrayList<Usuario>) q.list();
            ArrayList<MarcaProduto> resultado = (ArrayList<MarcaProduto>) q.list();

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                MarcaProduto u = resultado.get(i);
                if (Objects.equals(u.getIdmarcaProduto(), id)) {
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
    
    
    
        public void populaMarcaProduto(JTable tabela) {
        //List resultado = null;
        try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from MarcaProduto");
            ArrayList<MarcaProduto> resultado = new ArrayList<MarcaProduto>();
            resultado = (ArrayList<MarcaProduto>) q.list();            
            
            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[3];

            cabecalho[0] = "Id";
            cabecalho[1] = "Nome";
            cabecalho[2] = "Situação";

            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][3];

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                MarcaProduto m = resultado.get(i);
                dadosTabela[lin][0] = m.getIdmarcaProduto();
                dadosTabela[lin][1] = m.getNome();
                if (resultado.get(i).getSituacao()) {
                    dadosTabela[lin][2] = "Ativo";
                }else{
                    dadosTabela[lin][2] = "Inativo";
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
