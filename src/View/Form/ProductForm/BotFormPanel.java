package View.Form.ProductForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotFormPanel extends JPanel {

    private JButton bttCancel;
    private JButton bttAcccept;

    public BotFormPanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        bttCancel = new JButton("Cancelar");
        bttCancel.setActionCommand("Cancelar");
        bttCancel.setPreferredSize(new Dimension(170, 30));
        bttCancel.setBackground(new Color(53, 152, 200));
        bttCancel.setForeground(Color.WHITE);
        bttCancel.setSelected(false);
        bttCancel.setFocusable(false);
        bttCancel.setBorderPainted(false);
        bttCancel.addActionListener(listener);
        add(bttCancel);

        bttAcccept = new JButton("Aceptar");
        bttAcccept.setActionCommand("Aceptar creacion Producto");
        bttAcccept.setPreferredSize(new Dimension(170, 30));
        bttAcccept.setBackground(new Color(53, 152, 200));
        bttAcccept.setForeground(Color.WHITE);
        bttAcccept.setSelected(false);
        bttAcccept.setFocusable(false);
        bttAcccept.setBorderPainted(false);
        bttAcccept.addActionListener(listener);
        add(bttAcccept);
    }

    public void setComand(String comand) {
        bttAcccept.setActionCommand(comand);
    }
}