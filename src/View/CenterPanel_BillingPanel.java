package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class CenterPanel_BillingPanel extends JPanel {

	private JTable tabla;

	public CenterPanel_BillingPanel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);

		topPanel.setBackground(Color.WHITE);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.setPreferredSize(new Dimension(370, 20));
		topPanel.add(comboBox);

		JLabel lblNewLabel = new JLabel("           Metodo de pago:");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setPreferredSize(new Dimension(130, 20));
		topPanel.add(lblNewLabel);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setPreferredSize(new Dimension(150, 20));
		topPanel.add(comboBox_1);

		centerPanel.setBackground(Color.WHITE);
		String[] cabecera = { "Id", "Marca", "Tipo", "Nombre", "Cantidad", "Precio" };
		tabla = new JTable(new Object[][] {}, cabecera);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla.getTableHeader().setResizingAllowed(false);
		tabla.getTableHeader().setReorderingAllowed(false);

		TableColumnModel columnModel = tabla.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(70);
		columnModel.getColumn(1).setPreferredWidth(240);
		columnModel.getColumn(2).setPreferredWidth(240);
		columnModel.getColumn(3).setPreferredWidth(340);
		columnModel.getColumn(4).setPreferredWidth(110);
		columnModel.getColumn(5).setPreferredWidth(100);

		centerPanel.add(tabla);

		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setPreferredSize(new Dimension(1100, 470));
		centerPanel.add(scrollPane);
	}
}
