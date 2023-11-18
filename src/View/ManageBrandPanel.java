package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ManageBrandPanel extends JPanel{

    private TopPanel_ManagePanel topPanel_ManagePanel;
    private BotPanel_ManagePanel botPanel_ManagePanel;
    private CenterPanel_ManageBrandPanel centerPanel_ManageBrandPanel;
    
    public ManageBrandPanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		topPanel_ManagePanel = new TopPanel_ManagePanel(listener);
        botPanel_ManagePanel = new BotPanel_ManagePanel(listener);
        botPanel_ManagePanel.setAcceptButton("Crear Marca", "Crear_Marca");
        botPanel_ManagePanel.setCleanButton("Modificar Marca", "TOOL_TIP_TEXT_KEY");
        centerPanel_ManageBrandPanel = new CenterPanel_ManageBrandPanel(listener);
        add(topPanel_ManagePanel, BorderLayout.NORTH);
		add(centerPanel_ManageBrandPanel, BorderLayout.CENTER);
        add(botPanel_ManagePanel, BorderLayout.SOUTH);
    }

    public void loadDataTable(String[][] data) {
        centerPanel_ManageBrandPanel.loadDataTable(data);
    }
}
