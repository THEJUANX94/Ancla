package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class SellerPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private TopPanel topPanel;
  private LeftPanel leftPanel;
  private CardLayout1 centerPanel;

  public SellerPanel(ActionListener listener) {
    initComponents(listener);
    initComponents(listener);
  }

  private void initComponents(ActionListener listener) {
    setLayout(new BorderLayout());
    topPanel = new TopPanel();
    add(topPanel, BorderLayout.NORTH);
    leftPanel = new LeftPanel(listener);
    add(leftPanel, BorderLayout.WEST);
    centerPanel = new CardLayout1(listener);
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
}
