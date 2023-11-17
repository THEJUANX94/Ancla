package View;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import View.Form.DialogForm;

public class Views extends JFrame {

    public LoginPanel loginPanel;
    public SellerPanel sellerPanel;
    public DialogForm dialogForm;

    public Views(ActionListener listener) {
        super("Ancla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
        this.setVisible(false);
    }

    private void initComponents(ActionListener listener) {
        loginPanel = new LoginPanel(listener);
        sellerPanel = new SellerPanel(listener);
        dialogForm = new DialogForm(listener);
        loginPanel.setVisible(true);
        dialogForm.setVisible(false);
        this.getContentPane().add(sellerPanel);
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
        sellerPanel.show(a);
    }

    public void loadDataTable1(String[][] data) {
        sellerPanel.loadDataTable1(data);
    }

    public void loadDataTable2() {
        sellerPanel.loadDataTable2();
    }

    public void loadDataTableManage(String[][] data) {
        sellerPanel.loadDataTableManage(data);   
    }

    public int getQuantity(){
        return sellerPanel.getQuantity();
    }
}
