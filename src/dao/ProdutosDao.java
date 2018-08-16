package dao;

import apoio.HibernateUtil;
import entidades.MarcaProduto;
import java.util.List;
import javax.swing.JComboBox;
import org.hibernate.transform.Transformers;

public class ProdutosDao extends Dao {

    public void popularMarcas(JComboBox combo) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        combo.setMaximumRowCount(15);
        try {
            
        } catch (Exception e) {
            System.out.println("Erro ao Popular Marcas!" + e.toString());
        }
    }

}
