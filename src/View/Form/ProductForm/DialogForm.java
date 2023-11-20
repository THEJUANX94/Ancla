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
    this.setSize(450, 260);
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

  public void obtainedTypes(String[] types){
    topFormPanel.obtainedTypes(types);
  }

  public void obtainedMarks(String[] marks){
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

  public int selectedPrice(){
    return topFormPanel.selectedPrice();
  }
}
