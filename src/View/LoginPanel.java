package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JDialog {

    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel labelUser;
    private JLabel labelPasword;
    private JButton button;
    private JLabel labelImage;

    public LoginPanel(ActionListener listener) {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Image img = new ImageIcon("Images/logo.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(290, 290, Image.SCALE_SMOOTH));
        labelImage = new JLabel();
        labelImage.setIcon(img2);
        add(labelImage);
        labelUser = new JLabel("Usuario:");
        textField = new JTextField(20);
        labelPasword = new JLabel("Contraseña:");
        passwordField = new JPasswordField(20);
        button = new JButton("Ingresar");

        Font letra = new Font("Inter", Font.BOLD, 18);
        Font letra2 = new Font("Inter", Font.PLAIN, 16);
        Color color = new Color(135, 132, 132);

        labelUser.setFont(letra);
        labelUser.setForeground(color);

        labelPasword.setFont(letra);
        labelPasword.setForeground(color);

        textField.setFont(letra2);
        textField.setForeground(color);

        passwordField.setForeground(color);
        passwordField.setFont(letra2);

        button.setFont(letra);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(53, 152, 200));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(260, 45));
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelImage, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(labelPasword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel label = new JLabel("    ");
        add(label, gbc);

         gbc.gridx = 0;
        gbc.gridy = 6;
        add(button, gbc);

        button.setActionCommand("Ingresar");

        button.addActionListener(listener);
    }

    public String getTxtUser(){
        return textField.getText();
    }

    public String getTxtPassword(){
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        return password;
    }
}
