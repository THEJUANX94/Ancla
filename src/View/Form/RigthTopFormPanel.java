package View.Form;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RigthTopFormPanel extends JPanel{

    private JButton bttImage;
    private JLabel image;
    private JLabel lblimage;

    public RigthTopFormPanel(ActionListener listener){
        this.setLayout(new GridBagLayout());
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        GridBagConstraints gb = new GridBagConstraints();
        
        lblimage = new JLabel("Foto Producto");
        lblimage.setForeground(new Color(68,147,185));
        gb.gridx = 0;
        gb.gridy = 0;
        add(lblimage, gb);

        image = new JLabel();
        image.setIcon(new ImageIcon("C:\\Users\\Usuario\\OneDrive\\Escritorio\\Estudio\\Programacion_U\\Software1\\carpetapromediodeprogramacio\\Images\\logo.png"));
        gb.gridx = 0;
        gb.gridy = 1;
        add(image, gb);

        bttImage = new JButton("Cargar Imagen");
        bttImage.setBackground(new Color(53,152,200));
        bttImage.setForeground(Color.WHITE);
        gb.gridx = 0;
        gb.gridy = 4;
        bttImage.setActionCommand("Cargar Imagen");
        bttImage.addActionListener(listener);
        add(bttImage, gb);
    }

    public void setProductImage(String path){
        image.setIcon(new ImageIcon(path));
    }
    
}
