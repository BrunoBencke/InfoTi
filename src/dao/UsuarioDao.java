package dao;
import apoio.ArquivoLog;
import apoio.HibernateUtil;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.transform.Transformers;

public class UsuarioDao<T> extends Dao {
    
    ArrayList<Usuario> resultado;

    public Usuario procurarPorId(Integer id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Usuario");
            resultado = (ArrayList<Usuario>) q.list();

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Usuario u = resultado.get(i);
                if (Objects.equals(u.getIdusuario(), id)) {
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

    public boolean procurarPorNome(String login) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Usuario");
            resultado = (ArrayList<Usuario>) q.list();
            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Usuario u = resultado.get(i);
                if (Objects.equals(u.getNome(), login)) {
                    return false;
                }
                lin++;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao Localizar Objeto!" + e.toString());
        } finally {
            sessao.close();
        }
        return false;
    }

    public void populaUsuarios(JTable tblUsuarios) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createSQLQuery("select idusuario,nome from Usuario");
            //ArrayList<Usuario> resultado = new ArrayList<Usuario>();
            q.setResultTransformer(Transformers.aliasToBean(Usuario.class));
            resultado = (ArrayList<Usuario>) q.list();

            Object[][] dadosTabela = null;
            Object[] cabecalho = new Object[2];

            cabecalho[0] = "Id";
            cabecalho[1] = "Login";

            // cria matriz de acordo com nº de registros da tabela
            dadosTabela = new Object[resultado.size()][2];

            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Usuario u = resultado.get(i);
                dadosTabela[lin][0] = u.getIdusuario();
                dadosTabela[lin][1] = u.getNome();
                lin++;
            }

            // configuracoes adicionais no componente tabela
            tblUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

            // permite seleção de apenas uma linha da tabela
            tblUsuarios.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < tblUsuarios.getColumnCount(); i++) {
                column = tblUsuarios.getColumnModel().getColumn(i);
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
