package View.Form.TypeForm;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TopTypeFormPanel extends JPanel{

    private JLabel lblName;
    private JTextField txtName;

    public TopTypeFormPanel(ActionListener listener){
        this.setLayout(new FlowLayout());
        this.setBorder(new TitledBorder("Info Tipo"));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        lblName = new JLabel("Nombre Tipo    ");
        lblName.setForeground(Color.BLACK);
        add(lblName);

        txtName = new JTextField();
        txtName.setColumns(30);
        add(txtName);
    }

    public String newName(){
        if(comprobateName() == false){
            JOptionPane.showMessageDialog(null, "Ingrese un nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return txtName.getText();
    }

    public boolean comprobateName(){
        boolean confirm = true;
        if(txtName.getText().equals("")){
            confirm = false;
        }        
        return confirm;
    }
}