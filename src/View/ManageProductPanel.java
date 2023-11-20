package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ManageProductPanel extends JPanel{

    private TopPanel_ManagePanel topPanel_ManagePanel;
    private CenterPanel_ManageProductPanel centerPanel_ManagePanel;
    private BotPanel_ManagePanel botPanel_ManagePanel;

    public ManageProductPanel(ActionListener listener){
        initComponents(listener);
    }
    
    public void initComponents(ActionListener listener){
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
		topPanel_ManagePanel = new TopPanel_ManagePanel(listener);
		centerPanel_ManagePanel = new CenterPanel_ManageProductPanel(listener);
		botPanel_ManagePanel = new BotPanel_ManagePanel(listener);
        botPanel_ManagePanel.setAcceptButton("Crear Producto", "Crear_producto");
        botPanel_ManagePanel.setCleanButton("Modificar Producto", "Modificar_producto");
        botPanel_ManagePanel.setDeleteButtonButton("Eliminar Producto", "Eliminar_producto", listener);
		add(topPanel_ManagePanel, BorderLayout.NORTH);
		add(centerPanel_ManagePanel, BorderLayout.CENTER);
		add(botPanel_ManagePanel, BorderLayout.SOUTH);
    }

    public void loadDataTable(String[][] data) {
        centerPanel_ManagePanel.loadDataTable(data);
    }

    public int getIdProduct() {
        return centerPanel_ManagePanel.getIdProduct();
    }

    public String getNameProduct() {
        return centerPanel_ManagePanel.getNameProduct();
    }

	public String getPriceProduct() {
		return centerPanel_ManagePanel.getPriceProduct();
	}

	public String getQuantityProduct() {
		return centerPanel_ManagePanel.getQuantityProduct();
	}

    public String getTypeProduct(){
		return centerPanel_ManagePanel.getTypeProduct();
	}

	public String getMarkProduct(){
		return centerPanel_ManagePanel.getMarkProduct();
	}
}
