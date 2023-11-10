package View.Form;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class LeftFormPanel extends JPanel{

    private TopLeftFormPanel topRightFormPanel;
    private BotLeftFormPanel botRightFormPanel;

    public LeftFormPanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        topRightFormPanel = new TopLeftFormPanel(listener);
        add(topRightFormPanel);
        botRightFormPanel =  new BotLeftFormPanel();
        add(botRightFormPanel);
    }

}
