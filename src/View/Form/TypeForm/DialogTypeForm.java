package View.Form.TypeForm;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class DialogTypeForm extends JDialog {

  private static final long serialVersionUID = 1L;
  private TopTypeFormPanel topFormPanel;
  private BotTypeFormPanel botFormPanel;

  public DialogTypeForm(ActionListener listener) {
    this.setLayout(new BorderLayout());
    this.setSize(750, 630);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    initComponents(listener);
    this.setVisible(true);
  }

  private void initComponents(ActionListener listener) {
    topFormPanel = new TopTypeFormPanel(listener);
    getContentPane().add(topFormPanel, BorderLayout.CENTER);
    botFormPanel = new BotTypeFormPanel(listener);
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
