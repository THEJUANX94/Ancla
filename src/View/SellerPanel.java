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
}
