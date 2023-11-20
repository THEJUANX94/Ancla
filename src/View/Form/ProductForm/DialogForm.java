package View.Form.ProductForm;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class DialogForm extends JDialog {

  private static final long serialVersionUID = 1L;
  private TopFormPanel topFormPanel;
  private BotFormPanel botFormPanel;

  public DialogForm(ActionListener listener) {
    this.setLayout(new BorderLayout());
    this.setSize(450, 300);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    initComponents(listener);
    this.setVisible(true);
  }

  private void initComponents(ActionListener listener) {
    topFormPanel = new TopFormPanel(listener);
    getContentPane().add(topFormPanel, BorderLayout.CENTER);
    botFormPanel = new BotFormPanel(listener);
    getContentPane().add(botFormPanel, BorderLayout.SOUTH);
  }

  public void obtainedTypes(String[] types) {
    topFormPanel.obtainedTypes(types);
  }

  public void obtainedMarks(String[] marks) {
    topFormPanel.obtainedmarks(marks);
  }

  public String newName() {
    return topFormPanel.newName();
  }

  public String selectedType() {
    return topFormPanel.selectedType();
  }

  public String selectedMark() {
    return topFormPanel.selectedMark();
  }

  public int selectedPrice() {
    return topFormPanel.selectedPrice();
  }

  public int selectedQuantity() {
    return topFormPanel.selectedQuantity();
  }

  public void setName(String name) {
    topFormPanel.setName(name);
  }

  public void setPrice(String price) {
    topFormPanel.setPrice(price);
  }

  public void setComand(String comand) {
    botFormPanel.setComand(comand);
  }

  public void setType(boolean confirm, String type) {
    topFormPanel.setType(confirm, type);
  }

  public void setType(boolean confirm) {
    topFormPanel.setType(confirm);
  }

  public void setMark(boolean confirm, String mark) {
    topFormPanel.setMark(confirm, mark);
  }

  public void setMark(boolean confirm) {
    topFormPanel.setMark(confirm);
  }

  public void setQuantity(String quantity) {
    topFormPanel.setQuantity(quantity);
  }
}
