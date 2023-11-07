package View;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotPanel_CenterPanel1 extends JPanel{

    private JButton cleanButton;
    private JButton saleButton;
    private JButton acceptButton;
    
    public BotPanel_CenterPanel1(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
		setBackground(Color.WHITE);
        Color buttonColor = new Color(53, 152, 200);
        Color letra = Color.WHITE;
		
		cleanButton = new JButton("Limpiar");
        cleanButton.setBackground(buttonColor);
		cleanButton.setForeground(letra);
        cleanButton.setSelected(false);
		cleanButton.setFocusable(false);
		cleanButton.setBorderPainted(false);
		add(cleanButton);
		
		saleButton = new JButton("Generar Factura");
        saleButton.setBackground(buttonColor);
		saleButton.setForeground(letra);
        saleButton.setSelected(false);
		saleButton.setFocusable(false);
		saleButton.setBorderPainted(false);
		add(saleButton);
		
		acceptButton = new JButton("Guardar");
        acceptButton.setBackground(buttonColor);
		acceptButton.setForeground(letra);
        acceptButton.setSelected(false);
		acceptButton.setFocusable(false);
		acceptButton.setBorderPainted(false);
		add(acceptButton);
		
    }
}
