package View;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ManagePanel extends JPanel{

    public ManagePanel(ActionListener listener){
        initComponents(listener);
    }
    
    public void initComponents(ActionListener listener){
        setBackground(Color.WHITE);
    }
}
