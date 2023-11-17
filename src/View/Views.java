package View;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.Form.ChooseImage;
import View.Form.DialogForm;

public class Views extends JFrame {

    public LoginPanel loginPanel;
    public SellerPanel dialogSeller;
    public DialogForm dialogForm;
    public ChooseImage chooseImage;

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
        chooseImage = new ChooseImage(listener);
        loginPanel.setVisible(true);
        dialogForm.setVisible(false);
        chooseImage.setVisible(false);
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
