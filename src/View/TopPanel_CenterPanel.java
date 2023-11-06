package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TopPanel_CenterPanel extends JPanel{

    private JButton saleButton;
    private JButton historyButton;
    
    public TopPanel_CenterPanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setBackground(Color.WHITE);
		Color pestaña = new Color(234, 230, 230);
		Color letra = new Color(130, 130, 130);
		GridBagLayout gbl_TopPanel_CenterPanel = new GridBagLayout();
		gbl_TopPanel_CenterPanel.columnWidths = new int[]{81, 89, 89, 0};
		gbl_TopPanel_CenterPanel.rowHeights = new int[]{23, 0};
		gbl_TopPanel_CenterPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_TopPanel_CenterPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gbl_TopPanel_CenterPanel);
		
		saleButton = new JButton("Facturacion");
		saleButton.setBackground(pestaña);
		saleButton.setForeground(letra);
        saleButton.setSelected(false);
		saleButton.setFocusable(false);
		saleButton.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 0;
		add(saleButton, gbc_btnNewButton_4);
		
		historyButton = new JButton("Historial");
		historyButton.setBackground(pestaña);
		historyButton.setForeground(letra);
        historyButton.setSelected(false);
		historyButton.setFocusable(false);
		historyButton.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 0;
		add(historyButton, gbc_btnNewButton_5);
    }
}
