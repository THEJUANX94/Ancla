package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotPanel_ManagePanel extends JPanel {

    private JButton modifyButton;
    private JButton acceptButton;
    private JButton deleteButton;

    public BotPanel_ManagePanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setBackground(Color.WHITE);
        Color buttonColor = new Color(53, 152, 200);
        Color letra = Color.WHITE;

        deleteButton = new JButton();
        deleteButton.setPreferredSize(new Dimension(170, 30));
        deleteButton.setBackground(buttonColor);
        deleteButton.setForeground(letra);
        deleteButton.setSelected(false);
        deleteButton.setFocusable(false);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(listener);
        add(deleteButton);

        modifyButton = new JButton();
        modifyButton.setPreferredSize(new Dimension(170, 30));
        modifyButton.setBackground(buttonColor);
        modifyButton.setForeground(letra);
        modifyButton.setSelected(false);
        modifyButton.setFocusable(false);
        modifyButton.setBorderPainted(false);
        add(modifyButton);

        acceptButton = new JButton();
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
        modifyButton.setText(name);
        modifyButton.setActionCommand(comand);
    }

    public void setAcceptButton(String name, String comand){
        acceptButton.setText(name);
        acceptButton.setActionCommand(comand);
    }

    public void setDeleteButtonButton(String name, String comand){
        deleteButton.setText(name);
        deleteButton.setActionCommand(comand);
    }
}
