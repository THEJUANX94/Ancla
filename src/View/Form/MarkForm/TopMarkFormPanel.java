package View.Form.MarkForm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TopMarkFormPanel extends JPanel{

    private JLabel lblName;
    private JLabel lblType;
    private JLabel lblPrice;
    private JLabel lblMark;
    private JTextField txtName;
    private JTextField txtPrice;
    private JComboBox<String> cbType;
    private JComboBox<String> cbMark;

    public TopMarkFormPanel(ActionListener listener){
        this.setLayout(new GridLayout(4, 2, 45, 45));
        this.setBorder(new TitledBorder("Info Producto"));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        lblName = new JLabel("Nombre Producto");
        lblName.setForeground(new Color(68,147,185));
        add(lblName);

        txtName = new JTextField();
        add(txtName);

        lblType = new JLabel("Tipo de producto");
        lblType.setForeground(new Color(68,147,185));
        add(lblType);

        cbType = new JComboBox<String>();
        add(cbType);

        lblMark = new JLabel("Marca");
        lblMark.setForeground(new Color(68,147,185));
        add(lblMark);

        cbMark = new JComboBox<String>();
        add(cbMark);

        lblPrice = new JLabel("Precio de venta");
        lblPrice.setForeground(new Color(68,147,185));
        add(lblPrice);

        txtPrice = new JTextField();
        add(txtPrice);
    }

    public void obtainedTypes(String[] types){
        for (int i = 0; i < types.length; i++) {
            cbType.addItem(types[i]);
        }
    }

    public void obtainedmarks(String[] marks){
        for (int i = 0; i < marks.length; i++) {
            cbMark.addItem(marks[i]);
        }
    }

    public String newName(){
        return txtName.getText();
    }

    public String selectedType(){
        return String.valueOf(cbType.getSelectedItem());
    }

    public String selectedMark(){
        return String.valueOf(cbMark.getSelectedItem());
    }

    public int selectedPrice(){
        return Integer.parseInt(txtPrice.getText());
    }

}
