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

	private JLabel nombre;
	private JLabel tipo;
	private JLabel marca;
	private JLabel precio;
	private JTextField quantityTextField;
	private JButton cancelButton;
	private JButton addButton;

	public AddProductToBillDialog(ActionListener listener) {
		initComponents(listener);
		setSize(300, 200);
		setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		setTitle("Agregar producto a la factura");
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		JLabel wordlbl = new JLabel("Cantidad: ");
		wordlbl.setForeground(Color.BLACK);
		add(wordlbl, gbc);
		quantityTextField = new JTextField();
		quantityTextField.setText("1");
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(quantityTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		nombre = new JLabel();
		nombre.setForeground(Color.BLACK);
		add(nombre, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		tipo = new JLabel();
		tipo.setForeground(Color.BLACK);
		add(tipo, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		marca = new JLabel();
		marca.setForeground(Color.BLACK);
		add(marca, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		precio = new JLabel();
		precio.setForeground(Color.BLACK);
		add(precio, gbc);

		JLabel a = new JLabel("             ");
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(a, gbc);

		JLabel b = new JLabel("             ");
		gbc.gridx = 1;
		gbc.gridy = 6;
		add(b, gbc);

		addButton = new JButton("Agregar");
		addButton.addActionListener(listener);
		addButton.setActionCommand("AddProductToBill");
		addButton.setBackground(Color.WHITE);
		addButton.setForeground(Color.BLACK);
		addButton.setPreferredSize(new Dimension(200, 30));
		addButton.setFocusPainted(false);
		gbc.gridy = 7;
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
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		add(cancelButton, gbc);
	}

	public void setDatos(String datos) {
		String[] datosArray = datos.split(",");
		this.nombre.setText("Nombre: " + datosArray[0]);
		this.tipo.setText("Tipo: " + datosArray[1]);
		this.marca.setText("Marca: " + datosArray[2]);
		this.precio.setText("Precio: " + datosArray[3]);
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
