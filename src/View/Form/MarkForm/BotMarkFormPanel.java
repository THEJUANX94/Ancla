package View.Form.MarkForm;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotMarkFormPanel extends JPanel{

    private JButton bttCancel;
    private JButton bttAcccept;

    public BotMarkFormPanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        bttCancel = new JButton("Cancelar");
        bttCancel.setActionCommand("Cancelar");
        bttCancel.addActionListener(listener);
        bttCancel.setBackground(new Color(53,152,200));
        bttCancel.setForeground(Color.WHITE);
        add(bttCancel);

        bttAcccept = new JButton("Aceptar");
        bttAcccept.setBackground(new Color(53,152,200));
        bttAcccept.setForeground(Color.WHITE);
        bttAcccept.setActionCommand("Aceptar creacion Marca");
        bttAcccept.addActionListener(listener);
        add(bttAcccept);
    }
    
}