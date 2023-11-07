package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Views extends JFrame {

    private LoginPanel loginPanel;
    public DialogSeller dialogSeller;

    public Views(ActionListener listener) {
        super("Ancla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new BorderLayout());
        loginPanel = new LoginPanel(listener);
        dialogSeller = new DialogSeller(listener);
        dialogSeller.setVisible(false);
        this.getContentPane().add(loginPanel, BorderLayout.CENTER);
    }

    public String getTxtLoginUser(){
        return loginPanel.getTxtUser();
    }

    public String getTxtLoginPassword(){
        return loginPanel.getTxtPassword();
    }

    public void showMessageLogin(String message){
         JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void show1(String a) {
        dialogSeller.show(a);
      }
}
