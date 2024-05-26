package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class SellerPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private TopPanel topPanel;
  private LeftPanel leftPanel;
  private CardLayout1 centerPanel;

  public SellerPanel(ActionListener listener, KeyListener keyListener) {
    initComponents(listener, keyListener);
  }

  private void initComponents(ActionListener listener, KeyListener keyListener) {
    setLayout(new BorderLayout());
    topPanel = new TopPanel();
    add(topPanel, BorderLayout.NORTH);
    leftPanel = new LeftPanel(listener);
    add(leftPanel, BorderLayout.WEST);
    centerPanel = new CardLayout1(listener, keyListener);
    add(centerPanel, BorderLayout.CENTER);
  }

  public void show(String a) {
    centerPanel.show(a);
  }

  public void loadDataTable1(String[][] data) {
    centerPanel.loadDataTable1(data);
  }

  public void loadDataTable2() {
    centerPanel.loadDataTable2();
  }

  public void loadDataTableManage(String[][] data) {
    centerPanel.loadDataTableManage(data);
  }

  public void loadDataTableBrand(String[][] data) {
    centerPanel.loadDataTableBrand(data);
  }

  public void loadDataTableTypes(String[][] data) {
    centerPanel.loadDataTableTypes(data);
  }

  public void loadDataHistory(String[][] data) {
    centerPanel.loadDataHistory(data);
  }

  public void getDate() {
    centerPanel.getDate();
  }

  public String[][] getItems() {
    return centerPanel.getItems();
  }

  public int getQuantity() {
    return centerPanel.getQuantity();
  }

  public void setTable2() {
    centerPanel.setTable2();
  }

  public int getIdBill() {
    return centerPanel.getIdBill();
  }

  public void setHistoryTable() {
    centerPanel.setHistoryTable();
  }

  public void getConfirm(boolean confirm) {
    centerPanel.getConfirm(confirm);
  }

  public boolean confirmTabla2() {
    return centerPanel.confirmTabla2();
  }

  public int getIdProduct() {
    return centerPanel.getIdProduct();
  }

  public String getNameMark() {
    return centerPanel.getNameMark();
  }

  public int getIdmark() {
    return centerPanel.getIdmark();
  }

  public String getNameType() {
    return centerPanel.getNameType();
  }

  public int getIdType() {
    return centerPanel.getIdType();
  }

  public String getNameProduct() {
    return centerPanel.getNameProduct();
  }

  public String getPriceProduct() {
    return centerPanel.getPriceProduct();
  }

  public String getQuantityProduct() {
    return centerPanel.getQuantityProduct();
  }

  public String getTypeProduct(){
		return centerPanel.getTypeProduct();
	}

	public String getMarkProduct(){
		return centerPanel.getMarkProduct();
	}

  public void quantityKeyReleased() {
		centerPanel.quantityKeyReleased();
	}
}
