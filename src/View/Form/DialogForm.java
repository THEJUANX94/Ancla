package View.Form;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class DialogForm extends JDialog {

    private static final long serialVersionUID = 1L;
    private LeftFormPanel leftFormPanel;
    private RightFormPanel rightFormPanel;

    public DialogForm(ActionListener listener) {
        this.setSize(1050, 630);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
        this.setVisible(true);
      }
    
      private void initComponents(ActionListener listener) {
        leftFormPanel = new LeftFormPanel(listener);
        getContentPane().add(leftFormPanel, BorderLayout.WEST);
        rightFormPanel = new RightFormPanel(listener);
        getContentPane().add(rightFormPanel, BorderLayout.EAST);
      }
}
