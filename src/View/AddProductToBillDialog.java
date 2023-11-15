package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddProductToBillDialog extends JDialog{

	private JLabel datos;
    private JTextField deletTextField;
    private JButton cancel;
    private JButton button;
    
    public AddProductToBillDialog(ActionListener listener){
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
		deletTextField = new JTextField();
        gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(deletTextField, gbc);

        JLabel a = new JLabel("             ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(a, gbc);

		datos = new JLabel();
		add(datos, gbc);

        button = new JButton("Agregar");
        button.addActionListener(listener);
        button.setActionCommand("AddProductToBill");
        button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setPreferredSize(new Dimension(200, 30));
		button.setFocusPainted(false);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(button, gbc);

        cancel = new JButton("Cancelar");
		cancel.addActionListener(listener);
		cancel.setBackground(Color.WHITE);
		cancel.setForeground(Color.BLACK);
		cancel.setPreferredSize(new Dimension(200, 30));
		cancel.setFocusPainted(false);
		cancel.addActionListener(listener);
		cancel.setActionCommand("Cancel");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		add(cancel, gbc);
    }

	public void setDatos(String datos) {
		this.datos.setText(datos);
	}

    public String getWordDelete(){
        return deletTextField.getText();
    }

    public boolean comprobateWord(){
		return deletTextField.getText().matches("[0-9]+");
	}
}
