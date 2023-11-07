package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CenterPanel extends JPanel{

    private CenterPanel1 centerPanel1;
    private CenterPanel2 centerPanel2;
    private CardLayout cl;
    
    public CenterPanel(ActionListener listener){
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        this.setBackground(Color.WHITE);
        this.setLayout(new CardLayout());
        cl = (CardLayout) this.getLayout();
        centerPanel1 = new CenterPanel1(listener);
        centerPanel2 = new CenterPanel2(listener);

        add(centerPanel1, "Facturacion");
        add(centerPanel2, "Gestionar");
    }

    public void show(String a) {
        cl.show(this, a);
    }
}
