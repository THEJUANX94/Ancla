package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddProductToBillDialog extends JDialog {

	private JLabel datos;
	private JTextField quantityTextField;
	private JButton cancelButton;
	private JButton addButton;

	public AddProductToBillDialog(ActionListener listener) {
		initComponents(listener);
		setSize(300, 200);
		setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel wordlbl = new JLabel("Cantidad: ");
		wordlbl.setForeground(Color.BLACK);
		add(wordlbl, gbc);
		quantityTextField = new JTextField();
		quantityTextField.setText("1");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(quantityTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		datos = new JLabel();
		datos.setForeground(Color.BLACK);
		add(datos, gbc);

		JLabel a = new JLabel("             ");
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(a, gbc);

		addButton = new JButton("Agregar");
		addButton.addActionListener(listener);
		addButton.setActionCommand("AddProductToBill");
		addButton.setBackground(Color.WHITE);
		addButton.setForeground(Color.BLACK);
		addButton.setPreferredSize(new Dimension(200, 30));
		addButton.setFocusPainted(false);
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		add(addButton, gbc);

		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(listener);
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setForeground(Color.BLACK);
		cancelButton.setPreferredSize(new Dimension(200, 30));
		cancelButton.setFocusPainted(false);
		cancelButton.addActionListener(listener);
		cancelButton.setActionCommand("Cancelar");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		add(cancelButton, gbc);
	}

	public void setDatos(String datos) {
		this.datos.setText(datos);
	}

	public int getQuantity(int stock) {
		int quantity = 0;
		try {
			quantity = Integer.parseInt(quantityTextField.getText());
			if (quantity < 0) {
				JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida", "Caracteres invalidos:",
						JOptionPane.ERROR_MESSAGE);
				quantity = 0;
			}else if (quantity>stock){
				JOptionPane.showMessageDialog(null, "La cantidad excede al stock", "Caracteres invalidos:",
						JOptionPane.ERROR_MESSAGE);
				quantity = 0;
			}
		} catch (NumberFormatException excepcion) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros", "Caracteres invalidos:",
					JOptionPane.ERROR_MESSAGE);
			;
		}
		return quantity;
	}
}
