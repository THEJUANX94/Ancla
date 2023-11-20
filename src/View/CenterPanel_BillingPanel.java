package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class CenterPanel_BillingPanel extends JPanel {

	private JTable tabla1;
	private JTable tabla2;
	private DefaultTableModel dtm2;
	public AddProductToBillDialog addProductToBillDialog;
	private String[] cabeceraTabla1 = { "Id", "Nombre", "Tipo", "Marca", "Precio", "Stock" };
	private String[] cabeceraTabla2 = { "Id", "Nombre", "Cantidad", "Precio" };
	private String id;
	private String nombre;
	private String precio;
	private int stock;
	private String[][] data;
	private JTextField search;
	private int count;

	public CenterPanel_BillingPanel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		JPanel centerPanelLeft = new JPanel();
		JPanel centerPanel = new JPanel();
		addProductToBillDialog = new AddProductToBillDialog(listener);
		add(centerPanelLeft, BorderLayout.WEST);
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		addProductToBillDialog.setVisible(false);

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
		tabla1.setBackground(Color.WHITE);
		tabla1.setForeground(Color.BLACK);
		tabla1.getTableHeader().setResizingAllowed(false);
		tabla1.getTableHeader().setReorderingAllowed(false);

		centerPanelLeft.add(tabla1);

		JScrollPane scrollPanel1 = new JScrollPane(tabla1);
		scrollPanel1.setPreferredSize(new Dimension(680, 470));
		centerPanelLeft.add(scrollPanel1);

		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();

					// Obtener los datos de la fila seleccionada
					id = (String) target.getValueAt(row, 0);
					nombre = (String) target.getValueAt(row, 1);
					String marca = (String) target.getValueAt(row, 2);
					String tipo = (String) target.getValueAt(row, 3);
					precio = (String) target.getValueAt(row, 4);
					stock = Integer.parseInt((String) target.getValueAt(row, 5));

					addProductToBillDialog.setVisible(true);
					addProductToBillDialog.setDatos(id + "\n " + nombre + " " + marca + " " + tipo + " " + precio + " ");
				}
			}
		});

		centerPanel.setBackground(Color.WHITE);
		tabla2 = new JTable();
		tabla2.setBackground(Color.WHITE);
		tabla2.setForeground(Color.BLACK);
		tabla2.getTableHeader().setResizingAllowed(false);
		tabla2.getTableHeader().setReorderingAllowed(false);

		dtm2 = new DefaultTableModel(new Object[][] {}, cabeceraTabla2) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabla2.setModel(dtm2);

		centerPanel.add(tabla2);

		JScrollPane scrollPanel2 = new JScrollPane(tabla2);
		scrollPanel2.setPreferredSize(new Dimension(390, 470));
		centerPanel.add(scrollPanel2);
	}

	public void loadDataTable1(String[][] data) {
		this.data = data;
		DefaultTableModel dtm = new DefaultTableModel(data, cabeceraTabla1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabla1.setModel(dtm);
	}

	public void loadDataTable2() {
		int quantity = getQuantity();
		if (quantity != 0) {
			Object[] rowData = { id, nombre, quantity, Integer.parseInt(precio) * quantity };
			dtm2.addRow(rowData);
			addProductToBillDialog.setVisible(false);
		}
	}

	public int getQuantity() {
		return addProductToBillDialog.getQuantity(stock);
	}

	private void obtenerDatosEnTiempoReal() {
		String texto = search.getText();
		if (texto.equals("")) {
			loadDataTable1(data);
		} else {
			count = 0;
			String[][] data2 = new String[data.length][6];
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

	public String[][] getItems() {
		String[][] itemList = new String[tabla2.getModel().getRowCount()][2];
		for (int i = 0; i < tabla2.getModel().getRowCount(); i++) {
			itemList[i][0] = String.valueOf(tabla2.getModel().getValueAt(i, 0));
			itemList[i][1] = String.valueOf(tabla2.getModel().getValueAt(i, 2));
		}
		return itemList;
	}

	public void setTable2(){
		for (int i = 0; i < tabla2.getRowCount(); i++) {
			dtm2.removeRow(i);
			i-=1;
		}
	}

	public void getConfirm(boolean confirm){
		if(confirm = true){
			addProductToBillDialog.setVisible(false);
		}
	}
}
