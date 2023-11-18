package View.Form.TypeForm;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotTypeFormPanel extends JPanel{

    private JButton bttCancel;
    private JButton bttAcccept;

    public BotTypeFormPanel(ActionListener listener){
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
        bttAcccept.setActionCommand("Aceptar creacion Tipo");
        bttAcccept.addActionListener(listener);
        add(bttAcccept);
    }
    
}