package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class BillingPanel extends JPanel {

	private TopPanel_BillingPanel topPanel_CenterPanel;
	private CenterPanel_BillingPanel centerPanel_CenterPanel;
	private BotPanel_BillingPanel botPanel_CenterPanel;

	public BillingPanel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		topPanel_CenterPanel = new TopPanel_BillingPanel(listener);
		centerPanel_CenterPanel = new CenterPanel_BillingPanel(listener);
		botPanel_CenterPanel = new BotPanel_BillingPanel(listener);
		add(topPanel_CenterPanel, BorderLayout.NORTH);
		add(centerPanel_CenterPanel, BorderLayout.CENTER);
		add(botPanel_CenterPanel, BorderLayout.SOUTH);
	}
}
