package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ManagePanel extends JPanel{

    private TopPanel_ManagePanel topPanel_ManagePanel;
    private CenterPanel_ManagePanel centerPanel_ManagePanel;
    private BotPanel_ManagePanel botPanel_ManagePanel;

    public ManagePanel(ActionListener listener){
        initComponents(listener);
    }
    
    public void initComponents(ActionListener listener){
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
		topPanel_ManagePanel = new TopPanel_ManagePanel();
		centerPanel_ManagePanel = new CenterPanel_ManagePanel(listener);
		botPanel_ManagePanel = new BotPanel_ManagePanel(listener);
		add(topPanel_ManagePanel, BorderLayout.NORTH);
		add(centerPanel_ManagePanel, BorderLayout.CENTER);
		add(botPanel_ManagePanel, BorderLayout.SOUTH);
    }
}
