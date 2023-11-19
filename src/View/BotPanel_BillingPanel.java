package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BotPanel_BillingPanel extends JPanel {

    private JButton cleanButton;
    private JButton acceptButton;

    public BotPanel_BillingPanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setBackground(Color.WHITE);
        Color buttonColor = new Color(53, 152, 200);
        Color letra = Color.WHITE;

        cleanButton = new JButton("Cancelar");
        cleanButton.setActionCommand("Cancelar_venta");
        cleanButton.setPreferredSize(new Dimension(170, 30));
        cleanButton.setBackground(buttonColor);
        cleanButton.setForeground(letra);
        cleanButton.setSelected(false);
        cleanButton.setFocusable(false);
        cleanButton.setBorderPainted(false);
        cleanButton.addActionListener(listener);
        add(cleanButton);

        acceptButton = new JButton("Aceptar");
        acceptButton.setActionCommand("Aceptar_venta");
        acceptButton.setPreferredSize(new Dimension(170, 30));
        acceptButton.setBackground(buttonColor);
        acceptButton.setForeground(letra);
        acceptButton.setSelected(false);
        acceptButton.setFocusable(false);
        acceptButton.setBorderPainted(false);
        acceptButton.addActionListener(listener);
        add(acceptButton);
    }

    public void setCleanButton(String name, String comand){
        cleanButton.setText(name);
        cleanButton.setActionCommand(comand);
    }

    public void setAcceptButton(String name, String comand){
        acceptButton.setText(name);
        acceptButton.setActionCommand(comand);
    }
}
