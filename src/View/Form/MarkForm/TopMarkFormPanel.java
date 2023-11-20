package View.Form.MarkForm;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TopMarkFormPanel extends JPanel{

    private JLabel lblName;
    private JTextField txtName;

    public TopMarkFormPanel(ActionListener listener){
        this.setLayout(new GridBagLayout());
        this.setBorder(new TitledBorder("Info Marca"));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        GridBagConstraints gb = new GridBagConstraints();
        lblName = new JLabel("Nombre Marca");
        lblName.setForeground(new Color(68,147,185));
        gb.gridx = 5;
        gb.gridy = 0;
        add(lblName, gb);

        txtName = new JTextField();
        txtName.setColumns(50);
        gb.gridx = 5;
        gb.gridy = 5;
        add(txtName, gb);
    }

    public String newName(){
        return txtName.getText();
    }
}