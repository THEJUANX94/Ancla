package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ItemsDialog extends JDialog{

    private JButton cancel;
    private JTable table;
    private String[] cabeceratable = { "Producto", "Cantidad" };

    public ItemsDialog(ActionListener listener){
        initComponents(listener);
        setSize(500, 600);
        setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
    }

     private void initComponents(ActionListener listener) {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
    
        table = new JTable(new Object[][] {}, cabeceratable);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        add(table);
    
        JScrollPane scrollPanel = new JScrollPane(table);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(scrollPanel, gbc);

        JLabel label = new JLabel("    ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(label, gbc);
    
        cancel = new JButton("Aceptar");
        cancel.addActionListener(listener);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setPreferredSize(new Dimension(200, 30));
        cancel.setFocusPainted(false);
        cancel.addActionListener(listener);
        cancel.setActionCommand("Cancelar");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(cancel, gbc);
    }

    public void getItemList(String[][] data) {
        DefaultTableModel dtm = new DefaultTableModel(data, cabeceratable) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(dtm);
    }
}