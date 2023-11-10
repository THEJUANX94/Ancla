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
import javax.swing.table.TableColumnModel;

public class CenterPanel_ManagePanel extends JPanel {

	private JTable tabla1;

	public CenterPanel_ManagePanel(ActionListener listener) {
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
		String[] cabeceraTabla1 = { "Id", "Marca", "Tipo", "Nombre", "Stock", "Precio" };
		tabla1 = new JTable(new Object[][] {}, cabeceraTabla1);
		tabla1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla1.getTableHeader().setResizingAllowed(false);
		tabla1.getTableHeader().setReorderingAllowed(false);

		TableColumnModel columnModelTable1 = tabla1.getColumnModel();
		columnModelTable1.getColumn(0).setPreferredWidth(70);
		columnModelTable1.getColumn(1).setPreferredWidth(240);
		columnModelTable1.getColumn(2).setPreferredWidth(240);
		columnModelTable1.getColumn(3).setPreferredWidth(340);
		columnModelTable1.getColumn(4).setPreferredWidth(110);
		columnModelTable1.getColumn(5).setPreferredWidth(100);

		centerPanelLeft.add(tabla1);

		JScrollPane scrollPanel1 = new JScrollPane(tabla1);
		scrollPanel1.setPreferredSize(new Dimension(1100, 470));
		centerPanelLeft.add(scrollPanel1);
	}
}


