package View.Form.TypeForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class DialogTypeForm extends JDialog {

  private static final long serialVersionUID = 1L;
  private TopTypeFormPanel topFormPanel;
  private BotTypeFormPanel botFormPanel;

  public DialogTypeForm(ActionListener listener) {
    this.setLayout(new BorderLayout());
    this.setBackground(Color.WHITE);
    this.setSize(450, 150);    this.setLocationRelativeTo(null);
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

  public String newTypeName() {
    return topFormPanel.newName();
  }
}
