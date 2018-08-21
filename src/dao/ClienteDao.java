package dao;

import apoio.HibernateUtil;
import entidades.Cliente;
import entidades.Endereco;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;

public class ClienteDao extends Dao {
    
    ArrayList<Cliente> resultado;
    
    public PessoaFisica retornaPf(Cliente c){
        PessoaFisica pf = new PessoaFisica();
        sessao = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = sessao.createQuery("from PessoaFisica where idCliente = '" + c.getIdcliente() + "'");
        ArrayList<PessoaFisica> resultado1 = (ArrayList<PessoaFisica>) q.list();
        if (resultado1.isEmpty()) {
            sessao.close();
            return null;
        } else {
            pf = resultado1.get(0);
            sessao.close();
            return pf;
        }
    }

    public PessoaJuridica retornaPj(Cliente c) {
        PessoaJuridica pj = new PessoaJuridica();
        sessao = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = sessao.createQuery("from PessoaJuridica where idCliente = '" + c.getIdcliente() + "'");
        ArrayList<PessoaJuridica> resultado1 = (ArrayList<PessoaJuridica>) q.list();
        if (resultado1.isEmpty()) {
            sessao.close();
            return null;
        } else {
            pj = resultado1.get(0);
            sessao.close();
            return pj;
        }
    }

    public Cliente procurarPorId(Integer id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Query q = sessao.createQuery("from Cliente");
            resultado = (ArrayList<Cliente>) q.list();
            int lin = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Cliente u = resultado.get(i);
                if (Objects.equals(u.getIdcliente(), id)) {
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

    public String retornaEndereco(int codigo) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = sessao.createQuery("from Endereco where idEndereco = '" + codigo + "'");
        List lista = q.list();
        Endereco endereco = (Endereco) lista.get(0);
        String retorno = endereco.getRua() + " " + endereco.getNumero();
        return retorno;
    }

    public Endereco retornaObjetoEndereco(int codigo) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = sessao.createQuery("from Endereco where idEndereco = '" + codigo + "'");
        List lista = q.list();
        Endereco endereco = (Endereco) lista.get(0);
        return endereco;
    }

        public void populaClientes(JTable tblClientes) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createQuery("from Cliente");
            ArrayList<Cliente> resultado = new ArrayList<Cliente>();
            resultado = (ArrayList<Cliente>) q.list();

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
                Cliente u = resultado.get(i);
                dadosTabela[lin][0] = u.getIdcliente();
                dadosTabela[lin][1] = u.getNome();
                dadosTabela[lin][2] = u.getTelefone();                
                dadosTabela[lin][3] = retornaEndereco(u.getIdendereco().getIdendereco());
                lin++;
            }

            // configuracoes adicionais no componente tabela
            tblClientes.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

            // permite seleção de apenas uma linha da tabela
            tblClientes.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < tblClientes.getColumnCount(); i++) {
                column = tblClientes.getColumnModel().getColumn(i);
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
