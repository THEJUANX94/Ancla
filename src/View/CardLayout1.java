package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class CardLayout1 extends JPanel{

    private BillingPanel centerPanel1;
    private ManageProductPanel centerPanel2;
    private HistoryPanel historyPanel;
    private CardEmpty centerPanelVacio;
    private ManageBrandPanel manageBrandPanel;
    private ManageTypePanel manageTypePanel;

    private CardLayout cl;
    
    public CardLayout1(ActionListener listener, KeyListener keyListener){
        initComponents(listener, keyListener);
    }

    public void initComponents(ActionListener listener, KeyListener keyListener){
        this.setBackground(Color.WHITE);
        this.setLayout(new CardLayout());
        cl = (CardLayout) this.getLayout();
        centerPanel1 = new BillingPanel(listener, keyListener);
        centerPanel2 = new ManageProductPanel(listener);
        historyPanel = new HistoryPanel(listener);
        manageBrandPanel = new ManageBrandPanel(listener);
        manageTypePanel = new ManageTypePanel(listener);
        centerPanelVacio = new CardEmpty();

        add(centerPanelVacio);
        add(centerPanel1, "Boton_Facturacion");
        add(centerPanel2, "Boton_Gestionar");
        add(historyPanel, "Pestaña_Historial");
        add(manageBrandPanel, "Pestaña_GestionarMarca");
        add(manageTypePanel, "Pestaña_GestionarTipo");

    }

    public void show(String a) {
        cl.show(this, a);
    }

    public void loadDataTable1(String[][] data) {
		centerPanel1.loadDataTable1(data);
	}

    public void loadDataTable2() {
		centerPanel1.loadDataTable2();
	}

    public void loadDataTableManage(String[][] data) {
        centerPanel2.loadDataTable(data);
    }

    public void loadDataTableBrand(String[][] data) {
        manageBrandPanel.loadDataTable(data);
    }

    public void loadDataTableTypes(String[][] data) {
        manageTypePanel.loadDataTable(data);
    }

    public void loadDataHistory(String[][] data) {
        historyPanel.loadDataHistory(data);
    }

    public void getDate() {
        historyPanel.getDate();
    }

    public String[][] getItems() {
		return centerPanel1.getItems();
	}

    public int getQuantity(){
        return centerPanel1.getQuantity();
    }

    public void setTable2(){
		centerPanel1.setTable2();
	}

	public int getIdBill(){
        return historyPanel.getIdBill();
    }

    public void setHistoryTable(){
        historyPanel.setHistoryTable();
    }

    public void getConfirm(boolean confirm){
		centerPanel1.getConfirm(confirm);
	}

    public boolean confirmTabla2(){
		return centerPanel1.confirmTabla2();
	}

    public int getIdProduct() {
        return centerPanel2.getIdProduct();
    }

    public String getNameMark() {
        return manageBrandPanel.getNameMark();
    }

    public int getIdmark(){
        return manageBrandPanel.getIdmark();
    }

    public String getNameType() {
        return manageTypePanel.getNameType();
    }

    public int getIdType(){
        return manageTypePanel.getIdType();
    }

    public String getNameProduct() {
        return centerPanel2.getNameProduct();
    }

	public String getPriceProduct() {
		return centerPanel2.getPriceProduct();
	}

	public String getQuantityProduct() {
		return centerPanel2.getQuantityProduct();
	}

    public String getTypeProduct(){
		return centerPanel2.getTypeProduct();
	}

	public String getMarkProduct(){
		return centerPanel2.getMarkProduct();
	}

    public void quantityKeyReleased() {
		centerPanel1.quantityKeyReleased();
	}
}
