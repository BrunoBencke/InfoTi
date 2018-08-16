/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import apoio.ComboItens;

/**
 *
 * @author pretto
 */
public class CombosDAO {

    ResultSet resultado = null;

    public void popularCombo(String tabela, JComboBox combo) {

        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela);

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new ComboItens();
                    item.setCodigo(resultado.getInt(1));
                    item.setDescricao(resultado.getString(2));

                    combo.addItem(item);
                }
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

    public void popularComboComComplemento(String tabela, String complementos, JComboBox combo) {

        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            if (complementos.equals("")) {
                resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela);
            } else {
                resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela + " " + complementos);
            }

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new ComboItens();
                    item.setCodigo(resultado.getInt(1));
                    item.setDescricao(resultado.getString(2));

                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
}
