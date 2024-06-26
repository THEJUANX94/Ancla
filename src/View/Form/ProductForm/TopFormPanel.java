package View.Form.ProductForm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

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
    private JLabel lblQuantity;
    private JTextField txtQuantity;
    private JTextField txtPrice;
    private JComboBox<String> cbType;
    private JComboBox<String> cbMark;

    public TopFormPanel(ActionListener listener, KeyEvent evt, KeyListener keyListener) {
        this.setLayout(new GridLayout(5, 2, 45, 20));
        this.setBorder(new TitledBorder("Info Producto"));
        initComponents(listener, evt, keyListener);
    }

    private void initComponents(ActionListener listener, KeyEvent evt, KeyListener keyListener) {
        lblName = new JLabel("Nombre Producto:");
        lblName.setForeground(Color.BLACK);
        add(lblName);

        txtName = new JTextField();
        add(txtName);

        lblType = new JLabel("Tipo de producto:");
        lblType.setForeground(Color.BLACK);
        add(lblType);

        cbType = new JComboBox<String>();
        add(cbType);

        lblMark = new JLabel("Marca:");
        lblMark.setForeground(Color.BLACK);
        add(lblMark);

        cbMark = new JComboBox<String>();
        add(cbMark);

        lblPrice = new JLabel("Precio de venta:");
        lblPrice.setForeground(Color.BLACK);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.addKeyListener(keyListener);
        add(txtPrice);

        lblQuantity = new JLabel("Cantidad:");
        lblQuantity.setForeground(Color.BLACK);
        add(lblQuantity);

        txtQuantity = new JTextField();
        txtQuantity.addKeyListener(keyListener);
        add(txtQuantity);
    }

    public void obtainedTypes(String[] types) {
        cbType.removeAllItems();
        for (int i = 0; i < types.length; i++) {
            cbType.addItem(types[i]);
        }
    }

    public void obtainedmarks(String[] marks) {
        cbMark.removeAllItems();
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
            return Integer.parseInt(txtPrice.getText().replaceAll("\\D", ""));
        }
    }

    public int selectedQuantity() {
        if (comprobateQuantity() == false) {
            return 0;
        } else {
            return Integer.parseInt(txtQuantity.getText().replaceAll("\\D", ""));
        }
    }

    public boolean comprobatePrice() {
        boolean confirm = true;
        if ((txtPrice.getText().replaceAll("\\D", "")).matches("[0-9]+") != true) {
            JOptionPane.showMessageDialog(null, "Ingrese un precio valido: Ej. 20000", "Error",
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

    public boolean comprobateQuantity() {
        boolean confirm = true;
        if ((txtQuantity.getText().replaceAll("\\D", "")).matches("[0-9]+") != true) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida: Ej. 5 ", "Error",
                    JOptionPane.ERROR_MESSAGE);
            confirm = false;
        }
        return confirm;
    }

    public void setName(String name) {
        txtName.setText(name);
    }

    public void setPrice(String price) {
        txtPrice.setText(price);
    }

    public void setType(boolean confirm, String type) {
        cbType.removeAllItems();
        cbType.addItem(type);
        cbType.setEnabled(confirm);
    }

    public void setType(boolean confirm) {
        cbType.setEnabled(confirm);
    }

    public void setMark(boolean confirm, String mark) {
        cbMark.removeAllItems();
        cbMark.addItem(mark);
        cbMark.setEnabled(confirm);
    }

    public void setMark(boolean confirm) {
        cbMark.setEnabled(confirm);
    }

    public void setQuantity(String quantity) {
        txtQuantity.setText(quantity);
    }

    public void txtpriceKeyReleased() {
        DecimalFormat df = new DecimalFormat("#,###");
        if (txtPrice.getText().length() >= 1) {
            txtPrice.setText( df.format(Integer.valueOf(txtPrice.getText().replace(".", "").replace(",", ""))) );
        }
    }

    public void txtquantityKeyReleased() {
        DecimalFormat df = new DecimalFormat("#,###");
        if (txtQuantity.getText().length() >= 1) {
            txtQuantity.setText( df.format(Integer.valueOf(txtQuantity.getText().replace(".", "").replace(",", ""))) );
        }
    }

    public void txtpriceKeyTyped(java.awt.event.KeyEvent evt){
        if(txtPrice.getText().length() >= 10){
            evt.consume();
        }
    }
    
    public void txtquantityKeyTyped(java.awt.event.KeyEvent evt){
        if(txtQuantity.getText().length() >= 10){
            evt.consume();
        }
    } 
}
