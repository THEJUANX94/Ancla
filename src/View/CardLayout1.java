package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CardLayout1 extends JPanel{

    private BillingPanel centerPanel1;
    private ManagePanel centerPanel2;
    private HistoryPanel historyPanel;
    private CardEmpty centerPanelVacio;

    private CardLayout cl;
    
    public CardLayout1(ActionListener listener){
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        this.setBackground(Color.WHITE);
        this.setLayout(new CardLayout());
        cl = (CardLayout) this.getLayout();
        centerPanel1 = new BillingPanel(listener);
        centerPanel2 = new ManagePanel(listener);
        historyPanel = new HistoryPanel(listener);
        centerPanelVacio = new CardEmpty();

        add(centerPanelVacio);
        add(centerPanel1, "Boton_Facturacion");
        add(centerPanel2, "Boton_Gestionar");
        add(historyPanel, "Pestaña_Historial");
    }

    public void show(String a) {
        cl.show(this, a);
    }
}
