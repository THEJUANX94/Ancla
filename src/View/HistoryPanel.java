package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

public class HistoryPanel extends JPanel {

	private JTable tabla1;
	private TopPanel_BillingPanel topPanel_CenterPanel;
	private BotPanel_BillingPanel botPanel_BillingPanel;
	private String[] cabeceraTabla1 = { "Id", "Fecha", "Valor" };
	private int count;
	private JDateChooser dateChooser;
	private JButton searchButton;
	private String[][] data;
	private String id;

	public HistoryPanel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		topPanel_CenterPanel = new TopPanel_BillingPanel(listener);
		botPanel_BillingPanel = new BotPanel_BillingPanel(listener);
		botPanel_BillingPanel.setAcceptButton("Ver mas", "VerItemList");
		botPanel_BillingPanel.setCleanButton("Aceptar", "CancelarBusqueda");
		JPanel centerpanel = new JPanel();
		add(topPanel_CenterPanel, BorderLayout.NORTH);
		add(centerpanel, BorderLayout.CENTER);
		add(botPanel_BillingPanel, BorderLayout.SOUTH);

		centerpanel.setBackground(Color.WHITE);
		centerpanel.setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		centerpanel.add(centerPanel, BorderLayout.WEST);
		centerpanel.add(topPanel, BorderLayout.NORTH);
		centerpanel.add(centerPanel, BorderLayout.CENTER);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.getJCalendar().setMaxSelectableDate(new Date());
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setForeground(Color.BLACK);

		searchButton = new JButton("Buscar");
		searchButton.addActionListener(listener);
		searchButton.setActionCommand("Buscar_Fecha");
		searchButton.setPreferredSize(new Dimension(170, 30));
		searchButton.setBackground(new Color(53, 152, 200));
		searchButton.setForeground(Color.WHITE);
		searchButton.setSelected(false);
		searchButton.setFocusable(false);
		searchButton.setBorderPainted(false);

		topPanel.setBackground(Color.WHITE);
		topPanel.add(dateChooser);
		topPanel.add(searchButton);

		centerPanel.setBackground(Color.WHITE);
		tabla1 = new JTable(new Object[][] {}, cabeceraTabla1);
		tabla1.getTableHeader().setResizingAllowed(false);
		tabla1.getTableHeader().setReorderingAllowed(false);

		centerPanel.add(tabla1);

		JScrollPane scrollPanel1 = new JScrollPane(tabla1);
		scrollPanel1.setBackground(Color.WHITE);
		scrollPanel1.setPreferredSize(new Dimension(1100, 470));
		centerPanel.add(scrollPanel1);
	}

	public void loadDataHistory(String[][] data) {
		this.data = data;
		DefaultTableModel dtm = new DefaultTableModel(data, cabeceraTabla1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabla1.setModel(dtm);
	}

	public void getDate() {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String texto = String.valueOf(formatter.format(dateChooser.getDate()));
				count = 0;
				String[][] data2 = new String[data.length][cabeceraTabla1.length];
				for (int i = 0; i < data.length; i++) {
					if (data[i][1].contains(texto)) {
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
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Agregue una fecha", "Error fecha", JOptionPane.ERROR_MESSAGE);
		}
	}

	public int getIdBill() {
		try {
			id = String.valueOf(tabla1.getValueAt(tabla1.getSelectedRow(), 0));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una factura", "Seleccione una fila",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		return Integer.parseInt(id);
	}

	public void setHistoryTable() {
		loadDataHistory(data);
	}
}
