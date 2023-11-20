package View.Form.MarkForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class DialogMarkForm extends JDialog {

  private static final long serialVersionUID = 1L;
  private TopMarkFormPanel topFormPanel;
  private BotMarkFormPanel botFormPanel;

  public DialogMarkForm(ActionListener listener) {
    this.setLayout(new BorderLayout());
    this.setBackground(Color.WHITE);
    this.setSize(450, 150);
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

  public String newMarkName() {
    return topFormPanel.newName();
  }
}
