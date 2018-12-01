package apoio;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

//transforma coluna de tabela em text area para fazer a quebra de linha automatica

public class TextAreaCellRenderer extends JTextArea implements TableCellRenderer {

    public TextAreaCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N  
        setMargin(new java.awt.Insets(5, 5, 5, 5));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        // set color & border here                
        this.setText(value.toString());

        setText((value == null) ? "" : value.toString());
        setSize(table.getColumnModel().getColumn(column).getWidth(),
                getPreferredSize().height);

        if (table.getRowHeight(row) < getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height);
        }

        return this;
    }
}
