package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CenterPanel_ManageTypePanel extends JPanel {

	private JTable tabla1;
	private String[] cabeceraTabla1 = { "Id", "Nombre"};
	private JTextField search;
	private String[][] data;
	private int count = 0;

	public CenterPanel_ManageTypePanel(ActionListener listener) {
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

		search = new JTextField();
		search.setPreferredSize(new Dimension(370, 20));
		topPanel.add(search);

		search.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				obtenerDatosEnTiempoReal();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				obtenerDatosEnTiempoReal();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				obtenerDatosEnTiempoReal();
			}
		});

		centerPanelLeft.setBackground(Color.WHITE);
		tabla1 = new JTable(new Object[][] {}, cabeceraTabla1);
		tabla1.getTableHeader().setResizingAllowed(false);
		tabla1.getTableHeader().setReorderingAllowed(false);

		centerPanelLeft.add(tabla1);

		JScrollPane scrollPanel1 = new JScrollPane(tabla1);
		scrollPanel1.setBackground(Color.WHITE);
		scrollPanel1.setPreferredSize(new Dimension(1100, 470));
		centerPanelLeft.add(scrollPanel1);
	}

	public void loadDataTable(String[][] data) {
		this.data = data;
		DefaultTableModel dtm = new DefaultTableModel(data, cabeceraTabla1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabla1.setModel(dtm);
	}

	private void obtenerDatosEnTiempoReal() {
		String texto = search.getText();
		if (texto.equals("")) {
			loadDataTable(data);
		} else {
			count = 0;
			String[][] data2 = new String[data.length][cabeceraTabla1.length];
			for (int i = 0; i < data.length; i++) {
				if (data[i][1].toUpperCase().contains(texto.toUpperCase())) {
					data2[count] = data[i];
					count++;
				}
			}
			DefaultTableModel dtm = new DefaultTableModel(data2, cabeceraTabla1) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			tabla1.setModel(dtm);
		}
	}

	public String getNameType() {
		String name = "";
		try {
			name = data[tabla1.getSelectedRow()][1];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione un tipo", "Error", JOptionPane.ERROR_MESSAGE);
			return name;
		}
		return name;
	}

	public int getIdType(){
		return Integer.parseInt(data[tabla1.getSelectedRow()][0]);
	}
}

