package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class DialogSeller extends JDialog {

  private static final long serialVersionUID = 1L;
  private TopPanel topPanel;
  private LeftPanel leftPanel;
  private CenterPanel centerPanel;

  public DialogSeller(ActionListener listener) {
    this.setSize(1280, 720);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    initComponents(listener);
    this.setVisible(true);
    initComponents(listener);
  }

  private void initComponents(ActionListener listener) {
    topPanel = new TopPanel();
    getContentPane().add(topPanel, BorderLayout.NORTH);
    leftPanel = new LeftPanel(listener);
    getContentPane().add(leftPanel, BorderLayout.WEST);
    centerPanel = new CenterPanel(listener);
    getContentPane().add(centerPanel, BorderLayout.CENTER);
  }

  public void show(String a) {
    centerPanel.show(a);
  }
}
