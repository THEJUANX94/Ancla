package View;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.Form.ChooseImage;
import View.Form.DialogForm;

public class Views extends JFrame {

    public LoginPanel loginPanel;
    public SellerPanel sellerPanel;
    public DialogForm dialogForm;
    public ChooseImage chooseImage;

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
        chooseImage = new ChooseImage(listener);
        loginPanel.setVisible(true);
        dialogForm.setVisible(false);
        this.getContentPane().add(sellerPanel);
        chooseImage.setVisible(false);
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

    public void obtainedTypes(String[] types){
        dialogForm.obtainedTypes(types);
    }

    public void obtainedMarks(String[] marks){
        dialogForm.obtainedMarks(marks);
    }

    public String newName() {
        return dialogForm.newName();
    }

    public String selectedType() {
        return dialogForm.selectedType();
    }

    public String selectedMark() {
        return dialogForm.selectedMark();
    }

    public int selectedPrice(){
        return dialogForm.selectedPrice();
    }

    public void setProductImage(String path){
        dialogForm.setProductImage(path);
      }
}
