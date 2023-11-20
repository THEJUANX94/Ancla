package View;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import View.Form.ProductForm.DialogForm;
import View.Form.MarkForm.DialogMarkForm;
import View.Form.TypeForm.DialogTypeForm;

public class Views extends JFrame {

    public LoginPanel loginPanel;
    public SellerPanel sellerPanel;
    public DialogForm dialogForm;
    public DialogMarkForm dialogMarkForm;
    public DialogTypeForm dialogTypeForm;
    public ItemsDialog itemsDialog;
    public DeleteDialog deleteDialog;

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
        dialogMarkForm = new DialogMarkForm(listener);
        dialogTypeForm = new DialogTypeForm(listener);  
        itemsDialog = new ItemsDialog(listener);
        deleteDialog = new DeleteDialog(listener);
        loginPanel.setVisible(true);
        dialogForm.setVisible(false);
        dialogMarkForm.setVisible(false);
        dialogTypeForm.setVisible(false);
        itemsDialog.setVisible(false);
        deleteDialog.setVisible(false);
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

    public void loadDataTableBrand(String[][] data) {
        sellerPanel.loadDataTableBrand(data);
    }

    public void loadDataTableType(String[][] data) {
        sellerPanel.loadDataTableTypes(data);
    }

    public void loadDataHistory(String[][] data) {
        sellerPanel.loadDataHistory(data);
    }

    public String[][] getItems() {
		return sellerPanel.getItems();
	}

    public void getDate() {
        sellerPanel.getDate();
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

    public String newMarkName(){
        return dialogMarkForm.newMarkName();
    }

    public String newTypeName(){
        return dialogTypeForm.newTypeName();
    }

    public void setTable2(){
		sellerPanel.setTable2();
	}

    public void getItemList(String[][] itemlist){
		itemsDialog.getItemList(itemlist);
	}

	public int getIdBill(){
        return sellerPanel.getIdBill();
    }
    
    public void setHistoryTable(){
        sellerPanel.setHistoryTable();
    }

    public void getConfirm(boolean confirm){
		sellerPanel.getConfirm(confirm);
	}

    public boolean confirmTabla2(){
		return sellerPanel.confirmTabla2();
	}

    public int getIdProduct() {
        return sellerPanel.getIdProduct();
    }
}
