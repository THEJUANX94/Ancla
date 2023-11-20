package View.Form.ProductForm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TopFormPanel extends JPanel {

    private JLabel lblName;
    private JLabel lblType;
    private JLabel lblPrice;
    private JLabel lblMark;
    private JTextField txtName;
    private JTextField txtPrice;
    private JComboBox<String> cbType;
    private JComboBox<String> cbMark;

    public TopFormPanel(ActionListener listener) {
        this.setLayout(new GridLayout(4, 2, 45, 20));
        this.setBorder(new TitledBorder("Info Producto"));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        lblName = new JLabel("Nombre Producto");
        lblName.setForeground(Color.BLACK);
        add(lblName);

        txtName = new JTextField();
        add(txtName);

        lblType = new JLabel("Tipo de producto");
        lblType.setForeground(Color.BLACK);
        add(lblType);

        cbType = new JComboBox<String>();
        add(cbType);

        lblMark = new JLabel("Marca");
        lblMark.setForeground(Color.BLACK);
        add(lblMark);

        cbMark = new JComboBox<String>();
        add(cbMark);

        lblPrice = new JLabel("Precio de venta");
        lblPrice.setForeground(Color.BLACK);
        add(lblPrice);

        txtPrice = new JTextField();
        add(txtPrice);
    }

    public void obtainedTypes(String[] types) {
        for (int i = 0; i < types.length; i++) {
            cbType.addItem(types[i]);
        }
    }

    public void obtainedmarks(String[] marks) {
        for (int i = 0; i < marks.length; i++) {
            cbMark.addItem(marks[i]);
        }
    }

    public String newName() {
        if (comprobateName() == false) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return txtName.getText();
    }

    public String selectedType() {
        return String.valueOf(cbType.getSelectedItem());
    }

    public String selectedMark() {
        return String.valueOf(cbMark.getSelectedItem());
    }

    public int selectedPrice() {
        if (comprobatePrice() == false) {
            return 0;
        } else {
            return Integer.parseInt(txtPrice.getText());
        }
    }

    public boolean comprobatePrice() {
        boolean confirm = true;
        if (txtPrice.getText().matches("[0-9]+") != true) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros en la cantidad", "Error",
                    JOptionPane.ERROR_MESSAGE);
            confirm = false;
        }
        return confirm;
    }

    public boolean comprobateName() {
        boolean confirm = true;
        if (txtName.getText().equals("")) {
            confirm = false;
        }
        return confirm;
    }
}
