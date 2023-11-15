package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class CenterPanel_BillingPanel extends JPanel {

	private JTable tabla1;
	private JTable tabla2;
	private String[] cabeceraTabla1 = { "Id", "Marca", "Tipo", "Nombre", "Stock", "Precio" };
	private String[] cabeceraTabla2 = { "Id", "Nombre", "Cantidad", "Precio" };

	public CenterPanel_BillingPanel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		JPanel centerPanelLeft = new JPanel();
		JPanel centerPanel = new JPanel();
		add(centerPanelLeft, BorderLayout.WEST);
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);

		topPanel.setBackground(Color.WHITE);
		Image img = new ImageIcon("Images/logoSearch.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel labelImage = new JLabel();
		labelImage = new JLabel();
		labelImage.setIcon(img2);
		topPanel.add(labelImage);

		JTextField search = new JTextField();
		search.setPreferredSize(new Dimension(370, 20));
		topPanel.add(search);

		centerPanelLeft.setBackground(Color.WHITE);
		tabla1 = new JTable(new Object[][] {}, cabeceraTabla1);
		tabla1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla1.setBackground(Color.WHITE);
        tabla1.setForeground(Color.BLACK);
		tabla1.getTableHeader().setResizingAllowed(false);
		tabla1.getTableHeader().setReorderingAllowed(false);

		TableColumnModel columnModelTable1 = tabla1.getColumnModel();
		columnModelTable1.getColumn(0).setPreferredWidth(30);
		columnModelTable1.getColumn(1).setPreferredWidth(140);
		columnModelTable1.getColumn(2).setPreferredWidth(140);
		columnModelTable1.getColumn(3).setPreferredWidth(220);
		columnModelTable1.getColumn(4).setPreferredWidth(80);
		columnModelTable1.getColumn(5).setPreferredWidth(70);

		centerPanelLeft.add(tabla1);

		JScrollPane scrollPanel1 = new JScrollPane(tabla1);
		scrollPanel1.setPreferredSize(new Dimension(680, 470));
		centerPanelLeft.add(scrollPanel1);

		centerPanel.setBackground(Color.WHITE);
		tabla2 = new JTable(new Object[][] {}, cabeceraTabla2);
		tabla2.setBackground(Color.WHITE);
        tabla2.setForeground(Color.BLACK);
		tabla2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla2.getTableHeader().setResizingAllowed(false);
		tabla2.getTableHeader().setReorderingAllowed(false);

		TableColumnModel columnModelTable2 = tabla2.getColumnModel();
		columnModelTable2.getColumn(0).setPreferredWidth(30);
		columnModelTable2.getColumn(1).setPreferredWidth(210);
		columnModelTable2.getColumn(2).setPreferredWidth(80);
		columnModelTable2.getColumn(3).setPreferredWidth(70);

		centerPanel.add(tabla2);

		JScrollPane scrollPanel2 = new JScrollPane(tabla2);
		scrollPanel2.setPreferredSize(new Dimension(390, 470));
		centerPanel.add(scrollPanel2);
	}

	public void loadDataTable1(String[][] data) {
		DefaultTableModel dtm = new DefaultTableModel(data, cabeceraTabla1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabla1.setModel(dtm);
	}

	public void loadDataTable2(String[][] data) {
		DefaultTableModel dtm = new DefaultTableModel(data, cabeceraTabla1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabla2.setModel(dtm);
	}
}
