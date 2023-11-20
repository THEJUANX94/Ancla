package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class DeleteDialog extends JDialog {

    private JLabel confirmLabel;
    private JButton acceptButton;
    private JButton cancelButton;

    public DeleteDialog(ActionListener listener) {
        setSize(290, 180);
        this.setResizable(false);
        setLocationRelativeTo(null);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());
        Color buttonColor = new Color(53, 152, 200);
        Color letra = Color.WHITE;

        confirmLabel = new JLabel("¿Esta seguro que desea eliminar?");
        confirmLabel.setForeground(Color.BLACK);
        add(confirmLabel);

        acceptButton = new JButton("Aceptar");
        acceptButton.setActionCommand("Aceptar_Eliminar_Producto");
        acceptButton.setPreferredSize(new Dimension(170, 30));
        acceptButton.setBackground(buttonColor);
        acceptButton.setForeground(letra);
        acceptButton.setSelected(false);
        acceptButton.setFocusable(false);
        acceptButton.setBorderPainted(false);
        acceptButton.addActionListener(listener);
        add(acceptButton);

        cancelButton = new JButton("Cancelar");
        cancelButton.setActionCommand("Cancelar");
        cancelButton.setPreferredSize(new Dimension(170, 30));
        cancelButton.setBackground(buttonColor);
        cancelButton.setForeground(letra);
        cancelButton.setSelected(false);
        cancelButton.setFocusable(false);
        cancelButton.setBorderPainted(false);
        cancelButton.addActionListener(listener);
        add(cancelButton);
    }
}
