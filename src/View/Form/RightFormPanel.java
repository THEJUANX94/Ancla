package View.Form;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RightFormPanel extends JPanel{

    private RigthTopFormPanel rigthTopFormPanel;
    private RigthBotFormPanel rigthBotFormPanel;

    public RightFormPanel(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        GridBagConstraints gb = new GridBagConstraints();
        
        rigthTopFormPanel = new RigthTopFormPanel(listener);
        gb.gridy = 0;
        gb.gridx = 0;
        add(rigthTopFormPanel, gb);

        rigthBotFormPanel = new RigthBotFormPanel(listener);
        gb.gridy = 1;
        add(rigthBotFormPanel, gb);
    }

    public void setProductImage(String path){
        rigthTopFormPanel.setProductImage(path);
    }

}
