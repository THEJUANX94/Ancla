package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class BillingPanel extends JPanel {

	private TopPanel_BillingPanel topPanel_BillingPanel;
	private CenterPanel_BillingPanel centerPanel_BillingPanel;
	private BotPanel_BillingPanel botPanel_BillingPanel;

	public BillingPanel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		topPanel_BillingPanel = new TopPanel_BillingPanel(listener);
		centerPanel_BillingPanel = new CenterPanel_BillingPanel(listener);
		botPanel_BillingPanel = new BotPanel_BillingPanel(listener);
		add(topPanel_BillingPanel, BorderLayout.NORTH);
		add(centerPanel_BillingPanel, BorderLayout.CENTER);
		add(botPanel_BillingPanel, BorderLayout.SOUTH);
	}

	public void loadDataTable1(String[][] data) {
		centerPanel_BillingPanel.loadDataTable1(data);
	}

	public void loadDataTable2() {
		centerPanel_BillingPanel.loadDataTable2();
	}

	public String[][] getItems() {
		return centerPanel_BillingPanel.getItems();
	}

	public int getQuantity(){
		return centerPanel_BillingPanel.getQuantity();
	}

	public void setTable2(){
		centerPanel_BillingPanel.setTable2();
	}

	public void getConfirm(boolean confirm){
		centerPanel_BillingPanel.getConfirm(confirm);
	}

	public boolean confirmTabla2(){
		return centerPanel_BillingPanel.confirmTabla2();
	}
}
