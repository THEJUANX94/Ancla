package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class ManageTypePanel extends JPanel{

    private TopPanel_ManagePanel topPanel_ManagePanel;
    private BotPanel_ManagePanel botPanel_ManagePanel;
    private CenterPanel_ManageTypePanel centerPanel_ManageTypePanel;
    
    public ManageTypePanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		topPanel_ManagePanel = new TopPanel_ManagePanel(listener);
		botPanel_ManagePanel = new BotPanel_ManagePanel(listener);
        botPanel_ManagePanel.setAcceptButton("Crear Tipo", "Crear_Tipo");
        botPanel_ManagePanel.setCleanButton("Modificar Tipo", "Modificar_Tipo");
        botPanel_ManagePanel.setDeleteButtonButton("Eliminar Tipo", "Eliminar_Tipo");
        centerPanel_ManageTypePanel = new CenterPanel_ManageTypePanel(listener);
        add(topPanel_ManagePanel, BorderLayout.NORTH);
		add(centerPanel_ManageTypePanel, BorderLayout.CENTER);
        add(botPanel_ManagePanel, BorderLayout.SOUTH);

    }

    public void loadDataTable(String[][] data) {
        centerPanel_ManageTypePanel.loadDataTable(data);
    }
}
