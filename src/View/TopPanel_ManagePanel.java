package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TopPanel_ManagePanel extends JPanel {

	private JButton manageProduct;
	private JButton manageType;
	private JButton manageBrand;

	public TopPanel_ManagePanel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setBackground(Color.WHITE);
		Color pestaña = new Color(234, 230, 230);
		Color letra = new Color(130, 130, 130);
		GridBagLayout gbl_TopPanel_CenterPanel = new GridBagLayout();
		gbl_TopPanel_CenterPanel.columnWidths = new int[] { 81, 89, 89, 0 };
		gbl_TopPanel_CenterPanel.rowHeights = new int[] { 23, 0 };
		gbl_TopPanel_CenterPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_TopPanel_CenterPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gbl_TopPanel_CenterPanel);

		manageProduct = new JButton("Gestionar Producto");
		manageProduct.setPreferredSize(new Dimension(170, 20));
		manageProduct.setBackground(pestaña);
		manageProduct.setForeground(letra);
		manageProduct.setSelected(false);
		manageProduct.setFocusable(false);
		manageProduct.setBorderPainted(false);
		manageProduct.addActionListener(listener);
		manageProduct.setActionCommand("Pestaña_Gestionar_Producto");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 0;
		add(manageProduct, gbc_btnNewButton_4);

		manageType = new JButton("Gestionar Tipo");
		manageType.setPreferredSize(new Dimension(170, 20));
		manageType.setBackground(pestaña);
		manageType.setForeground(letra);
		manageType.setSelected(false);
		manageType.setFocusable(false);
		manageType.setBorderPainted(false);
		manageType.addActionListener(listener);
		manageType.setActionCommand("Pestaña_Gestionar_Tipo");
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.NORTHWEST;
		gbc2.insets = new Insets(0, 0, 0, 5);
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		add(manageType, gbc2);

		manageBrand = new JButton("Gestionar Marca");
		manageBrand.setPreferredSize(new Dimension(170, 20));
		manageBrand.setBackground(pestaña);
		manageBrand.setForeground(letra);
		manageBrand.setSelected(false);
		manageBrand.setFocusable(false);
		manageBrand.setBorderPainted(false);
		manageBrand.addActionListener(listener);
		manageBrand.setActionCommand("Pestaña_Gestionar_Marca");
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.anchor = GridBagConstraints.NORTHWEST;
		gbc3.insets = new Insets(0, 0, 0, 5);
		gbc3.gridx = 2;
		gbc3.gridy = 0;
		add(manageBrand, gbc3);
	}
}