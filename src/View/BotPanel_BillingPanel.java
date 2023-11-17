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
        cleanButton.setPreferredSize(new Dimension(170, 30));
        cleanButton.setBackground(buttonColor);
        cleanButton.setForeground(letra);
        cleanButton.setSelected(false);
        cleanButton.setFocusable(false);
        cleanButton.setBorderPainted(false);
        add(cleanButton);

        acceptButton = new JButton("Guardar");
        acceptButton.setPreferredSize(new Dimension(170, 30));
        acceptButton.setBackground(buttonColor);
        acceptButton.setForeground(letra);
        acceptButton.setSelected(false);
        acceptButton.setFocusable(false);
        acceptButton.setBorderPainted(false);
        add(acceptButton);

    }
}
