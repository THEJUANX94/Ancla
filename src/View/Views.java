package View;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import View.Form.DialogForm;

public class Views extends JFrame {

    public LoginPanel loginPanel;
    public SellerPanel dialogSeller;
    public DialogForm dialogForm;

    public Views(ActionListener listener) {
        super("Ancla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
        this.setVisible(false);
    }

    private void initComponents(ActionListener listener) {
        loginPanel = new LoginPanel(listener);
        dialogSeller = new SellerPanel(listener);
        dialogForm = new DialogForm(listener);
        loginPanel.setVisible(true);
        dialogForm.setVisible(false);
        this.getContentPane().add(dialogSeller);
    }

    public String getTxtLoginUser() {
        return loginPanel.getTxtUser();
    }

    public String getTxtLoginPassword() {
        return loginPanel.getTxtPassword();
    }

    public void showMessageLogin(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void show1(String a) {
        dialogSeller.show(a);
    }

    public void loadDataTable1(String[][] data) {
        dialogSeller.loadDataTable1(data);
    }

    public void loadDataTable2() {
        dialogSeller.loadDataTable2();
    }
}
