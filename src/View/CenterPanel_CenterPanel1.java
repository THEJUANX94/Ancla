package View;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CenterPanel_CenterPanel1 extends JPanel{
    
    public CenterPanel_CenterPanel1(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {

		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(10, 11, 168, 22);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(281, 11, 54, 22);
		add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Metodo de pago:");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(188, 15, 82, 14);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 44, 315, 140);
		add(scrollPane);
		
		JTable table = new JTable();
		table.setBounds(20, 44, 315, 140);
		add(table);
    }
}
