package apoio;
import dao.Generica;
import javax.swing.JComboBox;
import org.hibernate.Session;
import java.util.List;

public class CombosDAO {

    Session sessao = HibernateUtil.getSessionFactory().openSession();

    public void popularCombo(String tabela, JComboBox combo) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query q = sessao.createQuery("from " + tabela);
            List lista = q.list();
            for (int i = 0; i < lista.size(); i++) {
                ComboItens item = new ComboItens();
                Generica generico = (Generica) lista.get(i);
                item.setCodigo(generico.getId());
                item.setDescricao(generico.getnome());
                combo.addItem(item);
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

    public void definirItemCombo(JComboBox combo, ComboItens item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ComboItens) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

//    public void popularComboComComplemento(String tabela, String complementos, JComboBox combo) {
//
//        ComboItens item = new ComboItens();
//        item.setCodigo(0);
//        item.setDescricao("Selecione");
//        combo.addItem(item);
//
//        try {
//            if (complementos.equals("")) {
//                resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela);
//            } else {
//                resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela + " " + complementos);
//            }
//
//            if (resultado.isBeforeFirst()) {
//                while (resultado.next()) {
//                    item = new ComboItens();
//                    item.setCodigo(resultado.getInt(1));
//                    item.setDescricao(resultado.getString(2));
//
//                    combo.addItem(item);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao popular Combo = " + e.toString());
//        }
//    }
}
