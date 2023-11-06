package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class CenterPanel1 extends JPanel {

	private TopPanel_CenterPanel topPanel_CenterPanel;
	private CenterPanel_CenterPanel1 centerPanel_CenterPanel;
	private BotPanel_CenterPanel1 botPanel_CenterPanel;

	public CenterPanel1(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		topPanel_CenterPanel = new TopPanel_CenterPanel(listener);
		centerPanel_CenterPanel = new CenterPanel_CenterPanel1(listener);
		botPanel_CenterPanel = new BotPanel_CenterPanel1(listener);
		add(topPanel_CenterPanel, BorderLayout.NORTH);
		add(centerPanel_CenterPanel, BorderLayout.CENTER);
		add(botPanel_CenterPanel, BorderLayout.SOUTH);
	}
}
