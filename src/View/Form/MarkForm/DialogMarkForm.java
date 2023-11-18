package View.Form.MarkForm;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class DialogMarkForm extends JDialog {

  private static final long serialVersionUID = 1L;
  private TopMarkFormPanel topFormPanel;
  private BotMarkFormPanel botFormPanel;

  public DialogMarkForm(ActionListener listener) {
    this.setLayout(new BorderLayout());
    this.setSize(750, 630);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    initComponents(listener);
    this.setVisible(true);
  }

  private void initComponents(ActionListener listener) {
    topFormPanel = new TopMarkFormPanel(listener);
    getContentPane().add(topFormPanel, BorderLayout.CENTER);
    botFormPanel = new BotMarkFormPanel(listener);
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
