package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardEmpty extends JPanel {

    public CardEmpty() {
        initComponents();
    }

    private void initComponents() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JPanel toPanel = new JPanel();
        JPanel centPanel = new JPanel();
        JPanel botPanel = new JPanel();

        add(toPanel, BorderLayout.NORTH);
        add(centPanel, BorderLayout.CENTER);
        add(botPanel, BorderLayout.SOUTH);

        toPanel.setBackground(Color.WHITE);
        centPanel.setBackground(Color.WHITE);
        botPanel.setBackground(Color.WHITE);

        JLabel label = new JLabel("                        ");
        label.setPreferredSize(new Dimension(500, 100));
        toPanel.add(label);

        Image img = new ImageIcon("Images/logo.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(290, 290, Image.SCALE_SMOOTH));
        JLabel labelImage = new JLabel();
        labelImage.setIcon(img2);
        centPanel.add(labelImage);
    }
}
