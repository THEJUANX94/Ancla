package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel{

    private JLabel labelImage;

    public TopPanel(){
        setLayout(new BorderLayout());
        setBackground(new Color(68, 147, 185));
		Image img = new ImageIcon("data\\Images\\LogoCabecera.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(240, 97, Image.SCALE_SMOOTH));
        labelImage = new JLabel();
        labelImage.setIcon(img2);
        add(labelImage, BorderLayout.WEST);
    }
    
}