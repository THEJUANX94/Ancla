package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftPanel extends JPanel{

	private JButton editButton;
    private JButton saleButton;
    private JButton exitButton;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JLabel label18;
	private JLabel label19;
	private JLabel label20;


    public LeftPanel(ActionListener listener){
        initComponents(listener);
    }
    private void initComponents(ActionListener listener) {
        Color blue = new Color(68, 147, 185);
        setBackground(blue);
		label1 = new JLabel("       \n    	");
		label2 = new JLabel("       \n    	");
		label3 = new JLabel("       \n    	");
		label4 = new JLabel("       \n    	");
		label5 = new JLabel("       \n    	");
		label6 = new JLabel("       \n    	");
		label7 = new JLabel("       \n    	");
		label8 = new JLabel("       \n    	");
		label9 = new JLabel("       \n    	");
		label10 = new JLabel("       \n    	");
		label11 = new JLabel("       \n    	");
		label12 = new JLabel("       \n    	");
		label13 = new JLabel("       \n    	");
		label14 = new JLabel("       \n    	");
		label15 = new JLabel("       \n    	");
		label16 = new JLabel("       \n    	");
		label17 = new JLabel("       \n    	");
		label18 = new JLabel("       \n    	");
		label19 = new JLabel("       \n    	");
		label20 = new JLabel("       \n    	");
		setLayout(new GridBagLayout());
		GridBagConstraints gbl_LeftPanel = new GridBagConstraints();
		
        saleButton = new JButton();
		saleButton.setBackground(blue);
        saleButton.setSelected(false);
		saleButton.setFocusable(false);
		saleButton.setBorderPainted(false);
        Image saleImg = new ImageIcon("Images/logoSale.png").getImage();
        ImageIcon saleImage2 = new ImageIcon(saleImg.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        saleButton.setIcon(saleImage2);
		gbl_LeftPanel.gridx = 0;
		gbl_LeftPanel.gridy = 11;
		add(saleButton, gbl_LeftPanel);
		saleButton.setActionCommand("Boton_Facturacion");
		saleButton.addActionListener(listener);
		
		editButton = new JButton();
		editButton.setBackground(blue);
        editButton.setSelected(false);
		editButton.setFocusable(false);
		editButton.setBorderPainted(false);
        Image editImg = new ImageIcon("Images/logoEdit.png").getImage();
        ImageIcon editImage2 = new ImageIcon(editImg.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        editButton.setIcon(editImage2);
		gbl_LeftPanel.gridy = 12;
		add(editButton, gbl_LeftPanel);
		editButton.setActionCommand("Boton_Gestionar");
		editButton.addActionListener(listener);

		gbl_LeftPanel.gridy = 0;
		add(label1, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 1;
		add(label2, gbl_LeftPanel);gbl_LeftPanel.gridx = 0;
		gbl_LeftPanel.gridy = 2;
		add(label3, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 3;
		add(label4, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 4;
		add(label5, gbl_LeftPanel);gbl_LeftPanel.gridx = 0;
		gbl_LeftPanel.gridy = 5;
		add(label6, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 6;
		add(label7, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 7;
		add(label8, gbl_LeftPanel);gbl_LeftPanel.gridx = 0;
		gbl_LeftPanel.gridy = 8;
		add(label9, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 9;
		add(label10, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 10;
		add(label11, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 13;
		add(label12, gbl_LeftPanel);gbl_LeftPanel.gridx = 0;
		gbl_LeftPanel.gridy = 14;
		add(label13, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 15;
		add(label14, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 16;
		add(label15, gbl_LeftPanel);gbl_LeftPanel.gridx = 0;
		gbl_LeftPanel.gridy = 17;
		add(label16, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 18;
		add(label17, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 19;
		add(label18, gbl_LeftPanel);gbl_LeftPanel.gridx = 0;
		gbl_LeftPanel.gridy = 20;
		add(label19, gbl_LeftPanel);
		gbl_LeftPanel.gridy = 21;
		add(label20, gbl_LeftPanel);
		
		exitButton = new JButton();
        exitButton.setBackground(blue);
        exitButton.setSelected(false);
		exitButton.setFocusable(false);
		exitButton.setBorderPainted(false);
        Image exitImg = new ImageIcon("Images/logoSalir.png").getImage();
        ImageIcon exitImage2 = new ImageIcon(exitImg.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        exitButton.setIcon(exitImage2);
		gbl_LeftPanel.gridy = 22;
		add(exitButton, gbl_LeftPanel);
		exitButton.setActionCommand("Salir");
		exitButton.addActionListener(listener);
    }
}
